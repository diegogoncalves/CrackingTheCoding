package c2;

import java.util.Iterator;
import java.util.LinkedList;

import junit.framework.Assert;

public class e5 {

	static LinkedList<Integer> addLinkedList(LinkedList<Integer> ll1,LinkedList<Integer> ll2){
		LinkedList<Integer> ll3=new LinkedList<Integer>();
		boolean carry = false;
		int value1=0,value2=0;
		int totalSum;
		Iterator<Integer> it1 = ll1.iterator();
		Iterator<Integer> it2= ll2.iterator();

		//verify if both linked lists are empty
		if(!(it1.hasNext() || it2.hasNext())) return ll3;


		do{

			totalSum=0;

			if(it1.hasNext()) value1=it1.next();
			else value1=0;

			if(it2.hasNext()) value2=it2.next();
			else value2=0;

			totalSum=value1+value2;
			if(carry)totalSum++;

			carry=false;

			ll3.add((totalSum)%10);
			if((totalSum)>9)carry=true;

		}while(it1.hasNext() || it2.hasNext() );
		if(carry) ll3.add(1);

		return ll3;	
	}

	static LinkedList<Integer> addLinkedList2(LinkedList<Integer> ll1,LinkedList<Integer> ll2){
		int value1=0;
		int value2=0;
		int count1=0,count2=0,aux;
		Iterator<Integer> it1 = ll1.iterator();
		Iterator<Integer> it2= ll2.iterator();
		LinkedList<Integer> ll3=new LinkedList<Integer>();
		
		//check if both are empty
		if(!(it1.hasNext()||it2.hasNext()))return null;
		
		while(it1.hasNext()){
			value1=value1*10+it1.next();
			count1++;
		}
		while(it2.hasNext()){
			value2=value2*10+it2.next();
			count2++;
		}
		//result of the sum
		value1+=value2;
		
		//size of the biggest LinkedList
		if(count2>count1)count1=count2;
		
		if((int)(value1/(Math.pow(10, count1)))==1){
			ll3.add(1);
			value1-=Math.pow(10, count1);
		}
		
		
		for(int i=0;i<count1;i++)
		{
			aux=(int) (value1/ (Math.pow(10, count1-i-1) ));
			ll3.add(aux);
			value1-=(int)aux* Math.pow(10,count1-1-i) ;
		}
		
		System.out.print(ll3.toString());
		return ll3;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll1=new LinkedList<Integer>();
		LinkedList<Integer> ll2=new LinkedList<Integer>();

		Assert.assertEquals("[1, 3, 0, 8]",addLinkedList2(ll1, ll2).toString());

		System.out.println("succed");
	}

}
