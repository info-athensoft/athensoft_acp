package com.athensoft.content.event.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.entity.News;
import com.athensoft.content.event.service.EventMediaService;
import com.athensoft.content.event.service.NewsService;
import com.athensoft.util.id.UUIDHelper;

/**
 * News Controller for ACP
 * @author Athens
 * @version 1.0
 */
@Controller
public class NewsAcpController {
	
	private static final Logger logger = Logger.getLogger(NewsAcpController.class);
	
	private static final String ACTION_EDIT = "Edit";
	private static final String ACTION_DELETE = "Delete";
	
	/**
	 * News Service instance
	 */
	private NewsService newsService;
	
	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	/**
	 * EventReview Service instance
	 */
//	private EventReviewService eventReviewService;
//		
//	@Autowired
//	public void setEventReviewService(EventReviewService eventReviewService) {
//		this.eventReviewService = eventReviewService;
//	}
	
	/**
	 * EventMedia Service instance
	 */
	private EventMediaService eventMediaService;
	
	@Autowired
	public void setEventMediaService(EventMediaService eventMediaService) {
		this.eventMediaService = eventMediaService;
	}
	
	
	/**
	 * go to the view of event dashboard
	 * @return the target view name
	 */
	@RequestMapping(value="/event/dashboard")
	public String gotoDashboard(){
		String viewName = "event/event_dashboard";
		return viewName;
	}
	
	
	/**
	 * go to the view of news listing
	 * @return the target view name 
	 */
	@RequestMapping(value="/events/eventsNewsList")
	public String gotoNewsList(){
		String viewName = "event/event_news_list";
		return viewName;
	}
	
	/**
	 * go to the view of news creating
	 * @return the target view name 
	 */
	@RequestMapping(value="/events/eventsNewsCreate")
	public String gotoNewsCreate(){
		String viewName = "event/event_news_create";
		return viewName;
	}
	
	
	/**
	 * goto event-news edit page with data for updating
	 * @param eventUUID the eventUUID of new object selected
	 * @return data of news object, event media objects, and target view
	 */
	@RequestMapping(value="/events/eventsNewsEdit")
	public ModelAndView gotoNewsEdit(@RequestParam String eventUUID){
		logger.info("entering /event/eventsNewsEdit");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "event/event_news_edit";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		//data - news
		News news = newsService.getNewsByEventUUID(eventUUID);	
		model.put("newsObject", news);
		
		//data - media
		List<EventMedia> listEventMedia = eventMediaService.getEventMediaByEventUUID(eventUUID);
		logger.info("Length of EventReview entries: "+ listEventMedia.size());
		model.put("eventMediaList", listEventMedia);
		
		logger.info("leaving /event/eventsNewsEdit");
		return mav;
	}
	
	
	/**
	 * go to the view of news listing
	 * @return the target view name 
	 */
	@RequestMapping(value="/events/eventsNewsDelete")
	public String gotoNewsDelete(){
		String viewName = "event/event_news_delete";
		return viewName;
	}


