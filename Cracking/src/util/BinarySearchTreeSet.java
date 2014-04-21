package util;

import java.util.LinkedList;



public class BinarySearchTreeSet<T extends Comparable<T>> {

	TreeNode<T> root;

	boolean contains(T el){
		SearchResult sr=new SearchResult();
		search(el,root,sr);
		return sr.wasFound;
	}

	void add(T el){
		SearchResult r=new SearchResult();
		TreeNode<T> newFather;

		search(el,root,r);
		if(!r.wasFound){
			if(isEmpty())root=new TreeNode<T>(el);
			else{
				if(r.father==null)newFather=root;
				else{
					if(r.isLeft) newFather=r.father.left;
					else newFather=r.father.right;
				}	
				if(el.compareTo(newFather.value)<0) newFather.left  =new TreeNode<T>(el);
				else newFather.right  =new TreeNode<T>(el);
			}
		}
	}


	boolean remove(T el){
		SearchResult r =new SearchResult();
		search(el,root,r);

		//tree is empty
		if(!r.wasFound){
			return false;
		}
		else{
			removeForSubstitution(r,el);
			return true;
		}

	}


	private void removeForSubstitution(SearchResult r,T el){
		TreeNode<T> oldNode;
		boolean updateTree=false;

		if(r.father==null){
			oldNode=root;
			updateTree=true;
		}
		else oldNode= r.isLeft?r.father.left:r.father.right;


		SearchResult r2=new SearchResult();
		search(el,oldNode.left,r2);

		//subtree was empty
		if(oldNode.left==null){
			if(updateTree)root=oldNode.right;
			else {
				if(r.isLeft) r.father.left=oldNode.right;
				else r.father.right=oldNode.right;
			}
		}

		else{


			if(r2.father==null){
				if(updateTree)	root=oldNode.left;
				else	r.father.left=oldNode.left;
				
				oldNode.left.right=oldNode.right;
			}
			else{
				T newValue=r2.isLeft?r2.father.left.value:r2.father.right.value;

				if(updateTree)root.value= newValue;
				else {
					if(r.isLeft)r.father.left.value = newValue;
					else r.father.right.value = newValue; 
				}
				removeForSubstitution(r2,el);
			}
		}
	}

	//	cases of remove:
	//	-tree is empty
	//	-element is not in the tree
	//	-root is going to be removed
	//	
	//	
	//	-element is a leaf
	//	-element is not a leaf


	//please verify if the tree is empty before start
	//returns father of the element
	//if the element is the root it is going to return wasFound=true & father=null
	//if the element was not found the father is going to be the father of the last element traversed in the tree
	private void search(T el,TreeNode<T> n,SearchResult r)
	{
		if(n!=null){
			if(el==n.value) r.wasFound=true;
			else{
				if(el.compareTo(n.value)<0){

					if(n.left!=null){
						r.isLeft=true;
						r.father=n;
						search(el,n.left,r);
					}
				}
				else{
					if(n.right!=null){
						r.isLeft=false;
						r.father=n;
						search(el,n.right,r);
					}
				}
			}
		}

	}

	//limit
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

	private int count(TreeNode<T> n){
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

	public void breadthFirstSearch(){
		LinkedList<TreeNode<T>> oldList=new LinkedList<TreeNode<T>>();
		LinkedList<TreeNode<T>> newList=new LinkedList<TreeNode<T>>();

		if(root!=null){
			visit(root.value);
			if(root.left!=null) newList.add(root.left);
			if(root.right!=null) newList.add(root.right);

			//System.out.println(newList.toString());

			System.out.println();

			while(!newList.isEmpty()){

				oldList=newList;
				newList=new LinkedList<TreeNode<T>>();
				

				for(TreeNode<T> aux:oldList){
					visit(aux.value);
					if(aux.left!=null) newList.add(aux.left);
					if(aux.right!=null) newList.add(aux.right);

				}

				System.out.println();

			}
		}

	}
	
	public void preOrder(){
		preOrder(root);
	}
	
	private void preOrder(TreeNode<T> n){
		if(n!=null){
			visit(n.value);
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	private void postOrder(TreeNode<T> n){
		if(n!=null){
			postOrder(n.left);
			postOrder(n.right);
			visit(n.value);
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(TreeNode<T> n){
		if(n!=null){
			inOrder(n.left);
			visit(n.value);
			inOrder(n.right);
		}
	}
	private void visit(T n){
		System.out.print(n.toString()+" ");
	}

	public boolean isEmpty(){
		if(root==null)return true;
		else return false;
	}

	public static void main(String[] args) {
		BinarySearchTreeSet<Integer> bt= new BinarySearchTreeSet<Integer>();
		bt.add(4);
		bt.add(2);
		bt.add(10);
		bt.add(1);
		bt.add(9);
		bt.add(11);
		bt.add(3);

		bt.remove(4);
		//System.out.println(bt.contains(2));
		bt.breadthFirstSearch();
		bt.preOrder();
	}



	class SearchResult{
		boolean isLeft,wasFound;
		TreeNode<T> father;
	}

}

