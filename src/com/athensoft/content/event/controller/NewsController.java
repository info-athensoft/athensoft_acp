package com.athensoft.content.event.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.base.entity.Module;
import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.entity.EventStatus;
import com.athensoft.content.event.entity.News;
import com.athensoft.content.event.entity.NewsAction;
import com.athensoft.content.event.service.EventMediaService;
import com.athensoft.content.event.service.NewsService;
import com.athensoft.tag.service.TagMapService;
import com.athensoft.util.id.UUIDHelper;

import lombok.extern.log4j.Log4j;

/**
 * News Controller for ACP
 * 
 * @author Athens
 * @version 1.0
 */
@Controller
@RequestMapping("/events/news")
@Log4j
public class NewsController {

	/**
	 * News Service instance
	 */
	@Autowired
	private NewsService newsService;

	/**
	 * EventMedia Service instance
	 */
	@Autowired
	private EventMediaService eventMediaService;
	
	
	@Autowired
	private TagMapService tagMapService;
	

	/**
	 * go to the view of event dashboard
	 * 
	 * @return the target view name
	 */
	// @RequestMapping(value="/events/eventsDashboard")
	@RequestMapping(value = "/dashboard.html")
	public String gotoDashboardNews() {
		String viewName = "event/event_dashboard";
		return viewName;
	}

	/**
	 * go to the view of news listing
	 * 
	 * @return the target view name
	 */
	// @RequestMapping(value="/events/eventsNewsList")
	@RequestMapping(value = "/list.html")
	public String gotoListNews() {
		String viewName = "event/event_news_list";
		return viewName;
	}

	/**
	 * go to the view of news creating
	 * 
	 * @return the target view name
	 */
	@RequestMapping(value = "/create.html")
	public String gotoCreateNews() {
		String viewName = "event/event_news_create";
		return viewName;
	}

	/**
	 * goto event-news edit page with data for updating
	 * 
	 * @param eventUUID
	 *            the eventUUID of new object selected
	 * @return data of news object, event media objects, and target view
	 */
	@RequestMapping(value = "/edit.html")
	public ModelAndView gotoEditNews(@RequestParam String eventUUID) {
		log.info("entering... /event/news/edit.html");

		// data - news
		News news = newsService.getNewsByEventUUID(eventUUID);

		// data - media
		List<EventMedia> listEventMedia = eventMediaService.getEventMediaByEventUUID(eventUUID);
		log.info("Length of EventReview entries: " + listEventMedia == null ? "NULL" : listEventMedia.size());
		
		// data - tag
		String tagNames = tagMapService.getTagNames(Module.NEWS, news.getGlobalId());
		
		System.out.println("news.getGlobalId()="+news.getGlobalId());
		System.out.println("tagNames="+tagNames);
		
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("newsObject", news);
		model.put("eventMediaList", listEventMedia);
		model.put("newsTagNames", tagNames);

		String viewName = "event/event_news_edit";
		mav.setViewName(viewName);

		log.info("leaving... /event/news/edit.html");
		return mav;
	}

	/**
	 * go to the view of news listing
	 * 
	 * @return the target view name
	 */
	@RequestMapping(value = "/deletelist.html")
	public String gotoListDeleteNews() {
		String viewName = "event/news_delete_list";
		return viewName;
	}

	@RequestMapping(value = "/delete.html")
	public ModelAndView gotoDeleteNews(@RequestParam String eventUUID) {
		log.info("entering... /event/news/delete.html");

		// data - news
		News news = newsService.getNewsByEventUUID(eventUUID);

		// data - media
		List<EventMedia> listEventMedia = eventMediaService.getEventMediaByEventUUID(eventUUID);
		log.info("Length of EventReview entries: " + listEventMedia == null ? "NULL" : listEventMedia.size());

		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("newsObject", news);
		model.put("eventMediaList", listEventMedia);

		String viewName = "event/news_delete";
		mav.setViewName(viewName);

		log.info("leaving... /event/news/delete.html");
		return mav;
	}