	/**
	 * get news objects in JSON data form
	 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value="/events/eventsNewsListData",produces="application/json")
	@ResponseBody
	public Map<String,Object> getDataNewsList(){
		logger.info("entering /event/eventsNewsListData");
		
		ModelAndView mav = new ModelAndView();
		
		//data
		List<Event> listNews = newsService.getAllNews();
		logger.info("Length of news entries: "+ listNews.size());
		
		String[][] data = getData(listNews, ACTION_EDIT);
		
		Map<String, Object> model = mav.getModel();
		
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus","OK");
		model.put("customActionMessage","Data loaded");
		
		logger.info("leaving /events/eventsNewsListData");
		return model;
	}
	
	/**
		 * get news objects in JSON data form, which comply with criteria
		 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
		 * @param itemJSONString search criteria object in JSON format
		 * @return a map structure containing data rendered to views
		 */
		@RequestMapping(value="/events/newsSearchFilterData",produces="application/json")
		@ResponseBody
		public Map<String, Object> getDataSearchNewsByFilter(@RequestParam String itemJSONString){
			logger.info("entering /events/newsSearchFilterData");
			
			ModelAndView mav = new ModelAndView();
			
			//data
			Map<String, Object> model = mav.getModel();
			JSONObject jobj= new JSONObject(itemJSONString);
			
			String where1 = jobj.getString("eventUUID").trim();
			String where2 = jobj.getString("title").trim();
			String where3 = jobj.getString("author").trim();
			int where4 = jobj.getInt("eventClass");
			
			/* where5a, where5b */
			String strPostDatetimeFrom = jobj.getString("postDatetimeFrom").trim();
			String strPostDatetimeTo = jobj.getString("postDatetimeTo").trim();
			
			if(strPostDatetimeFrom==null){
				strPostDatetimeFrom = "";
			}
			if(strPostDatetimeTo==null){
				strPostDatetimeTo = "";
			}
			String where5a = strPostDatetimeFrom;
			String where5b = strPostDatetimeTo;
			
			logger.info("strPostDatetimeFrom="+strPostDatetimeFrom+"##");
			logger.info("strPostDatetimeTo="+strPostDatetimeTo+"##");
			
			/* where6a, where6b */
			String strViewNumFrom = jobj.getString("viewNumFrom").trim();
			String strViewNumTo = jobj.getString("viewNumTo").trim();
			int where6a = 0;
			int where6b = 0;
			
	//		System.out.println("strViewNumFrom="+strViewNumFrom+"##");
	//		System.out.println("strViewNumTo="+strViewNumTo+"##");
			
			if(strViewNumFrom==null){
				strViewNumFrom = "";
			}
			if(strViewNumTo==null){
				strViewNumTo = "";
			}
			
			if(!strViewNumFrom.equals("")){
				where6a = Integer.parseInt(strViewNumFrom);
			}
			if(!strViewNumTo.equals("")){
				where6b = Integer.parseInt(strViewNumTo);
			}
			
			int where7 = jobj.getInt("eventStatus");
			
			/* construct query string */
			StringBuffer queryString = new StringBuffer();
			queryString.append(where1.length()==0?" ":" and event_uuid like '%"+where1+"%' ");
			queryString.append(where2.length()==0?" ":" and title like '%"+where2+"%' ");
			queryString.append(where3.length()==0?" ":" and author like '%"+where3+"%' ");
			queryString.append(where4==0?" ":" and event_class = "+where4+" ");
			
			String queryString_where5 = "";
			if(strPostDatetimeFrom.equals("")&&strPostDatetimeTo.equals("")){
				queryString_where5 = " ";
			}else if(!strPostDatetimeFrom.equals("")&&strPostDatetimeTo.equals("")){
				/* select * from event_news where date(post_datetime) >= adddate('2017-01-12', -1); */
				queryString_where5 = " and date(post_datetime) >= '"+where5a+"' ";
			}else if(strPostDatetimeFrom.equals("")&&!strPostDatetimeTo.equals("")){
				/* select * from event_news where date(post_datetime) <= '2017-02-05'; */
				queryString_where5 = " and date(post_datetime) <= '"+where5b+"' ";
			}else if(!strPostDatetimeFrom.equals("")&&!strPostDatetimeTo.equals("")){
				
				/*
				select * from event_news where date(post_datetime) between adddate('2017-01-12', -1) and '2017-02-05';
				*/
				int dateFlag = strPostDatetimeFrom.compareTo(strPostDatetimeTo);
				if(dateFlag<0){
					queryString_where5 = " and (date(post_datetime) between adddate('"+where5a+"', -1) and '"+where5b+"' ) ";
				}else if(dateFlag==0){
					queryString_where5 = " and (date(post_datetime) =  '"+where5a+"' ) ";
				}else{
					queryString_where5 = " and (date(post_datetime) between adddate('"+where5b+"', -1) and '"+where5a+"' ) ";
				}
				
			}else{
				logger.info("ERROR: not valid date range");
			}
			queryString.append(queryString_where5);
			
			String queryString_where6 = "";
			if(strViewNumFrom.equals("")&&strViewNumTo.equals("")){
				queryString_where6 = " ";
			}else if(!strViewNumFrom.equals("")&&strViewNumTo.equals("")){
				queryString_where6 = " and view_num >= "+where6a;
			}else if(strViewNumFrom.equals("")&&!strViewNumTo.equals("")){
				queryString_where6 = " and view_num <= "+where6b;
			}else if(!strViewNumFrom.equals("")&&!strViewNumTo.equals("")){
				if(where6a<=where6b){
					queryString_where6 = " and (view_num between "+where6a+" and "+where6b+" ) ";
				}else{
					queryString_where6 = " and (view_num between "+where6b+" and "+where6a+" ) ";
				}
			}
			queryString.append(queryString_where6);
					
			queryString.append(where7==0?" ":" and event_status = "+where7+" ");
			logger.info("QueryString = "+ queryString.toString());
			
			List<Event> listNews = newsService.getNewsByFilter(queryString.toString());
			logger.info("Length of news entries = "+ listNews.size());
			
			
			String[][] data = getData(listNews, ACTION_EDIT);
			
			model.put("draw", new Integer(1));
			model.put("recordsTotal", new Integer(5));
			model.put("recordsFiltered", new Integer(5));
			model.put("data", data);
			model.put("customActionStatus","OK");
			model.put("customActionMessage","OK");
			
			logger.info("leaving /events/newsSearchFilterData");
			
			return model;
		}

	
		/**
	 * get news objects in JSON data form
	 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value="/events/eventsNewsDeleteData",produces="application/json")
	@ResponseBody
	public Map<String,Object> getDataNewsDelete(){
		logger.info("entering /events/eventsNewsDeleteData");
		
		ModelAndView mav = new ModelAndView();
		
		//data
		List<Event> listNews = newsService.getAllNews();
		logger.info("Length of news entries: "+ listNews.size());
		
		/*
		int entryLength = listNews.size();
		final int COLUMN_NUM = 9;
		String[][] data = new String[entryLength][COLUMN_NUM];
		
		String field0 = "";	//check box
		String field1 = "";	//event UUID
		String field2 = "";	//event title
		String field3 = "";	//author
		String field4 = "";	//event class
		String field5 = "";	//post datetime
		String field6 = "";	//view num
		String field7 = "";	//event status
		String field8 = "";	//action
		
		for(int i=0; i<entryLength ; i++){			
			field0 = "<input type='checkbox' name='id[]' value="+listNews.get(i).getEventUUID()+">";
			field1 = listNews.get(i).getEventUUID()+"";
			field2 = listNews.get(i).getTitle();
			field3 = listNews.get(i).getAuthor();
			
			int intEventClass = Integer.parseInt((listNews.get(i).getEventClass()).trim());
			String eventClass = "";
			switch(intEventClass){
				case News.CLASS_DEFAULT:
					eventClass = "Default";
					break;
				case News.CLASS_NEW:
					eventClass = "New";
					break;
				case News.CLASS_HOT:
					eventClass = "Hot";
					break;
				default: 
					eventClass = "Unknown";
					break;
			}
			field4 = eventClass;
			
			field5 = listNews.get(i).getPostDatetime()+"";
			field6 = listNews.get(i).getViewNum()+"";
			int intEventStatus = listNews.get(i).getEventStatus();
			String eventStatus = "";
			String eventStatusKey = "";
			switch(intEventStatus){
				case News.PUBLISHED: 
					eventStatus = "Published";
					eventStatusKey = "success";
					break;
				case News.WAIT_TO_POST: 
					eventStatus = "Wait to post";
					eventStatusKey = "warning";
					break;
				case News.DELETED: 
					eventStatus = "Deleted";
					eventStatusKey = "default";
					break;
				case News.OUT_OF_DATE: 
					eventStatus = "Out of date";
					eventStatusKey = "info";
					break;
				case News.SUSPENDED: 
					eventStatus = "Suspended";
					eventStatusKey = "danger";
					break;
				default: 
					break;
			}
			field7 = "<span class='label label-sm label-"+eventStatusKey+"'>"+eventStatus+"</span>";
			field8 = "<a href='/acp/events/eventsNewsDelete?eventUUID="+field1+"' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> Delete</a>";
			
			//logger.info("field8="+field8);
			
			data[i][0] = field0;
			data[i][1] = field1;
			data[i][2] = field2;
			data[i][3] = field3;
			data[i][4] = field4;
			data[i][5] = field5;
			data[i][6] = field6;
			data[i][7] = field7;
			data[i][8] = field8;
		}
		*/
		
