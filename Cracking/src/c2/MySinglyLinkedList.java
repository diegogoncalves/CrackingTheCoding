package c2;

public class MySinglyLinkedList<T> {

	Node head;

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

	void print(){
		Node aux=head;
		while(aux!=null){
			System.out.println(aux.t);
			aux=aux.next;
		}

	}

	class Node{
		Node next;
		T t;
		Node(T t1){
			t=t1;
		}
	}	





	public static void main(String[] args) {
		MySinglyLinkedList<Integer> a = new MySinglyLinkedList<Integer>(2);
		a.add(1);
		a.add(3);
		System.out.println("print");a.print();
		a.remove(2);
		System.out.println("print");a.print();
		a.remove(1);
		System.out.println("print");a.print();
		a.remove(3);
		System.out.println("print");a.print();
		a.add(4);
		System.out.println("print");a.print();

		
	}

}
