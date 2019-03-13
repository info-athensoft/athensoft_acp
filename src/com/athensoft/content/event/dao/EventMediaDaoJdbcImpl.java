package com.athensoft.content.event.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.base.dao.BaseDaoJdbcImpl;
import com.athensoft.content.event.entity.EventMedia;
import com.athensoft.content.event.entity.News;

/**
 * The Spring JDBC Implementation of {@link:EventMediaDao}
 * 
 * @author Athens
 *
 */
@Component
@Qualifier("eventMediaDaoJdbcImpl")
public class EventMediaDaoJdbcImpl extends BaseDaoJdbcImpl implements EventMediaDao {

	private static final String TABLE = "event_media";

	@Override
	public List<EventMedia> findAll() {
		String sql = "SELECT * from " + TABLE;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<EventMedia> x = new ArrayList<EventMedia>();
		try {
			x = jdbc.query(sql, paramSource, new EventMediaRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}

	@Override
	public EventMedia findById(long medialId) {
		String sql = "select * from " + TABLE + " where media_id=:media_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("media_id", medialId);
		EventMedia x = new EventMedia();
		try {
			x = jdbc.queryForObject(sql, paramSource, new EventMediaRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}

	@Override
	public List<EventMedia> findByEventUUID(String eventUUID) {
		String sql = "select * from " + TABLE + " where event_uuid=:event_uuid order by sort_number";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", eventUUID);
		List<EventMedia> x = new ArrayList<EventMedia>();
		try {
			x = jdbc.query(sql, paramSource, new EventMediaRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}

	@Override
	public EventMedia findPrimaryMediaByEventUUID(String eventUUID) {
		// select the eventmedia which is already the primary media
		// String sql = "SELECT * from "+TABLE+" where event_uuid=:event_uuid
		// and is_primary_media = 1";
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT * ");
		sbf.append(" FROM " + TABLE);
		sbf.append(" WHERE 1=1 ");
		sbf.append(" AND event_uuid=:event_uuid ");
		sbf.append(" AND is_primary_media = 1 ");

		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", eventUUID);
		EventMedia x = new EventMedia();
		try {
			x = jdbc.queryForObject(sql, paramSource, new EventMediaRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			x = null;
		}
		return x;
	}

	@Override
	public int create(EventMedia media) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("INSERT INTO " + TABLE);
		sbf.append(" (event_uuid,media_url,media_name,media_label,post_timestamp,is_primary_media) ");
		sbf.append(" VALUES(:event_uuid,:media_url,:media_name,:media_label,:post_timestamp,is_primary_media)");
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("event_uuid", media.getEventUUID());
		paramSource.addValue("media_url", media.getMediaURL());
		paramSource.addValue("media_name", media.getMediaName());
		paramSource.addValue("media_label", media.getMediaLabel());
		paramSource.addValue("post_timestamp", media.getPostTimestamp());
		paramSource.addValue("is_primary_media", media.isPrimaryMedia() ? 1 : 0);

		KeyHolder keyholder = new GeneratedKeyHolder();
		//jdbc.update(sql, paramSource, keyholder);
		return jdbc.update(sql, paramSource, keyholder);
	}

	@Override
	public int delete(EventMedia eventMediaDTO) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("DELETE FROM ").append(TABLE);
		sbf.append(" WHERE ");
		sbf.append(" event_uuid =:eventUUID");
		
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("eventUUID", eventMediaDTO.getEventUUID());

		return jdbc.update(sql, paramSource);
	}

	@Override
	public int delete(long mediaId) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("DELETE FROM ").append(TABLE);
		sbf.append(" WHERE ");
		sbf.append(" media_id =:media_id");
		
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("media_id", mediaId);

		return jdbc.update(sql, paramSource);
	}

	@Override
	public int update(EventMedia media) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("UPDATE " + TABLE + " ");
		sbf.append("SET ");
		sbf.append("is_primary_media = :is_primary_media ");
		sbf.append("WHERE ");
		sbf.append("media_id = :media_id");

		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("is_primary_media", media.isPrimaryMedia() ? 1 : 0);
		paramSource.addValue("media_id", media.getMediaId());

		return jdbc.update(sql, paramSource);
	}

	@Override
	public int changeSortNumber(String mediaId, String eventUUID, String sortNumber) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("UPDATE " + TABLE + " ");
		sbf.append("SET ");
		sbf.append("sort_number = :sortNumber ");
		sbf.append("WHERE 1=1 ");
		sbf.append("AND media_id = :media_id ");
		sbf.append("AND event_uuid = :eventUUID");

		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("media_id", mediaId);
		paramSource.addValue("eventUUID", eventUUID);
		paramSource.addValue("sortNumber", sortNumber);
		
		return jdbc.update(sql, paramSource);

	}

	@Override
	public int changeMediaName(String mediaId, String eventUUID, String mediaName) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("UPDATE " + TABLE + " ");
		sbf.append("SET ");
		sbf.append("media_name = :media_name ");
		sbf.append("WHERE 1=1 ");
		sbf.append("AND media_id = :media_id ");
		sbf.append("AND event_uuid = :event_uuid");

		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("media_id", mediaId);
		paramSource.addValue("event_uuid", eventUUID);
		paramSource.addValue("media_name", mediaName);
		
		return jdbc.update(sql, paramSource);
	}

	@Override
	public int changeMediaLabel(String mediaId, String eventUUID, String mediaLabel) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("UPDATE " + TABLE + " ");
		sbf.append("SET ");
		sbf.append("media_label = :media_label ");
		sbf.append("WHERE 1=1 ");
		sbf.append("AND media_id = :media_id ");
		sbf.append("AND event_uuid = :event_uuid");

		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("media_id", mediaId);
		paramSource.addValue("event_uuid", eventUUID);
		paramSource.addValue("media_label", mediaLabel);

		return jdbc.update(sql, paramSource);
	}

	private static class EventMediaRowMapper implements RowMapper<EventMedia> {
		public EventMedia mapRow(ResultSet rs, int rowNumber) throws SQLException {
			EventMedia x = new EventMedia();
			x.setMediaId(rs.getLong("media_id"));
			x.setEventUUID(rs.getString("event_uuid"));
			x.setMediaURL(rs.getString("media_url"));
			x.setMediaName(rs.getString("media_name"));
			x.setMediaLabel(rs.getString("media_label"));
			x.setSortNumber(rs.getInt("sort_number"));
			x.setPrimaryMedia(rs.getInt("is_primary_media") == 1 ? true : false);
			x.setMediaType(rs.getInt("media_type"));

			Timestamp pt = rs.getTimestamp("post_timestamp");
			x.setPostTimestamp(pt == null ? null : new Date(pt.getTime()));
			return x;
		}
	}
}
