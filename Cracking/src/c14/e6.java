package c14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class e6<T> implements Iterable<T>{

	ArrayList<T> circularArray;
	int head;
	
	T[] array;


	e6(T[] initialObjects){
		circularArray=new ArrayList<T>(initialObjects.length);
		for(T aux:initialObjects)circularArray.add(aux);
		head=0;
		
		array=(T[]) new Object[10];
	}

	public void rotate(int shiftRight){
		while(shiftRight<0)shiftRight+=circularArray.size();
		head=(head+shiftRight)%circularArray.size();
	}

	public T get (int i){
		return circularArray.get((head+i)%circularArray.size());
	}

	public void set(int i,T item){
		circularArray.set((head+i)%circularArray.size(), item);
	}
	


	public static void main(String[] args) {
		
		Integer[] array={1,2,3,4};
		e6<Integer> test=new e6<Integer>(array);
		
		int count=0;
		
		for (int i = 0; i < 4; i++) {
			test.set(i, i);
		}
		
		for(int aux:test){
			if(count==12)break;
			System.out.println(aux);
			count++;
		}
		System.out.println();
		test.rotate(-3);
		count=0;
		for(int aux:test){
			if(count==12)break;
			System.out.println(aux);
			count++;
		}
		

	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<T>{

		int count=head;
		boolean wasNextCalled=false;
		

		@Override
		public boolean hasNext() {
			if(circularArray.isEmpty())return false;
			else return true;
		}
		
		
		@Override
		public T next() {
			if(hasNext()){
				int oldCount=count;
				count=(count+1)%(circularArray.size());
				wasNextCalled=true;
				return circularArray.get(oldCount);
			}
			else{
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if(wasNextCalled) throw new IllegalStateException();
			else{
				count+=circularArray.size();
				count=(count-1)%(circularArray.size());
				circularArray.remove(count);
				count%=circularArray.size();
				wasNextCalled=false;

			}

		}

	}

}
