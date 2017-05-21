package com.athensoft.ecomm.item.controller;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.ecomm.item.entity.ItemCategory;
import com.athensoft.ecomm.item.service.ItemCategoryService;
import com.athensoft.util.Node;

/**
 * @author Athens
 *
 */
@Controller
public class ItemCategoryAcpController {
	
	private static final Logger logger = Logger.getLogger(ItemCategoryAcpController.class);
	private static Random rand = new Random();

	/**
	 * ItemCategory Service instance
	 */
	private ItemCategoryService itemCategoryService;
	
	@Autowired
	public void setItemCategoryService(ItemCategoryService itemCategoryService) {
		this.itemCategoryService = itemCategoryService;
	}
	
	/**
	 * go to the view of item category
	 * @return the target view name 
	 */
	/*
	@RequestMapping(value="/item/testcategory")
	public String gotoTestCategory(){
		String viewName = "item/test_item_category";
		return viewName;
	} */
	
	@RequestMapping(value="/item/testcategory",produces="application/json")
	@ResponseBody
	public ModelAndView gotoTestCategory(){
		logger.info("entering /item/testcategory");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/test_item_category";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		//build jstree data
		Node treeRootNode = new Node(null);
	    treeRootNode.setText("Category Classification");
	    treeRootNode.setState(Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "1")));