		String[][] data = getData(listNews, ACTION_DELETE);
		
		Map<String, Object> model = mav.getModel();
		
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus","OK");
		model.put("customActionMessage","OK");
		
		logger.info("leaving /events/eventsNewsDeleteData");
		return model;
	}
	
	/**
		 * get news objects in JSON data form, which comply with criteria
		 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
		 * @param itemJSONString search criteria object in JSON format
		 * @return a map structure containing data rendered to views
		 */
		@RequestMapping(value="/events/newsDeleteSearchFilterData",produces="application/json")
		@ResponseBody
		public Map<String, Object> getDataSearchNewsDeleteByFilter(@RequestParam String itemJSONString){
			logger.info("entering /events/newsSearchFilterData");
			
			ModelAndView mav = new ModelAndView();
			
			//data
			Map<String, Object> model = mav.getModel();
			JSONObject jobj= new JSONObject(itemJSONString);
			
			String where1 = jobj.getString("eventUUID").trim();
			String where2 = jobj.getString("title").trim();
			String where3 = jobj.getString("author").trim();
			int where4 = jobj.getInt("eventClass");
			
			/* where5a, where5b */
			String strPostDatetimeFrom = jobj.getString("postDatetimeFrom").trim();
			String strPostDatetimeTo = jobj.getString("postDatetimeTo").trim();
			
			if(strPostDatetimeFrom==null){
				strPostDatetimeFrom = "";
			}
			if(strPostDatetimeTo==null){
				strPostDatetimeTo = "";
			}
			String where5a = strPostDatetimeFrom;
			String where5b = strPostDatetimeTo;
			
			logger.info("strPostDatetimeFrom="+strPostDatetimeFrom+"##");
			logger.info("strPostDatetimeTo="+strPostDatetimeTo+"##");
			
			/* where6a, where6b */
			String strViewNumFrom = jobj.getString("viewNumFrom").trim();
			String strViewNumTo = jobj.getString("viewNumTo").trim();
			int where6a = 0;
			int where6b = 0;
			
	//		System.out.println("strViewNumFrom="+strViewNumFrom+"##");
	//		System.out.println("strViewNumTo="+strViewNumTo+"##");
			
			if(strViewNumFrom==null){
				strViewNumFrom = "";
			}
			if(strViewNumTo==null){
				strViewNumTo = "";
			}
			
			if(!strViewNumFrom.equals("")){
				where6a = Integer.parseInt(strViewNumFrom);
			}
			if(!strViewNumTo.equals("")){
				where6b = Integer.parseInt(strViewNumTo);
			}
			
			int where7 = jobj.getInt("eventStatus");
			
			/* construct query string */
			StringBuffer queryString = new StringBuffer();
			queryString.append(where1.length()==0?" ":" and event_uuid like '%"+where1+"%' ");
			queryString.append(where2.length()==0?" ":" and title like '%"+where2+"%' ");
			queryString.append(where3.length()==0?" ":" and author like '%"+where3+"%' ");
			queryString.append(where4==0?" ":" and event_class = "+where4+" ");
			
			String queryString_where5 = "";
			if(strPostDatetimeFrom.equals("")&&strPostDatetimeTo.equals("")){
				queryString_where5 = " ";
			}else if(!strPostDatetimeFrom.equals("")&&strPostDatetimeTo.equals("")){
				/* select * from event_news where date(post_datetime) >= adddate('2017-01-12', -1); */
				queryString_where5 = " and date(post_datetime) >= '"+where5a+"' ";
			}else if(strPostDatetimeFrom.equals("")&&!strPostDatetimeTo.equals("")){
				/* select * from event_news where date(post_datetime) <= '2017-02-05'; */
				queryString_where5 = " and date(post_datetime) <= '"+where5b+"' ";
			}else if(!strPostDatetimeFrom.equals("")&&!strPostDatetimeTo.equals("")){
				
				/*
				select * from event_news where date(post_datetime) between adddate('2017-01-12', -1) and '2017-02-05';
				*/
				int dateFlag = strPostDatetimeFrom.compareTo(strPostDatetimeTo);
				if(dateFlag<0){
					queryString_where5 = " and (date(post_datetime) between adddate('"+where5a+"', -1) and '"+where5b+"' ) ";
				}else if(dateFlag==0){
					queryString_where5 = " and (date(post_datetime) =  '"+where5a+"' ) ";
				}else{
					queryString_where5 = " and (date(post_datetime) between adddate('"+where5b+"', -1) and '"+where5a+"' ) ";
				}
				
			}else{
				logger.info("ERROR: not valid date range");
			}
			queryString.append(queryString_where5);
			
			String queryString_where6 = "";
			if(strViewNumFrom.equals("")&&strViewNumTo.equals("")){
				queryString_where6 = " ";
			}else if(!strViewNumFrom.equals("")&&strViewNumTo.equals("")){
				queryString_where6 = " and view_num >= "+where6a;
			}else if(strViewNumFrom.equals("")&&!strViewNumTo.equals("")){
				queryString_where6 = " and view_num <= "+where6b;
			}else if(!strViewNumFrom.equals("")&&!strViewNumTo.equals("")){
				if(where6a<=where6b){
					queryString_where6 = " and (view_num between "+where6a+" and "+where6b+" ) ";
				}else{
					queryString_where6 = " and (view_num between "+where6b+" and "+where6a+" ) ";
				}
			}
			queryString.append(queryString_where6);
					
			queryString.append(where7==0?" ":" and event_status = "+where7+" ");
			
			logger.info("QueryString = "+ queryString.toString());
			
			List<Event> listNews = newsService.getNewsByFilter(queryString.toString());
			logger.info("Length of news entries = "+ listNews.size());
			
			/*
			int entryLength = listNews.size();
			final int COLUMN_NUM = 9;
			String[][] data = new String[entryLength][COLUMN_NUM];
			
			String field0 = "";	//check box
			String field1 = "";	//event UUID
			String field2 = "";	//event title
			String field3 = "";	//author
			String field4 = "";	//event class
			String field5 = "";	//post datetime
			String field6 = "";	//view num
			String field7 = "";	//event status
			String field8 = "";	//action
			
			for(int i=0; i<entryLength ; i++){			
				field0 = "<input type='checkbox' name='id[]' value="+listNews.get(i).getEventUUID()+">";
				field1 = listNews.get(i).getEventUUID()+"";
				field2 = listNews.get(i).getTitle();
				field3 = listNews.get(i).getAuthor();
				
				int intEventClass = Integer.parseInt((listNews.get(i).getEventClass()).trim());
				String eventClass = "";
				switch(intEventClass){
					case News.CLASS_DEFAULT:
						eventClass = "Default";
						break;
					case News.CLASS_NEW:
						eventClass = "New";
						break;
					case News.CLASS_HOT:
						eventClass = "Hot";
						break;
					default: 
						eventClass = "Unknown";
						break;
				}
				field4 = eventClass;
						
				field5 = listNews.get(i).getPostDatetime()+"";
				field6 = listNews.get(i).getViewNum()+"";
				int intEventStatus = listNews.get(i).getEventStatus();
				String eventStatus = "";
				String eventStatusKey = "";
				switch(intEventStatus){
					case News.PUBLISHED: 
						eventStatus = "Published";
						eventStatusKey = "success";
						break;
					case News.WAIT_TO_POST: 
						eventStatus = "Wait to post";
						eventStatusKey = "warning";
						break;
					case News.DELETED: 
						eventStatus = "Deleted";
						eventStatusKey = "default";
						break;
					case News.OUT_OF_DATE: 
						eventStatus = "Out of date";
						eventStatusKey = "info";
						break;
					case News.SUSPENDED: 
						eventStatus = "Suspended";
						eventStatusKey = "danger";
						break;
					default: 
						break;
				}
				
				field7 = "<span class='label label-sm label-"+eventStatusKey+"'>"+eventStatus+"</span>";
				field8 = "<a href='/acp/events/eventsNewsDelete?eventUUID="+field1+"' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> Delete</a>";
				
				data[i][0] = field0;
				data[i][1] = field1;
				data[i][2] = field2;
				data[i][3] = field3;
				data[i][4] = field4;
				data[i][5] = field5;
				data[i][6] = field6;
				data[i][7] = field7;
				data[i][8] = field8;
			}*/
			
			String[][] data = getData(listNews, ACTION_DELETE);
			
			model.put("draw", new Integer(1));
			model.put("recordsTotal", new Integer(5));
			model.put("recordsFiltered", new Integer(5));
			model.put("data", data);
			model.put("customActionStatus","OK");
			model.put("customActionMessage","OK");
			
			logger.info("leaving /events/newsSearchFilterData");
			
			return model;
		}


	/**
	 * create news object based on data passed in JSON format
	 * @param itemJSONString news object in JSON format 
	 * @return data and event-news view
	 */
	@RequestMapping(value="/events/createNews",method=RequestMethod.POST)
	public ModelAndView createNews(@RequestParam String itemJSONString) {
		
		logger.info("entering /event/createNews");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
//        Map<String, Object> model = mav.getModel();
        JSONObject ic_job= new JSONObject(itemJSONString);
   
        News news = new News();
//		news.setGlobalId(ic_job.getLong("globalId"));
//      news.setEventUUID(ic_job.getString("eventUUID"));
        
        /* generate event UUID */
        news.setEventUUID(UUIDHelper.getUUID());
        news.setTitle(ic_job.getString("title"));
        news.setAuthor(ic_job.getString("author"));
          
//      news.setPostDatetime(new Date(ic_job.getString("postDatetime")));
        news.setPostDatetime(new Date());
        news.setViewNum(ic_job.getInt("viewNum"));
        news.setDescShort(ic_job.getString("descShort"));
        news.setDescLong(ic_job.getString("descLong"));
        news.setEventClass(ic_job.getString("eventClass"));
        news.setEventStatus(ic_job.getInt("eventStatus"));
          
        logger.info(news);
          
		/* business logic*/
        //long itemId = itemService.createItem(ic); 
        newsService.createNews(news);
		
		/* assemble model and view */
//      model.put("news", news);
        String viewName = "event/event_news_list";
        mav.setViewName(viewName);	
        
        logger.info("exiting... /event/createNews");
		return mav;		
	}
	
	/**
	 * update news object
	 * @param itemJSONString news object to update in JSON format
	 * @return data and target view
	 */
	@RequestMapping(value="/events/updateNews",method=RequestMethod.POST)
	public ModelAndView updateNews(@RequestParam String itemJSONString) {
		
		logger.info("entering /event/updateNews");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
//        Map<String, Object> model = mav.getModel();
        JSONObject ic_job= new JSONObject(itemJSONString);
   
        News news = new News();
//      news.setGlobalId(ic_job.getLong("globalId"));
        news.setEventUUID(ic_job.getString("eventUUID"));
        news.setTitle(ic_job.getString("title"));
        news.setAuthor(ic_job.getString("author"));
          
//      news.setPostDatetime(new Date(ic_job.getString("postDatetime")));
        news.setPostDatetime(new Date());
        news.setViewNum(ic_job.getInt("viewNum"));
        news.setDescShort(ic_job.getString("descShort"));
        news.setDescLong(ic_job.getString("descLong"));
        news.setEventClass(ic_job.getString("eventClass"));
        news.setEventStatus(ic_job.getInt("eventStatus"));
          
        logger.info("news = "+news);
          
		/* business logic*/
        //long itemId = itemService.createItem(ic); 

        newsService.updateNews(news);
		
		/* assemble model and view */
//      model.put("news", news);
        String viewName = "event/event_news_list";
		mav.setViewName(viewName);		
		
		logger.info("leaving /event/updateNews");
		return mav;		
	}
	
	/**
	 * update news objects in group
	 * @param itemJSONString news object to update in JSON format
	 * @return data and target view
	 */
	@RequestMapping(value="/events/updateNewsGroup",produces="application/json")
	@ResponseBody
	public Map<String,Object> updateNewsGroup(
			@RequestParam String eventUUIDArray,
			@RequestParam int newsStatus
			) {
		
		logger.info("entering /events/updateNewsGroup");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
        Map<String, Object> model = mav.getModel();
   
        List<News> newsList = new ArrayList<News>();
        String[] eventUUIDs = eventUUIDArray.split(",");
        int eventUUIDLength = eventUUIDs.length;
        
        for(int i=0; i<eventUUIDLength; i++){
        	 News news = new News();
             news.setEventUUID(eventUUIDs[i]);
             news.setEventStatus(newsStatus);
             newsList.add(news);
             news = null;
        }
        
        logger.info("newsList size="+newsList.size());
        logger.info("newsList ="+newsList.toString());
        
		/* business logic*/
        newsService.updateNewsGroup(newsList);
        
		
		/* assemble model and view */
		logger.info("leaving /events/updateNewsGroup");
		return model;		
	}
	
	
	/**
	 * set current media to as a cover media and refresh all media objects 
	 * @param eventUUID the eventUUID of current event
	 * @return data table of updated media object
	 */
	@RequestMapping(value="/events/markNewsStatusDeleted")
