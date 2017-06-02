package com.athensoft.util.tree;

public class TreeNode2 {
	private String nodeId;
	private String parentId;
	
	
	private String text;
	
	public TreeNode2(String nodeId){
		this.nodeId = nodeId;
	}
	
	public TreeNode2(String nodeId, String parentId){
		this.nodeId = nodeId;
		this.parentId = parentId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
