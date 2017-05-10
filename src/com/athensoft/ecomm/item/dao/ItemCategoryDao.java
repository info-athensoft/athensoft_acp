package com.athensoft.ecomm.item.dao;

import java.util.List;

import com.athensoft.ecomm.item.entity.ItemCategory;

public interface ItemCategoryDao {
	
	public List<ItemCategory> findAll();
	
	public ItemCategory findByCategoryId(long categoryId);
	
	public ItemCategory findByCategoryNo(long categoryNo);

	void dragAndDropResultSaved(String orig, String dest);

	void renameResultSaved(String key, String newText);

	public long createResultSaved(long parentId, String text, int parentLevel);
	

}