/*	  // add child to root node 
	    Node parentNode = Node.addChild(treeRootNode, "My Parent Node", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "1")));

	    // add child to the child node created above
	    Node.addChild(parentNode, "Initially selected", Node.buildList(new AbstractMap.SimpleEntry<String, String>("selected", "true"), new AbstractMap.SimpleEntry<String, String>("key", "key-11")));
	    Node.addChild(parentNode, "Custom Icon", "fa fa-warning icon-state-danger", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-12")));
	    Node initiallyOpen = Node.addChild(parentNode, "Initially open", "fa fa-folder icon-state-success", Node.buildList(new AbstractMap.SimpleEntry<String, String>("opened", "true"), new AbstractMap.SimpleEntry<String, String>("key", "key-13"))); 
	  // add child to the child node created above
	    Node.addChild(initiallyOpen, "Another node", "fa fa-file icon-state-warning", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-131")));
	  
	    Node.addChild(parentNode, "Another Custom Icon", "fa fa-warning icon-state-warning", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-14")));
	    Node.addChild(parentNode, "Disabled Node", "fa fa-check icon-state-success", Node.buildList(new AbstractMap.SimpleEntry<String, String>("disabled", "true"), new AbstractMap.SimpleEntry<String, String>("key", "key-15"))); 	  
	  
	    Node subNodes = Node.addChild(parentNode, "Sub Nodes", "fa fa-folder icon-state-danger", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-16"))); 
	  // add child to the child node created above
	    Node.addChild(subNodes, "Item 1", "fa fa-file icon-state-warning", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-161")));
	    Node.addChild(subNodes, "Item 2", "fa fa-file icon-state-success", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-162")));
	    Node.addChild(subNodes, "Item 3", "fa fa-file icon-state-default", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-163")));
	    Node.addChild(subNodes, "Item 4", "fa fa-file icon-state-danger", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-164")));
	    Node.addChild(subNodes, "Item 5", "fa fa-file icon-state-info", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-165")));
	  
	    Node.addChild(treeRootNode, "Another Node", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-2")));
*/
	    List<ItemCategory> list = new ArrayList<ItemCategory>();
	    list = this.itemCategoryService.findAll();
	    for (ItemCategory ic : list) {
	    	long parent = ic.getParentId();
//	    	logger.info("parent_id="+parent);
	    	ItemCategory p = this.itemCategoryService.findByCategoryId(parent);
	    	long parentNo = p.getCategoryNo();
//	    	logger.info("parent_no="+parentNo);
	    	Node parentNode = Node.getNodeByKey(treeRootNode, Long.toString(parentNo));
//	    	logger.info("parentNode.text="+parentNode.getText());
	    	Node.addChild(parentNode, ic.getName(), Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", Long.toString(ic.getCategoryNo()))));
	    }
	    StringBuffer jsTreeData = Node.buildJSTree(treeRootNode, "  ").append("}");
//	    System.out.println(jsTreeData);
			
		model.put("jsTreeData", "["+jsTreeData.toString()+"]");
				
		logger.info("leaving /item/testcategory");
		return mav;
	}
	
	/**
	 * go to the view of item category
	 * @return the target view name 
	 */
	@RequestMapping(value="/item/samplecategory")
	public String gotoSampleCategory(){
		String viewName = "item/sample_item_category";
		return viewName;
	}
	
	@RequestMapping(value="/item/dragAndDropResultSaved",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Map<String, Object> dragAndDropResultSaved(@RequestParam String orig, @RequestParam String dest){
		logger.info("entering /item/dragAndDropResultSaved");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/testcategory";
		mav.setViewName(viewName);
		
		//service
//		this.itemCategoryService.dragAndDropResultSaved(orig, dest);
		
		//data
		Map<String, Object> model = mav.getModel();
		

		// Save data to DB
		List<ItemCategory> list = new ArrayList<ItemCategory>();
		ItemCategory p = this.itemCategoryService.findByCategoryNo(Long.parseLong(dest));
		ItemCategory old = this.itemCategoryService.findByCategoryNo(Long.parseLong(orig));
		int levelDifference = p.getLevel() - old.getLevel() + 1;
		list.add(old); //getDesendants does not include this node.
		list = this.getDesendants(list, old.getCategoryId());
		logger.info("p.level="+p.getLevel()+"  old.level="+old.getLevel()+"  levelDifference="+levelDifference);

		for (ItemCategory ic : list) {
			if (Long.toString(ic.getCategoryNo()).equals(orig)) {
				this.itemCategoryService.updateItemCategoryParent(ic.getCategoryId(),p.getCategoryId(),  p.getLevel()+1);
			}
			else {
				if (levelDifference != 0) {
					this.itemCategoryService.updateItemCategoryParent(ic.getCategoryId(), ic.getParentId(),  ic.getLevel()+levelDifference);
				}
			}
		}		
		
		model.put("orig",orig);
		model.put("dest", dest);
		
		logger.info("Orig : " + orig + "      Dest : " + dest);
		
		logger.info("leaving /item/dragAndDropResultSaved");
//		return mav;
		return model;
	}
	
	@RequestMapping(value="/item/createResultSaved",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Map<String, Object> createResultSaved(@RequestParam String parent, @RequestParam String text){
		logger.info("entering /item/createResultSaved");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/testcategory";
		mav.setViewName(viewName);
		
		//service
		ItemCategory p = this.itemCategoryService.findByCategoryNo(Long.parseLong(parent));
    	long parentId = p.getCategoryId();
    	int parentLevel = p.getLevel();
		long newCategoryNo = this.itemCategoryService.createResultSaved(parentId, text, parentLevel);
		
		//data
		Map<String, Object> model = mav.getModel();

		String newKey = Long.toString(newCategoryNo);
		model.put("parent", parent);
		model.put("newKey", newKey);
		
		logger.info("Parent : " + parent + "      Text : " + text + "      New Key : " + newKey);
		
		logger.info("leaving /item/createResultSaved");
		return model;
	}
	
	@RequestMapping(value="/item/renameResultSaved",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Map<String, Object> renameResultSaved(@RequestParam String old, @RequestParam String newText, @RequestParam String key){
		logger.info("entering /item/renameResultSaved");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/testcategory";
		mav.setViewName(viewName);
		
		//service
		this.itemCategoryService.renameResultSaved(key, newText);
		
		//test getDesendants
		List<ItemCategory> list = new ArrayList<ItemCategory>();
		ItemCategory p = this.itemCategoryService.findByCategoryNo(Long.parseLong(key));		
		list = this.getDesendants(list, p.getCategoryId());
		logger.info("list-size="+list.size());
		for (ItemCategory ic : list) {
			logger.info("category_id="+ic.getCategoryId()+" name="+ic.getName()+" category_no="+ic.getCategoryNo());
		} 
		//data
		Map<String, Object> model = mav.getModel();
		model.put("old",old);
		model.put("newText", newText);
		model.put("key", key);
		
		logger.info("Old : " + old + "      New Text : " + newText + "      Key : " + key);
		
		logger.info("leaving /item/renameResultSaved");
//		return mav;
		return model;
	}
	
	@RequestMapping(value="/item/deleteResultSaved",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Map<String, Object> deleteResultSaved(@RequestParam String node){
		logger.info("entering /item/deleteResultSaved");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/testcategory";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		// Save data to DB
		List<ItemCategory> list = new ArrayList<ItemCategory>();
//		ItemCategory p = this.itemCategoryService.findByCategoryNo(Long.parseLong(parent));
		ItemCategory old = this.itemCategoryService.findByCategoryNo(Long.parseLong(node));
//		int levelDifference = p.getLevel() - old.getLevel() + 1;
		list.add(old); //getDesendants does not include this node.
		list = this.getDesendants(list, old.getCategoryId());
//		logger.info("p.level="+p.getLevel()+"  old.level="+old.getLevel()+"  levelDifference="+levelDifference);

		for (ItemCategory ic : list) {
			if (ic.getLevel() != 0) {
				this.itemCategoryService.deleteItemCategoryByCategoryId(ic.getCategoryId());
			}
			
		}
		
//		model.put("parent", parent);
		model.put("node", node);
		
		logger.info("      Deleted Node : " + node);
		
		logger.info("leaving /item/deleteResultSaved");
		return model;
	}
/*	
	@RequestMapping(value="/item/cutAndPatseResultSaved",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Map<String, Object> CutAndPatseResultSaved(@RequestParam String parent, @RequestParam String node){
		logger.info("entering /item/cutAndPatseResultSaved");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/testcategory";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		model.put("parent", parent);
		model.put("node", node);
		
		logger.info("Parent : " + parent + "      Moved Node : " + node);
		
		logger.info("leaving /item/cutAndPatseResultSaved");
		return model;
	} */
	
	@RequestMapping(value="/item/copyAndPatseResultSaved",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Map<String, Object> copyAndPatseResultSaved(@RequestParam String parent, @RequestParam String oldNode, @RequestParam String text){
		logger.info("entering /item/copyAndPatseResultSaved");
		
		ModelAndView mav = new ModelAndView();
		
		//view
		String viewName = "item/testcategory";
		mav.setViewName(viewName);
		
		//data
		Map<String, Object> model = mav.getModel();
		
		// Save data to DB
		String newKeyString = ""; //parent + "-" + rand.nextInt((100) + 1);
		Map<Long, Long> map = new HashMap<Long, Long>();
		List<ItemCategory> list = new ArrayList<ItemCategory>();
		ItemCategory p = this.itemCategoryService.findByCategoryNo(Long.parseLong(parent));
		ItemCategory old = this.itemCategoryService.findByCategoryNo(Long.parseLong(oldNode));
		list.add(old); //getDesendants does not include this node.
		list = this.getDesendants(list, old.getCategoryId());
//		logger.info("list-size="+list.size());
		for (ItemCategory ic : list) {
//			logger.info("category_id="+ic.getCategoryId()+" name="+ic.getName()+" category_no="+ic.getCategoryNo());
			if (Long.toString(ic.getCategoryNo()).equals(oldNode)) {
				
				Long newKey = this.itemCategoryService.createResultSaved(p.getCategoryId(), text, p.getLevel());
				newKeyString = Long.toString(newKey);
				Long newId = this.itemCategoryService.findByCategoryNo(newKey).getCategoryId();
				map.put(ic.getCategoryId(), newId);
			}
			else {
//				logger.info("ic.getParentId()="+ic.getParentId());
				Long pId = map.get(ic.getParentId());
				p = this.itemCategoryService.findByCategoryId(pId);
//				logger.info("pId="+pId+"  p.getLevel()="+p.getLevel());
				Long newParentNo = this.itemCategoryService.createResultSaved(pId, ic.getName(), p.getLevel());
				Long newParentId = this.itemCategoryService.findByCategoryNo(newParentNo).getCategoryId();
				map.put(ic.getCategoryId(), newParentId);
			}
		} 
		
		model.put("parent", parent);
		model.put("oldNode", oldNode);
		model.put("newKey", newKeyString);
		
		logger.info("Parent : " + parent + "      Old Node : " + oldNode + "      Text : " + text + "      New Key : " + newKeyString);
		
		logger.info("leaving /item/copyAndPatseResultSaved");
		return model;
	}
	
	@RequestMapping(value="/item/categoryList")
	public String gotoCategoryList(){
		String viewName = "item/item_catetory_list";
		return viewName;
	}
	
	@RequestMapping(value="/item/categoryEdit")
	public String gotoCategoryEdit(){
		String viewName = "item/item_category_edit";
		return viewName;
	}
	
	private List<ItemCategory> getDesendants(List<ItemCategory> list, long categoryId) {
//		logger.info("entered getDesendants, categoryId="+categoryId+"  list-size="+list.size());
/*		for (ItemCategory ci : getChildren(categoryId)) {
			list.addAll(getDesendants(list, ci.getCategoryId()));
		} */
		List<ItemCategory> tmp = this.itemCategoryService.getChildren(categoryId);
		list.addAll(tmp);
		for (ItemCategory ci : tmp) {
			getDesendants(list, ci.getCategoryId());
		}
		return list;
	}
/*
	private List<ItemCategory> getChildren(long categoryId) {
		return this.itemCategoryService.getChildren(categoryId);
	} */
	
}
