package c2;



import util.MySinglyLinkedList;
import util.Node;

public class e2 {

	static <T>  Object findKthLastElement(MySinglyLinkedList<T> ll,int k){
		Node<T> n=ll.getHeadNode();
		Node<T> runner=n;
		if(k<0)return null;
		if(n==null) return null;
		
		//runner is going to be kth nodes after n
		for(int i=0;i<k;i++)
		{
			if(runner.next==null)return null;
			runner=runner.next;	
		}
		while(runner.next!=null){
			runner=runner.next;
			n=n.next;
		}
		return n.t;
	}
	public static void main(String[] args) {
		

	}

}
