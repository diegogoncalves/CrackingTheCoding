package util;

import java.util.HashSet;



public class BinarySearchTreeSet<T extends Comparable<T>> {

	Node root;

	void add(T value){
		Node current,next=root;
		if(root==null){
			root=new Node(value);
			return;
		}
		if(root.value==value)return;
		do{	
			current=next;
			//if it is already inserted in the tree
			if(value==current.value) return;
			if(value.compareTo(current.value)>0) next=current.right;
			else next=current.left;
		}while(next!=null);
		if(value.compareTo(current.value)>0) current.right=new Node(value);
		else current.left=new Node(value);

	}




	/** remove the element if it is present otherwise return false*/
	boolean remove(T value){
		Node current=root;Node next;Node reference;Node aux;

		if(root.value!=value){
			do{
				if(value.compareTo(current.value)<0) next=current.left;
				else next=current.right;
				if(next==null)return false;
			}while(next.value!=value);
			//save reference to the father of the node to be removed
			reference=current;
			
			
			if(next.left==null){
				if(value.compareTo(reference.value)<0)	reference.left=next.right;
				else reference.right=next.right;
				return true;
			}
			if(next.right==null){
				if(value.compareTo(reference.value)<0)	reference.left=next.left;
				else reference.right=next.left;
				return true;
			}
			//neither children are null
			current=next;
			do{
				if(value.compareTo(current.value)<0) next=current.left;
				else next=current.right;
			}while(next!=null);
			
			if(value.compareTo(current.value)<0)	aux=current.left;
			else aux=current.right;
			
			
		}
	}

	//returns true if the root have this key or the tree is empty
	Node findElementFather(T value){
		Node current=root;
		if(root.value==value ||root==null) return null;
		else{
			while(current.left.value==)
		}

	}



	/** return the element which is father of the one which is being searched*/
	private Node searchBefore (T value){
		Node retNode[]=new Node[2];
	}

	boolean contains(T value){

	}

	public boolean isBalanced(){
		if(root==null) return false;
		int v1=count(root.left);
		int v2=count(root.right);
		//check if you can (v1||v2==1)
		//the subtrees are not balanced
		if(v1==-1 || v2==-1) return false;

		if(Math.abs(count(root.left)-count(root.right))>1)return false;
		else return true;
	}

	private int count(Node n){
		if(n==null) return 0;
		else {
			int v1=count(root.left);
			int v2=count(root.right);
			//the subtrees are not balanced
			if(v1==-1 || v2==-1) return -1;

			if(Math.abs(count(root.left)-count(root.right))>1)return -1;
			else return Math.max(v1,v2)+1;

		}
	}




	public static void main(String[] args) {
		HashSet<Integer> hs =new HashSet<Integer>();

	}




}

