package c2;

import util.Node;

public class e3 {

	static <T> void removeNode(Node<T> n){
		if(n==null)return;
		if(n.next!=null){
			n.value=n.next.value;
			n.next=n.next.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
