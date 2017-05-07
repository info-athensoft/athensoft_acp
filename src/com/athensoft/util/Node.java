package com.athensoft.util;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
public class Node {
	private String text;
	private String icon;
	private List<Entry<String, String>> state;
	private List<Node> children = new ArrayList<>();
	private Node parent;
 
	public Node(){
		
	}
	
	
 public Node(Node parent) {
	 this.parent = parent;
 }
 
 public String getText() {
	 return text;
 }
 
 public void setText(String text) {
	 this.text = text;
 }
 
 public String getIcon() {
	 return icon;
 }
 
 public void setIcon(String icon) {
	 this.icon = icon;
 }
 
 public List<Entry<String, String>> getState() {
	return state;
}

public void setState(List<Entry<String, String>> state) {
	this.state = state;
}
 
 public List<Node> getChildren() {
	 return children;
 }
 
 public Node getParent() {
	 return parent;
 }
  
 public static Node addChild(Node parent, String text) {
	 Node node = new Node(parent);
	 node.setText(text);
	 parent.getChildren().add(node);
	 return node;
 }
 
 public static Node addChild(Node parent, String text, String icon) {
	 Node node = new Node(parent);
	 node.setText(text);
	 node.setIcon(icon);
	 parent.getChildren().add(node);
	 return node;
 }
 
 public static Node addChild(Node parent, String text, List<Entry<String, String>> state) {
	 Node node = new Node(parent);
	 node.setText(text);
	 node.setState(state);
	 parent.getChildren().add(node);
	 return node;
 }
 
 public static Node addChild(Node parent, String text, String icon, List<Entry<String, String>> state) {
	 Node node = new Node(parent);
	 node.setText(text);
	 node.setIcon(icon);
	 node.setState(state);
	 parent.getChildren().add(node);
	 return node;
 }
 
 public static StringBuffer buildJSTree(Node node, String appender) {
	 StringBuffer sb = new StringBuffer();
	 if (node.getText()!="root")
		 sb.append("\n" + appender + "{\"text\": \"" + node.getText() + "\"");
	 
	 if (node.getIcon() != null) {
		 sb.append(",\n" + appender + " \"icon\": \"" + node.getIcon() + "\"");
	 }
	 
	 if (node.getState() != null) {
		 String str = "";
		 for (Entry<String, String> entry : node.getState()) {
			 if (str == "") {
				 str += " \"state\": { \"" + entry.getKey() + "\" : \"" + entry.getValue() + "\"";
			 }
			 else {
				 str += ", \"" + entry.getKey() + "\" : \"" + entry.getValue() + "\"";
			 }
		 }
		 str += " }";
		 sb.append(",\n" + appender + str);
	 }
	 
	 if (!node.getChildren().isEmpty()) {
		 if (node.getText()!="root")
			 sb.append(", \n"+appender + " \"children\": " );
		 sb.append("[");
	 }
		 
	 for (Node each : node.getChildren()) {
		 sb.append(buildJSTree(each, appender + appender));
		 sb.append("}," );
	 }
	 if (!node.getChildren().isEmpty()) {
		 sb.setLength(sb.length() - 1);
		 sb.append("\n" + appender + "]");
	 }
		 
	 return sb;
 }
 
 public static List<Entry<String, String>> buildList(Entry<String, String> entry) {
	 List<Entry<String, String>> list = new ArrayList<Entry<String, String>>();
	 list.add(new AbstractMap.SimpleEntry<String, String>(entry.getKey(), entry.getValue()));
	 return list;
 }
 
 public static List<Entry<String, String>> buildList(Entry<String, String> entry1, Entry<String, String> entry2) {
	 List<Entry<String, String>> list = new ArrayList<Entry<String, String>>();
	 list.add(new AbstractMap.SimpleEntry<String, String>(entry1.getKey(), entry1.getValue()));
	 list.add(new AbstractMap.SimpleEntry<String, String>(entry2.getKey(), entry2.getValue()));
	 return list;
 }
  
  public static void main(String[] args) {
	  Node treeRootNode = new Node(null);
	  treeRootNode.setText("root");
//	  treeRootNode.setState(Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-root")));
	  // add child to root node 
	  Node parentNode = Node.addChild(treeRootNode, "My Parent Node", Node.buildList(new AbstractMap.SimpleEntry<String, String>("key", "key-1")));
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
		  
	  System.out.println(Node.buildJSTree(treeRootNode, "  "));
 
 }
 
}
