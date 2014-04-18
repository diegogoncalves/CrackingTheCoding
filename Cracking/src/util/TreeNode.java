package util;



public class TreeNode<T> {
	public T value;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T value) {this.value=value;}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value.toString();
	}
}