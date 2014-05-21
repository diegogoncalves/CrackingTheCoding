package c09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class e5 {

	LinkedList<String> permutation(String s){
		String auxString;

		LinkedList<Character> ll=new LinkedList<Character>();
		for(int i=0;i<s.length();i++)ll.add(s.charAt(i));
		LinkedList<String>ll2=permutation(ll);
		//clean repeated strings
		HashSet<String> hs=new HashSet<String>();
		Iterator<String> it=ll2.iterator();
		while(it.hasNext()){
			auxString=it.next();
			if(!hs.add(auxString)) it.remove();
		}
		return ll2;


	}

	private LinkedList<String> permutation(LinkedList<Character> ll) {
		LinkedList<String> retList=new LinkedList<String>();
		LinkedList<String> auxList=new LinkedList<String>();

		if(ll.size()==1) retList.add(ll.getFirst().toString());
		else{
			for(int i=0;i<ll.size();i++){
				char aux=ll.removeFirst();
				auxList=permutation(ll);
				for(String s2:auxList) retList.add(s2+aux);
				ll.addLast(aux);
			}
		}
		return retList;
	}


}