	/**
	 * get news objects in JSON data form the data for showing in datatable in
	 * front-end pages is contained in a 2-dimension array
	 * 
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value = "/list", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDataListNews() {
		log.info("entering... /events/news/list");

		// data
		List<Event> listNews = newsService.getAllNews();
		log.info("Length of news entries: " + listNews == null ? "NULL" : listNews.size());

//		String[][] data = getData(listNews, ACTION_EDIT);
		String[][] data = newsService.getData(listNews, NewsAction.EDIT);

		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus", "OK");
		model.put("customActionMessage", "Data loaded");

		log.info("leaving... /events/news/list");
		return model;
	}

	/**
	 * get news objects in JSON data form, which comply with criteria the data
	 * for showing in datatable in front-end pages is contained in a 2-dimension
	 * array
	 * 
	 * @param jsonObjString
	 *            search criteria object in JSON format
	 * @return a map structure containing data rendered to views
	 */
	@RequestMapping(value = "/search", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDataSearchNews(@RequestParam String jsonObjString) {
		log.info("entering... /events/news/search");

		// get parameters
		JSONObject jobj = new JSONObject(jsonObjString);

		String where1 = jobj.getString("eventUUID").trim();
		String where2 = jobj.getString("title").trim();
		String where3 = jobj.getString("author").trim();
		int where4 = jobj.getInt("eventClass");

		/* where5a, where5b */
		String strPostDatetimeFrom = jobj.getString("postDatetimeFrom").trim();
		String strPostDatetimeTo = jobj.getString("postDatetimeTo").trim();

		if (strPostDatetimeFrom == null) {
			strPostDatetimeFrom = "";
		}
		if (strPostDatetimeTo == null) {
			strPostDatetimeTo = "";
		}
		String where5a = strPostDatetimeFrom;
		String where5b = strPostDatetimeTo;

		log.info("strPostDatetimeFrom=" + strPostDatetimeFrom + "##");
		log.info("strPostDatetimeTo=" + strPostDatetimeTo + "##");

		/* where6a, where6b */
		String strViewNumFrom = jobj.getString("viewNumFrom").trim();
		String strViewNumTo = jobj.getString("viewNumTo").trim();
		int where6a = 0;
		int where6b = 0;

		if (strViewNumFrom == null)
			strViewNumFrom = "";

		if (strViewNumTo == null)
			strViewNumTo = "";

		if (!strViewNumFrom.equals("")) {
			where6a = Integer.parseInt(strViewNumFrom);
		}
		if (!strViewNumTo.equals("")) {
			where6b = Integer.parseInt(strViewNumTo);
		}

		int where7 = jobj.getInt("eventStatus");

		/* construct query string */
		StringBuffer queryString = new StringBuffer();
		queryString.append(where1.length() == 0 ? " " : " and event_uuid like '%" + where1 + "%' ");
		queryString.append(where2.length() == 0 ? " " : " and title like '%" + where2 + "%' ");
		queryString.append(where3.length() == 0 ? " " : " and author like '%" + where3 + "%' ");
		queryString.append(where4 == 0 ? " " : " and event_class = " + where4 + " ");

		String queryString_where5 = "";
		if (strPostDatetimeFrom.equals("") && strPostDatetimeTo.equals("")) {
			queryString_where5 = " ";
		} else if (!strPostDatetimeFrom.equals("") && strPostDatetimeTo.equals("")) {
			/*
			 * select * from event_news where date(post_datetime) >=
			 * adddate('2017-01-12', -1);
			 */
			queryString_where5 = " AND date(post_datetime) >= '" + where5a + "' ";
		} else if (strPostDatetimeFrom.equals("") && !strPostDatetimeTo.equals("")) {
			/*
			 * select * from event_news where date(post_datetime) <=
			 * '2017-02-05';
			 */
			queryString_where5 = " AND date(post_datetime) <= '" + where5b + "' ";
		} else if (!strPostDatetimeFrom.equals("") && !strPostDatetimeTo.equals("")) {

			/*
			 * select * from event_news where date(post_datetime) between
			 * adddate('2017-01-12', -1) AND '2017-02-05';
			 */
			int dateFlag = strPostDatetimeFrom.compareTo(strPostDatetimeTo);
			if (dateFlag < 0) {
				queryString_where5 = " AND (date(post_date) between adddate('" + where5a + "', -1) AND '" + where5b
						+ "' ) ";
			} else if (dateFlag == 0) {
				queryString_where5 = " AND (date(post_date) =  '" + where5a + "' ) ";
			} else {
				queryString_where5 = " AND (date(post_date) between adddate('" + where5b + "', -1) AND '" + where5a
						+ "' ) ";
			}

		} else {
			log.info("ERROR: not valid date range");
		}
		queryString.append(queryString_where5);

		String queryString_where6 = "";
		if (strViewNumFrom.equals("") && strViewNumTo.equals("")) {
			queryString_where6 = " ";
		} else if (!strViewNumFrom.equals("") && strViewNumTo.equals("")) {
			queryString_where6 = " AND view_num >= " + where6a;
		} else if (strViewNumFrom.equals("") && !strViewNumTo.equals("")) {
			queryString_where6 = " AND view_num <= " + where6b;
		} else if (!strViewNumFrom.equals("") && !strViewNumTo.equals("")) {
			if (where6a <= where6b) {
				queryString_where6 = " AND (view_num between " + where6a + " AND " + where6b + " ) ";
			} else {
				queryString_where6 = " AND (view_num between " + where6b + " AND " + where6a + " ) ";
			}
		}
		queryString.append(queryString_where6);

		queryString.append(where7 == 0 ? " " : " AND event_status = " + where7 + " ");
		log.info("QueryString = " + queryString.toString());

		List<Event> listNews = newsService.getNewsByFilter(queryString.toString());
		log.info("Length of news entries = " + listNews.size());

		// data
//		String[][] data = getData(listNews, ACTION_EDIT);
		String[][] data = newsService.getData(listNews, NewsAction.EDIT);

		//
		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();

		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus", "OK");
		model.put("customActionMessage", "OK");

		log.info("leaving /events/newsSearchFilterData");

		return model;
	}

	/**
	 * get news objects in JSON data form the data for showing in datatable in
	 * front-end pages is contained in a 2-dimension array
	 * 
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value = "/deletelist", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDataDeleteListNews() {
		log.info("entering... /events/news/deletelist");

		// data
		List<Event> listNews = newsService.getAllMarkedDeletedNews();
		log.info("Length of news entries: " + listNews == null ? "NULL" : listNews.size());

//		String[][] data = getData(listNews, ACTION_DELETE);
		String[][] data = newsService.getData(listNews, NewsAction.DELETE);

		ModelAndView mav = new ModelAndView();
		Map<String, Object> model = mav.getModel();
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus", "OK");
		model.put("customActionMessage", "OK");

		log.info("leaving... /events/news/deletelist");
		return model;
	}

	/**
	 * get news objects in JSON data form, which comply with criteria the data
	 * for showing in datatable in front-end pages is contained in a 2-dimension
	 * array
	 * 
	 * @param jsonObjString
	 *            search criteria object in JSON format
	 * @return a map structure containing data rendered to views
	 */
	@RequestMapping(value = "/deletesearch", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getDataDeleteSearchNews(@RequestParam String jsonObjString) {
		log.info("entering... /events/news/deletesearch");

		ModelAndView mav = new ModelAndView();

		// data
		Map<String, Object> model = mav.getModel();
		JSONObject jobj = new JSONObject(jsonObjString);

		String where1 = jobj.getString("eventUUID").trim();
		String where2 = jobj.getString("title").trim();
		String where3 = jobj.getString("author").trim();
		int where4 = jobj.getInt("eventClass");

		/* where5a, where5b */
		String strPostDatetimeFrom = jobj.getString("postDatetimeFrom").trim();
		String strPostDatetimeTo = jobj.getString("postDatetimeTo").trim();

		if (strPostDatetimeFrom == null) {
			strPostDatetimeFrom = "";
		}
		if (strPostDatetimeTo == null) {
			strPostDatetimeTo = "";
		}
		String where5a = strPostDatetimeFrom;
		String where5b = strPostDatetimeTo;

		log.info("strPostDatetimeFrom=" + strPostDatetimeFrom + "##");
		log.info("strPostDatetimeTo=" + strPostDatetimeTo + "##");

		/* where6a, where6b */
		String strViewNumFrom = jobj.getString("viewNumFrom").trim();
		String strViewNumTo = jobj.getString("viewNumTo").trim();
		int where6a = 0;
		int where6b = 0;

		if (strViewNumFrom == null)
			strViewNumFrom = "";
		if (strViewNumTo == null)
			strViewNumTo = "";

		if (!strViewNumFrom.equals("")) {
			where6a = Integer.parseInt(strViewNumFrom);
		}
		if (!strViewNumTo.equals("")) {
			where6b = Integer.parseInt(strViewNumTo);
		}

		int where7 = jobj.getInt("eventStatus");

		/* construct query string */
		StringBuffer queryString = new StringBuffer();
		queryString.append(where1.length() == 0 ? " " : " and event_uuid like '%" + where1 + "%' ");
		queryString.append(where2.length() == 0 ? " " : " and title like '%" + where2 + "%' ");
		queryString.append(where3.length() == 0 ? " " : " and author like '%" + where3 + "%' ");
		queryString.append(where4 == 0 ? " " : " and event_class = " + where4 + " ");

		String queryString_where5 = "";
		if (strPostDatetimeFrom.equals("") && strPostDatetimeTo.equals("")) {
			queryString_where5 = " ";
		} else if (!strPostDatetimeFrom.equals("") && strPostDatetimeTo.equals("")) {
			/*
			 * select * from event_news where date(post_datetime) >=
			 * adddate('2017-01-12', -1);
			 */
			queryString_where5 = " and date(post_datetime) >= '" + where5a + "' ";
		} else if (strPostDatetimeFrom.equals("") && !strPostDatetimeTo.equals("")) {
			/*
			 * select * from event_news where date(post_datetime) <=
			 * '2017-02-05';
			 */
			queryString_where5 = " and date(post_datetime) <= '" + where5b + "' ";
		} else if (!strPostDatetimeFrom.equals("") && !strPostDatetimeTo.equals("")) {

			/*
			 * select * from event_news where date(post_datetime) between
			 * adddate('2017-01-12', -1) and '2017-02-05';
			 */
			int dateFlag = strPostDatetimeFrom.compareTo(strPostDatetimeTo);
			if (dateFlag < 0) {
				queryString_where5 = " and (date(post_datetime) between adddate('" + where5a + "', -1) and '" + where5b
						+ "' ) ";
			} else if (dateFlag == 0) {
				queryString_where5 = " and (date(post_datetime) =  '" + where5a + "' ) ";
			} else {
				queryString_where5 = " and (date(post_datetime) between adddate('" + where5b + "', -1) and '" + where5a
						+ "' ) ";
			}

		} else {
			log.info("ERROR: not valid date range");
		}
		queryString.append(queryString_where5);

		String queryString_where6 = "";
		if (strViewNumFrom.equals("") && strViewNumTo.equals("")) {
			queryString_where6 = " ";
		} else if (!strViewNumFrom.equals("") && strViewNumTo.equals("")) {
			queryString_where6 = " and view_num >= " + where6a;
		} else if (strViewNumFrom.equals("") && !strViewNumTo.equals("")) {
			queryString_where6 = " and view_num <= " + where6b;
		} else if (!strViewNumFrom.equals("") && !strViewNumTo.equals("")) {
			if (where6a <= where6b) {
				queryString_where6 = " and (view_num between " + where6a + " and " + where6b + " ) ";
			} else {
				queryString_where6 = " and (view_num between " + where6b + " and " + where6a + " ) ";
			}
		}
		queryString.append(queryString_where6);

		queryString.append(where7 == 0 ? " " : " and event_status = " + where7 + " ");

		log.info("QueryString = " + queryString.toString());

		List<Event> listNews = newsService.getNewsByFilter(queryString.toString());
		log.info("Length of news entries = " + listNews == null ? "NULL" : listNews.size());

//		String[][] data = getData(listNews, ACTION_DELETE);
		String[][] data = newsService.getData(listNews, NewsAction.DELETE);

		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus", "OK");
		model.put("customActionMessage", "OK");

		log.info("leaving... /events/news/deletesearch");
		return model;
	}

	/**
	 * create news object based on data passed in JSON format
	 * 
	 * @param jsonObjString
	 *            news object in JSON format
	 * @return data and event-news view
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public void createNews(@RequestParam String jsonObjString) {
		log.info("entering /event/news/create");

		JSONObject ic_job = new JSONObject(jsonObjString);

		News news = new News();
		news.setEventUUID(UUIDHelper.getUUID());
		news.setTitle(ic_job.getString("title"));
		news.setAuthor(ic_job.getString("author"));
//		news.setPostDate(new Date());
		news.setCreateDate(new Date());
		news.setModifyDate(news.getCreateDate());
		news.setViewNum(ic_job.getInt("viewNum"));
		news.setDescShort(ic_job.getString("descShort"));
		news.setDescLong(ic_job.getString("descLong"));
		news.setEventClass(ic_job.getString("eventClass"));
		news.setEventStatus(ic_job.getInt("eventStatus"));
		log.info(news);

		/* business logic */
		newsService.createNews(news);

		log.info("exiting... /event/news/create");
		return;
	}

	/**
	 * update news object
	 * 
	 * @param jsonObjString
	 *            news object to update in JSON format
	 * @return data and target view
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public void updateNews(@RequestParam String jsonObjString) {
		log.info("entering... /events/news/update");

		JSONObject jObj = new JSONObject(jsonObjString);
		
		System.out.println(jObj);

		News newsDTO = new News();
		newsDTO.setEventUUID(jObj.getString("eventUUID"));
		newsDTO.setTitle(jObj.getString("title"));
		newsDTO.setAuthor(jObj.getString("author"));
		log.info(jObj.get("postDate").toString());
		//Date postDate = new Date((jObj.getString("postDate"));
		String strPostDate = jObj.get("postDate").toString().trim();
		Date postDate = new Date();
		if(strPostDate.length()==0){
			postDate = null;
		}else{
			DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
			try {
				postDate = dateFormat.parse(jObj.getString("postDate"));
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		newsDTO.setPostDate(postDate);
		newsDTO.setModifyDate(new Date());
		newsDTO.setViewNum(jObj.getInt("viewNum"));
		newsDTO.setDescShort(jObj.getString("descShort"));
		newsDTO.setDescLong(jObj.getString("descLong"));
		newsDTO.setEventClass(jObj.getString("eventClass"));
		newsDTO.setEventStatus(jObj.getInt("eventStatus"));
		
		switch(newsDTO.getEventStatus()){
			case EventStatus.PUBLISHED:
				newsDTO.setPostDate(newsDTO.getModifyDate());
				break;
			case EventStatus.DELETED:
				newsDTO.setDeleteDate(newsDTO.getModifyDate());
				break;
			default:
				break;
		}
		
		log.info("newsDTO = " + newsDTO);

		/* business logic */
		newsService.updateNews(newsDTO);

		log.info("leaving... /events/news/update");
		return;
	}

