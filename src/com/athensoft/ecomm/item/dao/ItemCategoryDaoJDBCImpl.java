package com.athensoft.ecomm.item.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.athensoft.content.event.dao.NewsDaoJDBCImpl;

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
		System.out.println("dragAndDropResultSaved called in ItemCategoryJDBCImpl");
		System.out.println("orig=" + orig + " dest=" + dest);
	}

	@Override
	public void renameResultSaved(String key, String newText) {
		String sql = "update item_category set name =:newText where category_no =:key";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("newText", newText);
		paramSource.addValue("key", key);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, paramSource, keyholder);
		return;
		
	}

}
