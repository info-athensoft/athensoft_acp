package com.athensoft.content.event.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.content.event.entity.Event;
import com.athensoft.content.event.entity.News;

@Component
@Qualifier("newsDaoJDBCImpl")
public class NewsDaoJDBCImpl implements NewsDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Event> findAll() {
		String sql = "select * from event_news";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", globalId);
		List<Event> x = new ArrayList<Event>();
		try{
			x = jdbc.query(sql, paramSource, new NewsRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public List<Event> findByFilter(String queryString) {
		
		final String TABLE1 = "event_news";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" select * from "+TABLE1);
		sbf.append(" where 1=1 ");
		sbf.append(queryString);
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<Event> x = new ArrayList<Event>();
		try{
			x = jdbc.query(sql, paramSource, new NewsRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public Event findById(long globalId) {
		String sql = "select * from event_news where global_id =:global_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("global_id", globalId);
		Event x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new NewsRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public Event findByEventUUID(String eventUUID) {
		String sql = "select * from event_news where event_uuid =:event_uuid";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", eventUUID);
		Event x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new NewsRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

/*	@Override
	public void create() {
		// TODO Auto-generated method stub

	}
*/
	@Override
	public int create(News news) {
		final String TABLE1 = "event_news";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("insert into "+TABLE1);
		sbf.append("(event_uuid,title,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");
		sbf.append("values(:event_uuid,:title,:author,:post_datetime,:view_num,:desc_short,:desc_long,:event_class,:event_status)");
		String sql = sbf.toString();
		
//		final int USER_ACCOUNT_STATUS 	= 0;  //1: registered and active, 0: in-activated, 2: locked, pending     
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("event_uuid", news.getEventUUID());
		paramSource.addValue("title",news.getTitle());
		paramSource.addValue("author",news.getAuthor());
		paramSource.addValue("post_datetime",news.getPostDate());
		paramSource.addValue("view_num", news.getViewNum());
		paramSource.addValue("desc_short", news.getDescShort());
		paramSource.addValue("desc_long",news.getDescLong());
		paramSource.addValue("event_class",news.getEventClass());
		paramSource.addValue("event_status",news.getEventStatus());
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		int res = jdbc.update(sql, paramSource, keyholder);
		return res;
		
		//return jdbc.execute(sql, new UserAccountRowMapper());
	}

	@Override
	public int update(News news) {
		final String TABLE1 = "event_news";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("title = :title, ");
		sbf.append("author = :author, ");
		sbf.append("post_datetime = :post_datetime, ");
		sbf.append("view_num = :view_num, ");
		sbf.append("desc_short = :desc_short, ");
		sbf.append("desc_long = :desc_long, ");
		sbf.append("event_class = :event_class, ");
		sbf.append("event_status = :event_status ");
		sbf.append("where ");
		sbf.append("event_uuid = :event_uuid");
				
				/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
		
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("event_uuid", news.getEventUUID());
		paramSource.addValue("title",news.getTitle());
		paramSource.addValue("author",news.getAuthor());
		paramSource.addValue("post_datetime",news.getPostDate());
		paramSource.addValue("view_num", news.getViewNum());
		paramSource.addValue("desc_short", news.getDescShort());
		paramSource.addValue("desc_long",news.getDescLong());
		paramSource.addValue("event_class",news.getEventClass());
		paramSource.addValue("event_status",news.getEventStatus());
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		int res = jdbc.update(sql, paramSource, keyholder);
		return res;
		
	}

	@Override
	public int[] updateBatch(final List<News> newsList) {
		String sql = "update event_news set event_status=:eventStatus where event_uuid =:eventUUID";

		List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
		for (News x : newsList) {
			parameters.add(new BeanPropertySqlParameterSource(x));
		}

		int[] res = jdbc.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
		return res;
	}

	@Override
	public int markDeleted(String eventUUID) {
		final String TABLE1 = "event_news";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("event_status = :event_status ");
		sbf.append("where ");
		sbf.append("event_uuid = :event_uuid");
				
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("event_uuid", eventUUID);
		paramSource.addValue("event_status",3);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		int res= jdbc.update(sql, paramSource, keyholder);
		return res;
	}

	@Override
	public int delete(News news) {
		// TODO Auto-generated method stub
		return 0;
	
	}
	
	@Override
	public int[] deleteBatch(final List<News> newsList) {
		String sql = "delete from event_news where event_uuid =:eventUUID";

		List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
		for (News x : newsList) {
			parameters.add(new BeanPropertySqlParameterSource(x));
		}

		int[] res = jdbc.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
		return res;
	}

	private static class NewsRowMapper implements RowMapper<Event>{
		public Event mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Event x = new News();
			x.setGlobalId(rs.getLong("global_id"));
			x.setEventUUID(rs.getString("event_uuid"));
			x.setTitle(rs.getString("title"));
			x.setAuthor(rs.getString("author"));
			x.setViewNum(rs.getInt("view_num"));
			x.setDescShort(rs.getString("desc_short"));
			x.setDescLong(rs.getString("desc_long"));
			
				Timestamp ts = rs.getTimestamp("post_datetime");			
			x.setPostDate(new Date(ts.getTime()));
			
			x.setEventClass(rs.getString("event_class"));
			x.setEventStatus(rs.getInt("event_status"));
			
	        return x;
		}		
	}
	
	private static class NewsStatsRowMapper implements RowMapper<Map<String, Integer>>{
		public Map<String, Integer> mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Map<String, Integer> x= new HashMap<String, Integer>();
			x.put(rs.getInt("yr")+"."+rs.getInt("mo"), new Integer(rs.getInt("sum")));
	        return x;
		}		
	}

	@Override
	public List<Map<String, Integer>> getViewNumStats() {
		String sql = "SELECT t.yr, t.mo, t.sum FROM (SELECT year(post_datetime) as yr, month(post_datetime) as mo, sum(view_num) as sum, post_datetime FROM event_news group by year(post_datetime), month(post_datetime) order by post_datetime desc limit 9) as t ORDER BY t.post_datetime";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<Map<String, Integer>> x = new ArrayList<Map<String, Integer>>();
		try{
			x = jdbc.query(sql, paramSource, new NewsStatsRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
//		System.out.println("Length of getViewNumStats: "+ x.size());
//		System.out.println(x);
		return x;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}


}
