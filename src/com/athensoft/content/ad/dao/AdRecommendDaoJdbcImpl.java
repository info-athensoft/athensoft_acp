package com.athensoft.content.ad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.athensoft.base.dao.BaseDaoJdbcImpl;
import com.athensoft.content.ad.entity.AdRecommend;

@Repository
@Qualifier("adRecommendDaoJdbcImpl")
public class AdRecommendDaoJdbcImpl extends BaseDaoJdbcImpl implements AdRecommendDao {
	private static final Logger logger = Logger.getLogger(AdRecommendDaoJdbcImpl.class);
	
	private final String TABLE = "ad_recommend";

	@Override
	public List<AdRecommend> findAll() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("global_id, ");
		sbf.append("ad_uuid, ");
		sbf.append("page_id, ");
		sbf.append("page_name, ");
		sbf.append("rcmd_score, ");
		sbf.append("rcmd_rank, ");
		sbf.append("rcmd_status ");
		sbf.append(" FROM " + TABLE);
		sbf.append(" ORDER BY page_id");
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		return jdbc.query(sql, paramSource, new AdRecommendRowMapper());
	}

	@Override
	public List<AdRecommend> findByPageId(int pageId) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("global_id, ");
		sbf.append("ad_uuid, ");
		sbf.append("page_id, ");
		sbf.append("page_name, ");
		sbf.append("rcmd_score, ");
		sbf.append("rcmd_rank, ");
		sbf.append("rcmd_status ");
		sbf.append(" FROM " + TABLE);
		sbf.append(" WHERE page_id=:page_id");
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("page_id", pageId);
		return jdbc.query(sql, paramSource, new AdRecommendRowMapper());
	}

	@Override
	public AdRecommend findById(int globalId) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("global_id, ");
		sbf.append("ad_uuid, ");
		sbf.append("page_id, ");
		sbf.append("page_name, ");
		sbf.append("rcmd_score, ");
		sbf.append("rcmd_rank, ");
		sbf.append("rcmd_status ");
		sbf.append(" FROM " + TABLE);
		sbf.append(" WHERE global_id = :globalId");
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("globalId", globalId);
		AdRecommend x = new AdRecommend();
		try {
			x = jdbc.queryForObject(sql, paramSource, new AdRecommendRowMapper());
		} catch (Exception ex) {
			x = null;
		}
		return x;
	}

	@Override
	public List<AdRecommend> findByFilter(String queryString) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("global_id, ");
		sbf.append("ad_uuid, ");
		sbf.append("page_id, ");
		sbf.append("page_name, ");
		sbf.append("rcmd_score, ");
		sbf.append("rcmd_rank, ");
		sbf.append("rcmd_status ");
		sbf.append(" FROM " + TABLE);
		sbf.append(" WHERE 1=1 ");
		sbf.append(queryString);
		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<AdRecommend> x = new ArrayList<AdRecommend>();
		try {
			x = jdbc.query(sql, paramSource, new AdRecommendRowMapper());
		} catch (Exception ex) {
			x = null;
		}
		return x;
	}

	@Override
	public int create(AdRecommend x) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(" INSERT INTO ").append(TABLE);
		sbf.append(" (");
		sbf.append(" ad_uuid,");
		sbf.append(" page_id, ");
		sbf.append(" page_name, ");
		sbf.append(" rcmd_score, ");
		sbf.append(" rcmd_rank, ");
		sbf.append(" rcmd_status ");
		sbf.append(" ) VALUES (");
		sbf.append(" :ad_uuid,");
		sbf.append(" :page_id, ");
		sbf.append(" :page_name, ");
		sbf.append(" :rcmd_score, ");
		sbf.append(" :rcmd_rank, ");
		sbf.append(" :rcmd_status ");
		sbf.append(" )");

		String sql = sbf.toString();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("ad_uuid", x.getAdUUID());
		paramSource.addValue("page_id", x.getPageId());
		paramSource.addValue("page_name", x.getPageName());
		paramSource.addValue("rcmd_score", x.getRcmdScore());
		paramSource.addValue("rcmd_rank", x.getRcmdRank());
		paramSource.addValue("rcmd_status", x.getRcmdStatus());

		int res = 0;
		try {
			res = jdbc.update(sql, paramSource);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;

	}

	@Override
	public int update(AdRecommend x) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(" UPDATE ").append(TABLE);
		sbf.append(" SET ad_uuid=:ad_uuid,");
		sbf.append("  page_id=:page_id,");
		sbf.append("  page_name=:page_name,");
		sbf.append("  rcmd_rank=:rcmd_rank,");
		// sbf.append(" rcmd_score=:rcmd_score,");
		sbf.append("  rcmd_status=:rcmd_status ");
		sbf.append(" WHERE global_id=:global_id");

		String sql = sbf.toString();
		MapSqlParameterSource paramSource = new MapSqlParameterSource();

		paramSource.addValue("ad_uuid", x.getAdUUID());
		paramSource.addValue("page_id", x.getPageId());
		paramSource.addValue("page_name", x.getPageName());
		paramSource.addValue("rcmd_rank", x.getRcmdRank());
		paramSource.addValue("rcmd_status", x.getRcmdStatus());
		paramSource.addValue("global_id", x.getGlobalId());

		return jdbc.update(sql, paramSource);
	}

	@Override
	public int[] updateBatch(List<AdRecommend> adRecommendList) {
		logger.debug("updateBatch() adRecommendList size=" + adRecommendList == null ? "NULL" : adRecommendList.size());
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("UPDATE ").append(TABLE);
		sbf.append(" SET");
		sbf.append(" ad_status=:adStatus");
		sbf.append(" WHERE ad_uuid =:adUUID");
		
		String sql = sbf.toString();
		
		List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
		for (AdRecommend x : adRecommendList) {
			parameters.add(new BeanPropertySqlParameterSource(x));
		}

		// jdbc.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
		return jdbc.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
	}

	@Override
	public int delete(AdRecommend x) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(" DELETE FROM ").append(TABLE);
		sbf.append(" WHERE global_id=:global_id");

		String sql = sbf.toString();

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("global_id", x.getGlobalId());

		return jdbc.update(sql, paramSource);
	}

	private static class AdRecommendRowMapper implements RowMapper<AdRecommend> {
		public AdRecommend mapRow(ResultSet rs, int rowNumber) throws SQLException {
			AdRecommend x = new AdRecommend();
			x.setGlobalId(rs.getInt("global_id"));
			x.setAdUUID(rs.getString("ad_uuid"));
			x.setPageId(rs.getInt("page_id"));
			x.setPageName(rs.getString("page_name"));
			x.setRcmdRank(rs.getInt("rcmd_rank"));
			x.setRcmdScore(rs.getDouble("rcmd_score"));
			x.setRcmdStatus(rs.getInt("rcmd_status"));
			return x;
		}
	}

}