//	@ResponseBody
	public Map<String,Object> markNewsStatusDeleted(@RequestParam String eventUUID){
		logger.info("entering /event/markNewsStatusDeleted");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "events/event_news_edit";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		logger.info("eventUUID="+eventUUID);
		
		newsService.markNewsStatusDeleted(eventUUID);
		
		
		logger.info("leaving /event/markNewsStatusDeleted");
//		return mav;
		return model;
	}
	

	/**
	 * delete a news object
	 * @param eventUUID eventUUID
	 * @return data and target view
	 */
	@RequestMapping(value="/events/deleteNews",produces="application/json")
	public ModelAndView deleteNews(@RequestParam String eventUUID) {
		
		logger.info("entering /events/eventsNewsDelete");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
        Map<String, Object> model = mav.getModel();
        
        //data
        News news = new News();
        news.setEventUUID(eventUUID);
        
        logger.info("news="+news.toString());
        
		/* business logic*/
        newsService.deleteNews(news);
        
		
		/* assemble model and view */
        String viewName = "event/event_news_delete";
		mav.setViewName(viewName);
		
        logger.info("leaving /events/eventsNewsDelete");
		
		return mav;		
	}
	
	
	
	
	/**
	 * delete news objects in group
	 * @param eventUUIDArray eventUUID list
	 * @param newsStatus the status of news, here it should be 6:permanently delete
	 * @return data and target view
	 */
	@RequestMapping(value="/events/deleteNewsGroup",produces="application/json")
	@ResponseBody
	public Map<String,Object> deleteNewsGroup(
			@RequestParam String eventUUIDArray,
			@RequestParam int newsStatus
			) {
		
		logger.info("entering /events/deleteNewsGroup");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
        Map<String, Object> model = mav.getModel();
   
        List<News> newsList = new ArrayList<News>();
        String[] eventUUIDs = eventUUIDArray.split(",");
        int eventUUIDLength = eventUUIDs.length;
        
        for(int i=0; i<eventUUIDLength; i++){
        	 News news = new News();
             news.setEventUUID(eventUUIDs[i]);
             news.setEventStatus(newsStatus);
             newsList.add(news);
             news = null;
        }
        
        logger.info("newsList size="+newsList.size());
        
		/* business logic*/
        newsService.deleteNewsGroup(newsList);
        
		
		/* assemble model and view */
		logger.info("leaving /events/deleteNewsGroup");
		return model;		
	}
	
	
	private String[][] getData(List<Event> listNews, String actionName){
		int entryLength = listNews.size();
		final int COLUMN_NUM = 9;
		String[][] data = new String[entryLength][COLUMN_NUM];
		
		String field0 = "";	//check box
		String field1 = "";	//event UUID
		String field2 = "";	//event title
		String field3 = "";	//author
		String field4 = "";	//event class
		String field5 = "";	//post datetime
		String field6 = "";	//view num
		String field7 = "";	//event status
		String field8 = "";	//action
		
		for(int i=0; i<entryLength ; i++){			
			field0 = "<input type='checkbox' name='id[]' value="+listNews.get(i).getEventUUID()+">";
			field1 = listNews.get(i).getEventUUID()+"";
			field2 = listNews.get(i).getTitle();
			field3 = listNews.get(i).getAuthor();
			
			String strEventClass = (listNews.get(i).getEventClass()).trim();
			field4 = getEventClass(strEventClass);
			
			field5 = listNews.get(i).getPostDatetime()+"";
			field6 = listNews.get(i).getViewNum()+"";
			
			int intEventStatus = listNews.get(i).getEventStatus();
			String[] eventStatusPair = getEventStatusPair(intEventStatus);
			String eventStatusKey = eventStatusPair[0];
			String eventStatus = eventStatusPair[1];
			field7 = "<span class='label label-sm label-"+eventStatusKey+"'>"+eventStatus+"</span>";
			field8 = "<a href='/acp/events/"+getAction(actionName)+"?eventUUID="+field1+"' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> "+actionName+"</a>";
			
			//logger.info("field8="+field8);
			
			data[i][0] = field0;
			data[i][1] = field1;
			data[i][2] = field2;
			data[i][3] = field3;
			data[i][4] = field4;
			data[i][5] = field5;
			data[i][6] = field6;
			data[i][7] = field7;
			data[i][8] = field8;
		}
		
		return data;
	}


	private String getEventClass(String strEventClass){
		
		int intEventClass = Integer.parseInt(strEventClass);
		String eventClass = "";
		switch(intEventClass){
			case News.CLASS_DEFAULT:
				eventClass = "Default";
				break;
			case News.CLASS_NEW:
				eventClass = "New";
				break;
			case News.CLASS_HOT:
				eventClass = "Hot";
				break;
			default: 
				eventClass = "Unknown";
				break;
		}
		
		return eventClass;
	}
	
	private String[] getEventStatusPair(int intEventStatus){
		String[] eventStatusPair = new String[2];
		
		String eventStatus = "";
		String eventStatusKey = "";
		switch(intEventStatus){
			case News.PUBLISHED: 
				eventStatus = "Published";
				eventStatusKey = "success";
				break;
			case News.WAIT_TO_POST: 
				eventStatus = "Wait to post";
				eventStatusKey = "warning";
				break;
			case News.DELETED: 
				eventStatus = "Deleted";
				eventStatusKey = "default";
				break;
			case News.OUT_OF_DATE: 
				eventStatus = "Out of date";
				eventStatusKey = "info";
				break;
			case News.SUSPENDED: 
				eventStatus = "Suspended";
				eventStatusKey = "danger";
				break;
			default: 
				break;
		}
		
		eventStatusPair[0]=eventStatusKey;
		eventStatusPair[1]=eventStatus;
		
		
		return eventStatusPair;
	}
	
	private String getAction(String actionName){
		String action = "";
		switch(actionName){
		case ACTION_EDIT:
			action = "eventsNewsEdit";
			break;
		case ACTION_DELETE:
			action = "deleteNews";
			break;
		}
		return action;
	}
}
