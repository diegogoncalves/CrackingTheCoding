package c2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import util.SinglyLinkedList;
import util.Node;


public class e1 {
	//time complexity  o(n)
	static <T> void removeDuplicatesBuffer(LinkedList<T> ll){
		if(ll.isEmpty()) return;
		HashMap<T,Object> m =new HashMap<T, Object>();
		ListIterator<T> it=ll.listIterator();
		T o;
		while(it.hasNext()){
			o=it.next();
			if(m.containsKey(o)){
				it.remove();
			}
			else{
				m.put(o, null);
			}

		}
	}

	//time complexity  o(n^2)
	static <T> void removeDuplicates(SinglyLinkedList<T> ll){
		Node<T> n=ll.getHeadNode();
		Node<T> auxCurrent;
		Node<T> auxLast;

		while(n!=null){
			auxCurrent=n.next;
			auxLast=n;
			while(auxCurrent!=null){
				if(auxCurrent.value==n.value){
					auxLast.next=auxCurrent.next;
				}
				auxLast=auxCurrent;
				auxCurrent=auxCurrent.next;
				
			}

			n=n.next;
		}
	}



	//time complexity  o(n^3)
	static <T> void removeDuplicates2(LinkedList<T> ll){
		T t1;
		ListIterator<T> it;
		for(int i=0;i<ll.size();i++){
			t1=ll.get(i);
			it=ll.listIterator();
			while(it.next()!=t1) {}
			for(int j=i+1;j<ll.size();j++)
			{
				while(it.hasNext()){
					if(it.next()==t1)it.remove();
				}

			}
		}
	}
	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll =new SinglyLinkedList<Integer>();
		ll.add(1);
		ll.add(7);
		ll.add(3);
		ll.add(1);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		System.out.println(ll.toString());
		
		
		removeDuplicates(ll);
		
		
		System.out.println(ll.toString());

	}

}
