package util;

public class Stack<T> {

	Node<T> head;
	
	T peek(){
		return head.value;
	}
	
	//doesnt make sense return type
	T push(T value){
		Node<T> aux=head;
		head=new Node<T>(value);
		head.next=aux;
		return value;
	}
	
	T pop(){
		if(head == null)return null;
		Node<T> aux=head;
		head=head.next;
		return aux.value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
