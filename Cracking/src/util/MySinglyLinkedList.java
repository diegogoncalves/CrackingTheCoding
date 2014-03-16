package util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import junit.framework.Assert;

public class MySinglyLinkedList<T> implements Iterable<T> {

	Node head;


	public MySinglyLinkedList () {}

	public MySinglyLinkedList (T t1) {
		head=new Node(t1);
	}

	/** add element to the list*/
	void add(T t1){
		Node aux=head;
		if(aux==null) head=new Node(t1);
		else{
			while(aux.next!=null){
				aux=aux.next;
			}
			aux.next=new Node(t1);
		}
	}



	/** remove an element of the list and return the head*/
	void remove(T t1){
		Node aux=head;
		if(head==null) return;
		else{
			if(head.t==t1){
				head=head.next;
			}
			else{
				while(aux.next!=null){
					if(aux.next.t==t1){
						aux.next=aux.next.next;
						break;
					}
					aux=aux.next;
				}
			}
		}
	}

	public String toString(){
		Node aux=head;
		StringBuilder s=new StringBuilder();
		s.append("[");
		while(aux!=null){
			s.append(" "+aux.t);
			aux=aux.next;
		}
		s.append("]");
		return s.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	class Node{
		Node next;
		T t;
		Node(T t1){
			t=t1;
		}
	}	

	class MyIterator implements Iterator<T>{

		Node preLast;
		Node last;
		Node current;
		
		boolean nextCalled;
		int index;

		MyIterator(){
			current=head;
			last=head;
		}

		@Override
		public boolean hasNext() {
			if(current!=null) return true;
			else return false;
		}

		@Override
		public T next() {
			if(hasNext()){
				last=current;
				current=current.next;
				nextCalled=true;
				return last.t;
			}
			else throw new NoSuchElementException();

		}

		@Override
		public void remove() {
			if(nextCalled){
				if(current!=null){
					last.t=current.t;
					last.next=current.next;
					current=last;
				}
				else{
					
				}
				nextCalled=false;
			}
			else throw new IllegalStateException();
		}

	}




	public static void main(String[] args) {
		MySinglyLinkedList<Integer> ll = new MySinglyLinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		Iterator<Integer> it = ll.iterator();
		it.next();
		it.remove();
		Assert.assertEquals("[ 2 3 4]",ll.toString() );
		it.next();
		it.remove();
		Assert.assertEquals("[ 3 4]",ll.toString() );
		it.next();
		it.remove();
		Assert.assertEquals("[ 4]",ll.toString() );
		it.next();
		it.remove();
		Assert.assertEquals("[]",ll.toString() );





	}



}
