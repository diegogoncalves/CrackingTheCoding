package c1;

import java.util.HashMap;
import java.util.LinkedList;

//3:30  3:50 4:02
public class Parser2 {
	HashMap<Integer,LinkedList<Character>> hm = new HashMap<Integer,LinkedList<Character>>();
	
	public Parser2() {
		LinkedList<Character> ll=new LinkedList<Character>();
		char aux='a';
		
		ll.add(' ');
		hm.put(1, ll);
		
		for(int i=2;i<10;i++){
			ll=new LinkedList<Character>();
			
			ll.add(aux++);
			ll.add(aux++);
			ll.add(aux++);
			if(i==7||i==9) ll.add(aux++);
			
			hm.put(i,ll);
		}
	}
	
	LinkedList<String> parser(String number){
		LinkedList<String> retList=new LinkedList<String>();
		retList.add("");
		LinkedList<String> auxList;
		int digit;
		LinkedList<Character> characters;
		
		for(int i=0;i<number.length();i++){
			digit=number.charAt(i)-'0';
			characters=hm.get(digit);
			auxList=new LinkedList<String>();
			for(char a:characters){
				for(String s:retList){
					auxList.add(s+a);
				}
			}
			retList=auxList;
		}
		return retList;
	}
	
	
	public static void main(String[] args) {
		Parser2 p=new Parser2();
		System.out.print(p.parser("23").toString());
	}
}
