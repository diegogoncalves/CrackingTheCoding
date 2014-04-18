package c4;

import java.util.TreeSet;

import util.BinarySearchTreeSet;

public class e1 {

	//this problem was implemented inside the class BinarySearchTreeSet
	boolean isBalanced(BinarySearchTreeSet<?> bt){
		return bt.isBalanced();
	}

	public static void main(String[] args) {
		TreeSet<Integer> ts= new TreeSet<Integer>();
		for(int i=10;i>0;i--)ts.add(i);
		System.out.println(ts.toString());
		

	}

}
