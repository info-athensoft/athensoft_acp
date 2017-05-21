package com.athensoft.ecomm.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.ecomm.item.entity.ItemCategory;
import com.athensoft.util.UUIDHelper;

@Component
@Qualifier("itemCategoryDaoJDBCImpl")
public class ItemCategoryDaoJDBCImpl implements ItemCategoryDao{
	
	private static final Logger logger = Logger.getLogger(ItemCategoryDaoJDBCImpl.class);
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void dragAndDropResultSaved(String orig, String dest) {
		logger.info("dragAndDropResultSaved called in ItemCategoryJDBCImpl");
		logger.info("orig=" + orig + " dest=" + dest);
	}

	@Override
	public void renameResultSaved(String key, String newText) {
		String sql = "update item_category set category_name =:newText where category_code =:key";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("newText", newText);
		paramSource.addValue("key", key);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
		
	}

	@Override
	public List<ItemCategory> findAll() {
		String sql = "select * from item_category where category_level > 0 AND parent_id < 10 order by category_level, category_code";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", globalId);
		List<ItemCategory> x = new ArrayList<ItemCategory>();
		try{
			x = jdbc.query(sql, paramSource, new ItemCategoryRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}
	
	private static class ItemCategoryRowMapper implements RowMapper<ItemCategory>{
		public ItemCategory mapRow(ResultSet rs, int rowNumber) throws SQLException {
			ItemCategory x = new ItemCategory();
			x.setCategoryId(rs.getLong("category_id"));
			x.setParentId(rs.getLong("parent_id"));
			x.setCategoryCode(rs.getString("category_code"));
			x.setCategoryName(rs.getString("category_name"));
			x.setCategoryDesc(rs.getString("category_desc"));
			x.setCategoryLevel(rs.getInt("category_level"));
			x.setCategoryStatus(rs.getInt("category_status"));
	        return x;
		}		
	}

	@Override
	public ItemCategory findByCategoryId(long categoryId) {
		String sql = "select * from item_category where category_id =:categoryId";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("categoryId", categoryId);
		ItemCategory x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new ItemCategoryRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public ItemCategory findByCategoryCode(String categoryCode) {
		String sql = "select * from item_category where category_code =:categoryCode";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("categoryCode", categoryCode);
		ItemCategory x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new ItemCategoryRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}
	
	@SuppressWarnings("deprecation")
	private long getBiggestCategoryNo() {
		String sql = "select category_code from item_category order by category_code desc limit 1";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		long x;
		try{
			x = jdbc.queryForLong(sql, paramSource);
		}catch(EmptyResultDataAccessException ex){
			x = 0;
		}
		return x;
	}

	@Override
	public String createResultSaved(long parentId, String text, int parentLevel) {
		
		final String TABLE1 = "item_category";
//		String newCategoryCode = this.getBiggestCategoryNo()+1;
		String newCategoryCode = UUIDHelper.getUUID();
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("insert into "+TABLE1);
		sbf.append("(category_code,category_name,parent_id,category_level) ");
		sbf.append("values(:category_code,:category_name,:parent_id,:category_level)");
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_code", newCategoryCode);
		paramSource.addValue("category_name", text);
		paramSource.addValue("parent_id", parentId);
		paramSource.addValue("category_level", parentLevel+1);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return newCategoryCode;
	}

	@Override
	public List<ItemCategory> getChildren(long categoryId) {
		String sql = "select * from item_category where parent_id=:categoryId";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("categoryId", categoryId);
//		paramSource.addValue("global_id", globalId);
		List<ItemCategory> x = new ArrayList<ItemCategory>();
		try{
			x = jdbc.query(sql, paramSource, new ItemCategoryRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}

	@Override
	public void updateItemCategoryParent(long categoryId, long parentId, int level) {
		final String TABLE1 = "item_category";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("update "+TABLE1+" ");
		sbf.append("set ");
		sbf.append("parent_id = :parent_id, ");
		sbf.append("category_level = :category_level ");
		
		sbf.append("where ");
		sbf.append("category_id = :category_id");
				
		String sql = sbf.toString();
		
//		final Date dateCreate 			= new Date();
//		final Date dateLastModified 	= dateCreate;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("global_id", news.getGlobalId());
		paramSource.addValue("category_id", categoryId);
		paramSource.addValue("parent_id", parentId);
		paramSource.addValue("category_level", level);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
	}

	@Override
	public void deleteItemCategoryByCategoryId(long categoryId) {
		String sql = "delete from item_category where category_id =:category_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("category_id", categoryId);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
	}

}
