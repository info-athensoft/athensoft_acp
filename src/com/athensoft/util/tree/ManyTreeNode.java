package com.athensoft.util.tree;

import java.util.ArrayList;
import java.util.List;

public class ManyTreeNode {
    private TreeNode data;  
    private List<ManyTreeNode> childList;  
      
    /** 
     * @param data tree node
     */  
    public ManyTreeNode(TreeNode data)  
    {  
        this.data = data;  
        this.childList = new ArrayList<ManyTreeNode>();  
    }  
      
    /** 
     * @param data tree node
     * @param childList sub-tree list
     */  
    public ManyTreeNode(TreeNode data, List<ManyTreeNode> childList)  
    {  
        this.data = data;  
        this.childList = childList;  
    }  
  
    public TreeNode getData() {  
        return data;  
    }  
  
    public void setData(TreeNode data) {  
        this.data = data;  
    }  
  
    public List<ManyTreeNode> getChildList() {  
        return childList;  
    }  
  
    public void setChildList(List<ManyTreeNode> childList) {  
        this.childList = childList;  
    }
}
