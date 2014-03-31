package c4;

import java.util.Arrays;


import util.TreeNode;

public class e3 {

	TreeNode<Integer> createTree(int[] ar){
		if(ar.length==0) return null;
		if(ar.length==1)return new TreeNode<Integer>(ar[0]);
		TreeNode<Integer> root=new TreeNode<Integer>(ar[ar.length/2]);
		root.left=createTree(Arrays.copyOfRange(ar, 0, ar.length/2-1));
		root.right=createTree(Arrays.copyOfRange(ar, ar.length/2-1, ar.length-1));
		return root;

	}


}
