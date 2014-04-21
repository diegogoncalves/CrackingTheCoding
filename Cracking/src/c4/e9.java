package c4;

import java.util.LinkedList;



public class e9 {

	Node root;

	class Node{
		Node left;
		Node right;
		int value;
	}

	void printPath(int k){
		LinkedList<LinkedList<Integer>> ll1=allPaths(root);
		int partialSum;
		for(LinkedList<Integer> ll2:ll1){
			for(int i=0;i<ll2.size();i++){
				partialSum=0;
				for(int j=i;j<ll2.size();j++){
					partialSum+=ll2.get(j);
					if(partialSum==k){
						for(int z=i;k<=j;k++)System.out.print(ll2.get(z)+" ");
						System.out.println();
					}
				}
			}
		}
	}

	LinkedList<LinkedList<Integer>> allPaths(Node n){
		if(n==null)return new LinkedList<LinkedList<Integer>>();
		else{
			LinkedList<LinkedList<Integer>> ll= allPaths(n.left);
			ll.addAll(allPaths(n.right));
			for(LinkedList<Integer>aux:ll)aux.add(n.value);
			if(ll.isEmpty()){
				LinkedList<Integer> ll2=new LinkedList<Integer>();
				ll2.add(n.value);
				ll.add(ll2);
			}
			return ll;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
