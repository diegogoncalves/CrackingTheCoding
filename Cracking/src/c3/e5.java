package c3;

import java.util.EmptyStackException;
import java.util.Stack;

class e5<T>{
	Stack<T>push;
	Stack<T>pop;
	boolean wasPop;

	public e5(){
		push=new Stack<T>();
		pop=new Stack<T>();
	}

	void add(T el){
		if(wasPop){
			transfer(pop,push);
			wasPop=false;
		}
		push.push(el);
	}

	T remove(){
		if(!wasPop){
			transfer(push,pop);
			wasPop=true;
		}
		try{
			return pop.pop();
		}
		catch(EmptyStackException e){
			return null;
		}
	}

	void transfer(Stack<T> origin,Stack<T> destination){
		while(!origin.empty()){
			destination.push(origin.pop());
		}
	}

	public static void main(String[] args) {
		e5<Integer> test=new e5<>();
		System.out.println(test.remove());
		test.add(2);
		test.add(4);
		System.out.println(test.remove());
		System.out.println(test.remove());
		test.add(3);
		test.add(5);
		System.out.println(test.remove());
		test.add(7);
		System.out.println(test.remove());

	}
}
