package com.athensoft.ecomm.item.dao;

import java.util.List;

import com.athensoft.ecomm.item.entity.ItemCategory;

public interface ItemCategoryDao {
	
	public List<ItemCategory> findAll();
	
	public ItemCategory findByCategoryId(long categoryId);
	
	public ItemCategory findByCategoryCode(String categoryCode);

	void dragAndDropResultSaved(String orig, String dest);

	void renameResultSaved(String key, String newText);

	public String createResultSaved(long parentId, String text, int parentLevel);

	public List<ItemCategory> getChildren(long categoryId);

	public void updateItemCategoryParent(long categoryId, long parentId, int level);

	public void deleteItemCategoryByCategoryId(long categoryId);
	

}
