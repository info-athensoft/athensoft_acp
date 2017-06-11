package com.athensoft.content.event.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.content.event.entity.EventMedia;

/**
 * The Spring JDBC Implementation of {@link:EventMediaDao}
 * @author Athens
 *
 */
@Component
@Qualifier("eventMediaDaoJDBCImpl")
public class EventMediaDaoJDBCImpl implements EventMediaDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<EventMedia> findAll() {
		String sql = "select * from event_media";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<EventMedia> x = new ArrayList<EventMedia>();		
		try{
			x = jdbc.query(sql, paramSource, new EventMediaRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public EventMedia findById(long medialId) {
		String sql = "select * from event_media where media_id=:media_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("media_id", medialId);
		EventMedia x = new EventMedia();
		try{
			x = jdbc.queryForObject(sql, paramSource, new EventMediaRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public List<EventMedia> findByEventUUID(String eventUUID) {
		String sql = "select * from event_media where event_uuid=:event_uuid order by sort_number";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", eventUUID);
		List<EventMedia> x = new ArrayList<EventMedia>();
		try{
			x = jdbc.query(sql, paramSource, new EventMediaRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}
	
	@Override
	public EventMedia findPrimaryMediaByEventUUID(String eventUUID) {
		//select the eventmedia which is already the primary media 
		String sql = "select * from event_media where event_uuid=:event_uuid and is_primary_media = 1";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", eventUUID);
		EventMedia x = new EventMedia();
		try{
			x = jdbc.queryForObject(sql, paramSource, new EventMediaRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public void create(EventMedia media) {
		final String TABLE1 = "event_media";
		StringBuffer sbf = new StringBuffer();
		sbf.append("insert into "+TABLE1);
		sbf.append(" (event_uuid,media_url,media_name,media_label,post_timestamp) ");
		sbf.append(" values(:event_uuid,:media_url,:media_name,:media_label,:post_timestamp)");
		String sql =  sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", media.getEventUUID());
		paramSource.addValue("media_url", media.getMediaURL());
		paramSource.addValue("media_name", media.getMediaName());
		paramSource.addValue("media_label", media.getMediaLabel());
		paramSource.addValue("post_timestamp", media.getPostTimestamp());
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
	}

	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EventMedia media) {
		final String TABLE1 = "event_media";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("is_primary_media = :is_primary_media ");
		sbf.append("where ");
		sbf.append("media_id = :media_id");
				
				/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
		
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("is_primary_media", media.isPrimaryMedia()?1:0);
		paramSource.addValue("media_id",media.getMediaId());
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
		
	}

	@Override
	public void changeSortNumber(String mediaId, String eventUUID, String sortNumber) {
		final String TABLE1 = "event_media";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("sort_number = :sortNumber ");
		sbf.append("where 1=1 ");
		sbf.append("and media_id = :media_id ");
		sbf.append("and event_uuid = :eventUUID");
				
				/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
		
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		
		paramSource.addValue("media_id",mediaId);
		paramSource.addValue("eventUUID", eventUUID);
		paramSource.addValue("sortNumber", sortNumber);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
		
	}

	@Override
	public void changeMediaName(String mediaId, String eventUUID, String mediaName) {
		final String TABLE1 = "event_media";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("media_name = :media_name ");
		sbf.append("where 1=1 ");
		sbf.append("and media_id = :media_id ");
		sbf.append("and event_uuid = :event_uuid");
				
				/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
		
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		
		paramSource.addValue("media_id",mediaId);
		paramSource.addValue("event_uuid", eventUUID);
		paramSource.addValue("media_name", mediaName);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
	}

	@Override
	public void changeMediaLabel(String mediaId, String eventUUID, String mediaLabel) {
		final String TABLE1 = "event_media";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("media_label = :media_label ");
		sbf.append("where 1=1 ");
		sbf.append("and media_id = :media_id ");
		sbf.append("and event_uuid = :event_uuid");
				
				/*+ "(,author,post_datetime,view_num,desc_short,desc_long,event_class,event_status) ");*/
		
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		
		paramSource.addValue("media_id",mediaId);
		paramSource.addValue("event_uuid", eventUUID);
		paramSource.addValue("media_label", mediaLabel);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
		
	}


	private static class EventMediaRowMapper implements RowMapper<EventMedia>{
			public EventMedia mapRow(ResultSet rs, int rowNumber) throws SQLException {
				EventMedia x = new EventMedia();
				x.setMediaId(rs.getLong("media_id"));
				x.setEventUUID(rs.getString("event_uuid"));
				x.setMediaURL(rs.getString("media_url"));
				x.setMediaName(rs.getString("media_name"));
				x.setMediaLabel(rs.getString("media_label"));
				x.setSortNumber(rs.getInt("sort_number"));
					int intIsPrimaryMedia = rs.getInt("is_primary_media");
					boolean isPrimaryMedia = intIsPrimaryMedia==1?true:false;
				x.setPrimaryMedia(isPrimaryMedia);
				x.setMediaType(rs.getInt("media_type"));
					Timestamp ts = rs.getTimestamp("post_timestamp");			
				x.setPostTimestamp(new Date(ts.getTime()));
	            return x;
			}		
		}
}
