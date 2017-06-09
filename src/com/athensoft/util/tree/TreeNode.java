package com.athensoft.util.tree;

public class TreeNode {
	private String nodeId;
	private String parentId;
	private String text;
	
	private Object content;
	
	public TreeNode(String nodeId){
		this.nodeId = nodeId;
	}
	
	public TreeNode(String nodeId, String parentId){
		this.nodeId = nodeId;
		this.parentId = parentId;
	}
	
//	public TreeNode(int nodeId, int parentId, String text){
//		
//	}
	
	public TreeNode(String nodeId, String parentId, Object content){
		this.nodeId = nodeId;
		this.parentId = parentId;
		this.content = content;
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

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TreeNode [nodeId=" + nodeId + ", parentId=" + parentId + ", text=" + text + ", content=" + content
				+ "]";
	}
	
	
	
	
}
