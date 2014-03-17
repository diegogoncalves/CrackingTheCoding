package c2;

import java.util.LinkedList;
import java.util.Stack;



public class e7 {

	static <T> boolean isPalindrome(LinkedList<T> ll1){
		
		if(ll1.size()==0) return true;
		Stack<T> s=new Stack<T>();
		for(T el:ll1)s.push(el);
		for(T el:ll1){
			if(el!=s.pop())return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}

}
