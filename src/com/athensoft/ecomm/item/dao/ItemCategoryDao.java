package com.athensoft.ecomm.item.dao;

import java.util.List;

import com.athensoft.ecomm.item.entity.ItemCategory;

public interface ItemCategoryDao {
	
	/**
	 * @return
	 * @author Fangze Sun
	 */
	public List<ItemCategory> findAll();
	
	/**
	 * @param categoryId
	 * @return
	 * @author Athens
	 */
	public List<ItemCategory> findTreeByCategoryId(int categoryId);
	
	/**
	 * @param categoryId
	 * @return
	 * @author Fangze Sun
	 */
	public ItemCategory findByCategoryId(long categoryId);
	
	/**
	 * @param categoryCode
	 * @return
	 * @author Fangze Sun
	 */
	public ItemCategory findByCategoryCode(String categoryCode);

	/**
	 * @param orig
	 * @param dest
	 * @author Fangze Sun
	 */
	void dragAndDropResultSaved(String orig, String dest);

	/**
	 * @param key
	 * @param newText
	 * @author Fangze Sun
	 */
	void renameResultSaved(String key, String newText);

	/**
	 * @param parentId
	 * @param text
	 * @param parentLevel
	 * @return
	 * @author Fangze Sun
	 */
	public String createResultSaved(long parentId, String text, int parentLevel);

	/**
	 * @param categoryId
	 * @return
	 * @author Fangze Sun
	 */
	public List<ItemCategory> getChildren(long categoryId);

	/**
	 * @param categoryId
	 * @param parentId
	 * @param level
	 * @author Fangze Sun
	 */
	public void updateItemCategoryParent(long categoryId, long parentId, int level);

	/**
	 * @param categoryId
	 * @author Fangze Sun
	 */
	public void deleteItemCategoryByCategoryId(long categoryId);
	

}
