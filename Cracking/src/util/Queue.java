package util;

public class Queue<T> {

	Node<T> head;
	Node<T> tail;


	void add(T value){
		//queue is empty
		if(head==null){
			head=new Node<T>(value);
			tail=head;
			return;
		}
		tail.next=new Node<T>(value);		
	}


	T remove(){
		//queue is empty
		if(head==null) return null;

		T aux=head.value;

		//just one element
		if(head==tail) head=tail=null;
		else head=head.next;

		return aux;



	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
