package com.athensoft.ecomm.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.athensoft.ecomm.item.dao.ItemCategoryDao;
import com.athensoft.ecomm.item.entity.ItemCategory;

@Service
public class ItemCategoryService {
	
	/**
	 * DAO of ItemCategory
	 */
	@Autowired
	@Qualifier("itemCategoryDaoJDBCImpl")
	private ItemCategoryDao itemCategoryDao;

	public void setItemCategoryDao(ItemCategoryDao itemCategoryDao) {
		this.itemCategoryDao = itemCategoryDao;
	}

	public void dragAndDropResultSaved(String orig, String dest) {
		this.itemCategoryDao.dragAndDropResultSaved(orig, dest);
	}

	public void renameResultSaved(String key, String newText) {
		this.itemCategoryDao.renameResultSaved(key, newText);
	}

	public List<ItemCategory> findAll() {
		return this.itemCategoryDao.findAll();
	}
	
	public ItemCategory findByCategoryId(long categoryId) {
		return this.itemCategoryDao.findByCategoryId(categoryId);
	}

	public ItemCategory findByCategoryNo(long categoryNo) {
		return this.itemCategoryDao.findByCategoryNo(categoryNo);
	}

	public long createResultSaved(long parentId, String text, int parentLevel) {
		return this.itemCategoryDao.createResultSaved(parentId, text, parentLevel);
	}

}
