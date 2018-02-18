package com.athensoft.content.event.controller;

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

import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.service.EventMediaService;

/**
 * The controller of news media
 * @author Athens
 * @version 1.0
 */
@Controller
public class NewsMediaAcpController {
	
	private static final Logger logger = Logger.getLogger(NewsMediaAcpController.class);
	
	/**
	 * News Service instance
	 */
//	private NewsService newsService;
//	
//	@Autowired
//	public void setNewsService(NewsService newsService) {
//		this.newsService = newsService;
//	}
	
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
	 * set current media to as a cover media and refresh all media objects 
	 * @param mediaId the mediaId of current media
	 * @param eventUUID the eventUUID of current event
	 * @return data table of updated media object
	 */
	@RequestMapping(value="/events/setCoverMedia",produces="application/json")
	@ResponseBody
	public Map<String,Object> setCoverMedia(
			@RequestParam long mediaId, 
			@RequestParam String eventUUID){
		logger.info("entering /events/setCoverMedia");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "events/event_news_edit";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		//data - set cover primary state		
		EventMedia previousPrimaryMedia = eventMediaService.getPrimaryMediaByEventUUID(eventUUID);
		if (previousPrimaryMedia!=null){
			previousPrimaryMedia.setPrimaryMedia(false);
			eventMediaService.updateEventMedia(previousPrimaryMedia);
		}
		
		logger.info("mediaId="+mediaId+",eventUUID="+eventUUID);
		
		EventMedia media = eventMediaService.getEventMediaByMediaId(mediaId);
		media.setPrimaryMedia(true);
		eventMediaService.updateEventMedia(media);
		
		
		//data - media
		List<EventMedia> listEventMedia = eventMediaService.getEventMediaByEventUUID(eventUUID);
		logger.info("Length of EventReview entries: "+ listEventMedia.size());
		model.put("eventMediaList", listEventMedia);
		
		logger.info("leaving /events/setCoverMedia");
//		return mav;
		return model;
	}
	
	
	
	/**
	 * @param mediaId
	 * @param eventUUID
	 * @return
	 */
	@RequestMapping(value="/events/reloadEventMedia",produces="application/json")
	@ResponseBody
	public Map<String,Object> reloadEventMedia(
			@RequestParam String eventUUID){
		logger.info("entering /events/reloadEventMedia");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "events/event_news_edit";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		//data - media
		List<EventMedia> listEventMedia = eventMediaService.getEventMediaByEventUUID(eventUUID);
		logger.info("Length of EventReview entries: "+ listEventMedia.size());
		model.put("eventMediaList", listEventMedia);
		
		logger.info("leaving /events/reloadEventMedia");
//		return mav;
		return model;
	}
	
	@RequestMapping(value="/events/changeMediaName",method=RequestMethod.POST,produces="application/json")
	public Map<String,Object> changeMediaName(@RequestParam String itemJSONString) {
		
		logger.info("entering /events/changeMediaName");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
		Map<String, Object> model = mav.getModel();
        JSONObject ic_job= new JSONObject(itemJSONString);
   
//      News news = new News();
//      news.setGlobalId(ic_job.getLong("globalId"));
        String mediaId = Integer.toString(ic_job.getInt("mediaId"));
        String eventUUID = ic_job.getString("eventUUID");
        String mediaName = ic_job.getString("mediaName");
                 
//      logger.info("news = "+news);
          
		/* business logic*/
        //long itemId = itemService.createItem(ic); 

        eventMediaService.changeMediaName(mediaId, eventUUID, mediaName);
		
		/* assemble model and view */
//      model.put("news", news);
//        String viewName = "events/changeSortNumber";
//		mav.setViewName(viewName);		
		
		logger.info("leaving /events/changeMediaName");
		return model;		
	}
	
	@RequestMapping(value="/events/changeMediaLabel",method=RequestMethod.POST,produces="application/json")
	public Map<String,Object> changeMediaLabel(@RequestParam String itemJSONString) {
		
		logger.info("entering /events/changeMediaLabel");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
		Map<String, Object> model = mav.getModel();
        JSONObject ic_job= new JSONObject(itemJSONString);
   
//      News news = new News();
//      news.setGlobalId(ic_job.getLong("globalId"));
        String mediaId = Integer.toString(ic_job.getInt("mediaId"));
        String eventUUID = ic_job.getString("eventUUID");
        String mediaLabel = ic_job.getString("mediaLabel");
                 
//      logger.info("news = "+news);
          
		/* business logic*/
        //long itemId = itemService.createItem(ic); 

        eventMediaService.changeMediaLabel(mediaId, eventUUID, mediaLabel);
		
		/* assemble model and view */
//      model.put("news", news);
//        String viewName = "events/changeSortNumber";
//		mav.setViewName(viewName);		
		
		logger.info("leaving /events/changeMediaLabel");
		return model;		
	}

	
	@RequestMapping(value="/events/changeSortNumber",method=RequestMethod.POST,produces="application/json")
	public Map<String,Object> changeSortNumber(@RequestParam String itemJSONString) {
		
		logger.info("entering /events/changeSortNumber");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
		Map<String, Object> model = mav.getModel();
        JSONObject ic_job= new JSONObject(itemJSONString);
   
//      News news = new News();
//      news.setGlobalId(ic_job.getLong("globalId"));
        String mediaId = Integer.toString(ic_job.getInt("mediaId"));
        String eventUUID = ic_job.getString("eventUUID");
        String sortNumber = ic_job.getString("sortNumber");
                 
//      logger.info("news = "+news);
          
		/* business logic*/

        eventMediaService.changeSortNumber(mediaId, eventUUID, sortNumber);
		
		/* assemble model and view */
//      model.put("news", news);
//       String viewName = "events/changeSortNumber";
//		mav.setViewName(viewName);		
		
		logger.info("leaving /events/changeSortNumber");
		return model;		
	}
	

//@RequestMapping(value="/events/changeSortNumber",method=RequestMethod.POST)
	public ModelAndView changeSortNumberBak(@RequestParam String itemJSONString) {
		
		logger.info("entering /events/changeSortNumber");
		
		/* initial settings */
		ModelAndView mav = new ModelAndView();
		
		//set model
        JSONObject ic_job= new JSONObject(itemJSONString);
   
//      News news = new News();
//      news.setGlobalId(ic_job.getLong("globalId"));
        String mediaId = Integer.toString(ic_job.getInt("mediaId"));
        String eventUUID = ic_job.getString("eventUUID");
        String sortNumber = ic_job.getString("sortNumber");
                 
//      logger.info("news = "+news);
          
		/* business logic*/

        eventMediaService.changeSortNumber(mediaId, eventUUID, sortNumber);
		
		/* assemble model and view */
//      model.put("news", news);
        String viewName = "events/changeSortNumber";
		mav.setViewName(viewName);		
		
		logger.info("leaving /events/changeSortNumber");
		return mav;		
	} 


	
}
