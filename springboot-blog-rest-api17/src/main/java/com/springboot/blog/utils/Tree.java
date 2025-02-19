package com.springboot.blog.utils;

public class Tree {
	
	private TreeNode root;
	
	public void insert(int value) {
		if(root==null) {
			root = new TreeNode(value);
		}else {
			root.insert(value);
		}
	}
	
	public void traversInNode() {
		if(root !=null) {
			root.traverseInOrder();
		}
	}
	
	public TreeNode get(int Value) {
		if(root!=null) {
			return root.get(Value);
		}
		
		return null;
		
	}

}
