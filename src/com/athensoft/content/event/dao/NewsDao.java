package com.athensoft.content.event.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.News;

/**
 * A DAO interface of {@link News}
 * 
 * @author Athens
 * @version 1.0 
 */
public interface NewsDao {
	/**
	 * get all news objects<p>
	 * WARNING: DO NOT USE THIS METHOD IN PRODUCT, JUST FOR TEST.
	 * @return	list of news objects
	 */
	public List<Event> findAll();
	
	/**
	 * get all objects which comply with query criteria
	 * @param queryString search criteria of news
	 * @return	list of news objects
	 */
	public List<Event> findByFilter(String queryString);
	
	/**
	 * get news object by its gloablId
	 * @param globalId the globlaId of news object
	 * @return a news object
	 */
	public Event findById(long globalId);
	
	/**
	 * get news object by its eventUUID
	 * @param eventUUID the eventUUID of news object
	 * @return a news object
	 */
	public Event findByEventUUID(String eventUUID);	
	
	/**
	 * create a news object and persist it
	 * @param news a news object
	 */
	public void create(News news);
	
	/**
	 * update a news object and persist it
	 * @param news a news object
	 */
	public void update(News news);
	
	/**
	 * update news objects and persist them in batch
	 * @param news list of news objects to persist
	 */
	public void updateBatch(List<News> news);

	public void markNewsStatusDeleted(String eventUUID);

	/**
	 * remove a news object from data source<p>
	 * WARNING: THE METHOD HAS NOT COMPLETED.
	 */
	public void delete();
	
	/**
	 * remove news objects permanently in batch
	 * @param news list of news objects to persist
	 */
	public void deleteBatch(List<News> news);

	public List<Map<String, Integer>> getViewNumStats();
	
}