	/**
	 * update news objects in group
	 * 
	 * @param eventUUIDArray
	 * @param newsStatus
	 * @return
	 */
	@RequestMapping(value = "/updategroup", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void updateGroupNews(@RequestBody NewsGroup newsGroup) {
		log.info("entering... /events/news/updategroup");

		List<String> eventUUIDs = newsGroup.getEventUUIDArray();
		int newsStatus = newsGroup.getNewsStatus();

		int eventUUIDLength = eventUUIDs.size();
		List<News> newsList = new ArrayList<News>();

		for (int i = 0; i < eventUUIDLength; i++) {
			News newsDTO = new News();
			newsDTO.setEventUUID(eventUUIDs.get(i));
			newsDTO.setEventStatus(newsStatus);
			newsDTO.setModifyDate(new Date());
			
			switch(newsDTO.getEventStatus()){
			case EventStatus.PUBLISHED:
				newsDTO.setPostDate(newsDTO.getModifyDate());
				break;
			case EventStatus.DELETED:
				newsDTO.setDeleteDate(newsDTO.getModifyDate());
				break;
			default:
				break;
		}
			
			newsList.add(newsDTO);
			newsDTO = null;
		}
		log.info("newsList size=" + newsList == null ? "NULL" : newsList.size());

		/* business logic */
		newsService.updateNewsGroup(newsList);

		log.info("leaving... /events/news/updategroup");
		return;
	}

	/**
	 * set current media to as a cover media and refresh all media objects
	 * 
	 * @param eventUUID
	 *            the eventUUID of current event
	 * @return data table of updated media object
	 */
	@RequestMapping(value = "/events/markNewsStatusDeleted")
	// @ResponseBody
	public void markNewsStatusDeleted(@RequestParam String eventUUID) {
		log.info("entering /event/markNewsStatusDeleted");

		log.info("eventUUID=" + eventUUID);

		newsService.markNewsStatusDeleted(eventUUID);

		log.info("leaving /event/markNewsStatusDeleted");
		return;
	}

	/**
	 * delete a news object
	 * 
	 * @param eventUUID
	 *            eventUUID
	 * @return data and target view
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void deleteNews(@RequestParam String jsonObjString) {
		log.info("entering... /events/news/delete");

		JSONObject jObj = new JSONObject(jsonObjString);
		String eventUUID = jObj.getString("eventUUID");
		// data
		News news = new News();
		news.setEventUUID(eventUUID);
		log.info("news=" + news.toString());

		/* business logic */
		newsService.deleteNews(news);

		log.info("leaving... /events/news/delete");
		return;
	}

