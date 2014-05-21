package c04;

import util.TreeNode;

public class e5 {
	//ta errado!!!!!!!!
	<T extends Comparable<T>> boolean isBalanced(TreeNode<T> n){
		boolean aux1=true,aux2=true;
		if(n==null)return true;
		if(isBalanced(n.left)&&isBalanced(n.right)){
			if(n.left!=null)aux1=n.left.value.compareTo(n.value)<0;
			if(n.right!=null)aux2=n.right.value.compareTo(n.value)>0;
			if(aux1&&aux2)return true;
			else return false;
		}
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
