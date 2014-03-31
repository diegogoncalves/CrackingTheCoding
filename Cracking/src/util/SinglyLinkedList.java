package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.Assert;

public class SinglyLinkedList<T> implements Iterable<T> {

	Node<T> head;
	int size;

	public SinglyLinkedList () {
		size=0;
	}

	public SinglyLinkedList (T t1) {
		head=new Node<T>(t1);
		size=1;
	}

	/** add element to the list*/
	public void add(T t1){
		Node<T> aux=head;
		if(aux==null) head=new Node<T>(t1);
		else{
			while(aux.next!=null){
				aux=aux.next;
			}
			aux.next=new Node<T>(t1);
		}
		size++;
	}



	/** remove an element of the list and return the head*/
	void remove(T t1){
		Node<T> aux=head;
		//list is empty
		if(head==null) return;
		else{
			//element is in the head
			if(head.value==t1){
				head=head.next;
				size--;
			}
			else{
				while(aux.next!=null){
					if(aux.next.value==t1){
						aux.next=aux.next.next;
						size--;
						break;
					}
					aux=aux.next;
				}
			}
		}
	}

	public String toString(){
		Node<T> aux=head;
		StringBuilder s=new StringBuilder();
		s.append("[");
		while(aux!=null){
			s.append(" "+aux.value);
			aux=aux.next;
		}
		s.append("]");
		return s.toString();
	}
	
	public int size(){return size;}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	public Node<T> getHeadNode(){
		return head;
	}

	

	class MyIterator implements Iterator<T>{

		Node<T> preLast;
		Node<T> last;
		Node<T> current;
		
		boolean nextCalled;
		int index;

		MyIterator(){
			current=head;
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
				return last.value;
			}
			else throw new NoSuchElementException();

		}

		@Override
		public void remove() {
			if(nextCalled){
				//changing the head
				if(preLast==null){
					head=current;
					last=null;
				}
				else{
					if(current!=null){
						last.value=current.value;
						last.next=current.next;
						current=last;	
					}
					else{
						last=preLast;
					}
				}
				size--;
				nextCalled=false;
			}
			else throw new IllegalStateException();
		}

	}




	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
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
		System.out.print("vr");





	}



}