	/**
	 * delete news objects in group
	 * 
	 * @param eventUUIDArray
	 *            eventUUID list
	 * @param newsStatus
	 *            the status of news, here it should be 6:permanently delete
	 * @return data and target view
	 */
	@RequestMapping(value = "/deletegroup", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void deleteGroupNews(@RequestBody NewsGroup newsGroup) {
		// public void deleteGroupNews(@RequestParam String eventUUIDArray,
		// @RequestParam int newsStatus) {
		log.info("entering... /events/news/deletegroup");

		List<String> eventUUIDs = newsGroup.getEventUUIDArray();
		int newsStatus = newsGroup.getNewsStatus();

		int eventUUIDLength = eventUUIDs.size();
		List<News> newsList = new ArrayList<News>();

		for (int i = 0; i < eventUUIDLength; i++) {
			News news = new News();
			news.setEventUUID(eventUUIDs.get(i));
			news.setEventStatus(newsStatus);
			newsList.add(news);
			news = null;
		}
		log.info("newsList size=" + newsList == null ? "NULL" : newsList.size());

		/* business logic */
		newsService.deleteNewsGroup(newsList);

		log.info("leaving... /events/news/deletegroup");
		return;
	}
/*
	private String[][] getData(List<Event> listNews, String action) {
		int entryLength = listNews.size();
		final int COLUMN_NUM = 9;
		String[][] data = new String[entryLength][COLUMN_NUM];

		String field0 = ""; // check box
		String field1 = ""; // event UUID
		String field2 = ""; // event title
		String field3 = ""; // author
		String field4 = ""; // event class
		String field5 = ""; // post datetime
		String field6 = ""; // view num
		String field7 = ""; // event status
		String field8 = ""; // action

		for (int i = 0; i < entryLength; i++) {
			field0 = "<input type='checkbox' name='id[]' value=" + listNews.get(i).getEventUUID() + ">";
			field1 = listNews.get(i).getEventUUID() + "";
			field2 = listNews.get(i).getTitle();
			field3 = listNews.get(i).getAuthor();

			String strEventClass = (listNews.get(i).getEventClass()).trim();
			field4 = getEventClass(strEventClass);

			field5 = listNews.get(i).getPostDatetime() + "";
			field6 = listNews.get(i).getViewNum() + "";

			int intEventStatus = listNews.get(i).getEventStatus();
			String[] eventStatusPair = getEventStatusPair(intEventStatus);
			String eventStatusKey = eventStatusPair[0];
			String eventStatus = eventStatusPair[1];
			field7 = "<span class='label label-sm label-" + eventStatusKey + "'>" + eventStatus + "</span>";
			field8 = "<a href='" + getActionUrl(action) + "?eventUUID=" + field1
					+ "' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> " + getActionName(action) + "</a>";

			// log.info("field8="+field8);

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

	private String getEventClass(String strEventClass) {

		int intEventClass = Integer.parseInt(strEventClass);
		String eventClass = "";
		switch (intEventClass) {
		case News.CLASS_DEFAULT:
			eventClass = "��ͨ";
			break;
		case News.CLASS_NEW:
			eventClass = "��";
			break;
		case News.CLASS_HOT:
			eventClass = "��";
			break;
		default:
			eventClass = "δ֪";
			break;
		}

		return eventClass;
	}

	private String[] getEventStatusPair(int intEventStatus) {
		String[] eventStatusPair = new String[2];

		String eventStatus = "";
		String eventStatusKey = "";
		switch (intEventStatus) {
		case News.PUBLISHED:
			eventStatus = "�ѷ���";
			eventStatusKey = "success";
			break;
		case News.WAIT_TO_POST:
			eventStatus = "������";
			eventStatusKey = "warning";
			break;
		case News.DELETED:
			eventStatus = "��ɾ��";
			eventStatusKey = "default";
			break;
		case News.OUT_OF_DATE:
			eventStatus = "�ѹ���";
			eventStatusKey = "info";
			break;
		case News.SUSPENDED:
			eventStatus = "�����";
			eventStatusKey = "danger";
			break;
		default:
			break;
		}

		eventStatusPair[0] = eventStatusKey;
		eventStatusPair[1] = eventStatus;

		return eventStatusPair;
	}

	private String getActionUrl(String action) {
		String actionUrl = "";
		switch (action) {
		case NewsAction.EDIT:
			actionUrl = "/acp/events/news/edit.html";
			break;
		case NewsAction.DELETE:
			actionUrl = "/acp/events/news/delete.html";
			break;
		}
		return actionUrl;
	}
	
	public String getActionName(String action){
		String actionName = "";
		switch(action){
			case NewsAction.VIEW:
				actionName = "�鿴";	//adPost Button Name - view
				break;
			case NewsAction.EDIT:
				actionName = "�༭";	//adPost Button Name - edit
				break;
			case NewsAction.DELETE:
				actionName = "ɾ��";	//adPost Button Name - delete
				break;
			case NewsAction.MANAGE:
				actionName = "����";	//adPost Button Name - view
				break;
			default:
				actionName = "δ����";
		}
		return actionName;
	}
*/
	
	public static class NewsGroup {
		private List<String> eventUUIDArray;
		private int newsStatus;

		public List<String> getEventUUIDArray() {
			return eventUUIDArray;
		}

		public void setEventUUIDArray(List<String> eventUUIDArray) {
			this.eventUUIDArray = eventUUIDArray;
		}

		public int getNewsStatus() {
			return newsStatus;
		}

		public void setNewsStatus(int newsStatus) {
			this.newsStatus = newsStatus;
		}

		@Override
		public String toString() {
			return "NewsGroup [eventUUIDArray=" + eventUUIDArray + ", newsStatus=" + newsStatus + "]";
		}
	}
}
