package com.athensoft.ecomm.item.dao;

public interface ItemCategoryDao {

	void dragAndDropResultSaved(String orig, String dest);

	void renameResultSaved(String key, String newText);

}
