package com.athensoft.content.event.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.content.event.dao.NewsDao;
import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.News;

/**
 * News Service
 * @author Athens
 * @version 1.0
 */
/**
 * @author Athens
 *
 */
@Service
public class NewsService {
	
	/**
	 * DAO of News
	 */
	@Autowired
	@Qualifier("newsDaoJDBCImpl")
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	/**
	 * get a news object by its globalId
	 * @param globalId the globalId of news object
	 * @return the target News object
	 */
	public News getNewsById(long globalId){
		return (News)newsDao.findById(globalId);
	}
	
	/**
	 * get a news object by its eventUUID
	 * @param eventUUID the eventUUID of news object
	 * @return the target News object
	 */
	public News getNewsByEventUUID(String eventUUID){
		return (News)newsDao.findByEventUUID(eventUUID);
	}
	
	/**
	 * get news objects by search criteria
	 * @param queryString search criteria for qualified news objects
	 * @return list of news object
	 */
	public List<Event> getNewsByFilter(String queryString){
		return newsDao.findByFilter(queryString);
	}

	/**
	 * get all news objects<p>
	 * WARNING: DO NOT USE THIS METHOD IN PRODUCT. JUST FOR TEST.
	 * @return list of news objects
	 */
	public List<Event> getAllNews(){
		return newsDao.findAll();
	}
	
	/**
	 * create a news object and persist it
	 * @param news a news object to persist
	 */
	public void createNews(News news) {
		this.newsDao.create(news);
		return;
	}

	/**
	 * update a news object and persist it
	 * @param news a news object to persist
	 */
	public void updateNews(News news) {
		this.newsDao.update(news);
	}
	
	/**
	 * update news objects and persist them in batch
	 * @param newsList
	 */
	public void updateNewsGroup(List<News> newsList) {
		this.newsDao.updateBatch(newsList);
	}

	/**
	 * @param eventUUID
	 */
	public void markNewsStatusDeleted(String eventUUID) {
		this.newsDao.markNewsStatusDeleted(eventUUID);
	}
	
	/**
	 * delete news objects and persist them in batch
	 * @param newsList
	 */
	public void deleteNewsGroup(List<News> newsList) {
		this.newsDao.deleteBatch(newsList);
	}

	public List<Map<String, Integer>> getViewNumStats() {
		return this.newsDao.getViewNumStats();
	}
}
