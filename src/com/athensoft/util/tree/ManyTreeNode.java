package com.athensoft.util.tree;

import java.util.ArrayList;
import java.util.List;

public class ManyTreeNode {
    private TreeNode self;  
    private List<ManyTreeNode> childList;  
      
    /** 
     * @param data tree node
     */  
    public ManyTreeNode(TreeNode data)  
    {  
        this.self = data;  
        this.childList = new ArrayList<ManyTreeNode>();  
    }  
      
    /** 
     * @param data tree node
     * @param childList sub-tree list
     */  
    public ManyTreeNode(TreeNode data, List<ManyTreeNode> childList)  
    {  
        this.self = data;  
        this.childList = childList;  
    }  
  
    public TreeNode getData() {  
        return self;  
    }  
  
    public void setData(TreeNode data) {  
        this.self = data;  
    }  
  
    public List<ManyTreeNode> getChildList() {  
        return childList;  
    }  
  
    public void setChildList(List<ManyTreeNode> childList) {  
        this.childList = childList;  
    }
}
