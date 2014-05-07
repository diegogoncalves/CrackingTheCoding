//package c1;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//
//public class Parser {
//	
//	HashMap<Integer,LinkedList<Character>> hm;
//	
//	Parser(){
//		LinkedList<String> aux= new LinkedList<String>();
//		aux.add(' ');
//		hm.put(1, aux);
//		aux.clear();
//		char count='a';
//		for(int i=2;i<10;i++){
//			
//			if(i!=7&&i!=9){
//				aux.add(count);
//				hm.put(1, aux);
//				aux.clear();
//			}
//		}
//		
//		hm.put(2, aux);
//	}
//	
//	LinkedList<String> parser(LinkedList<Integer> ll){
//		LinkedList<String> retList=new LinkedList<String>();
//		if(ll.size()==1){
//			String s=Integer.toString(ll.get(0));
//			LinkedList<Character> llc=hm.get(hm.get(0));
//			retList.add(llc);
//			return retList;
//		}
//		for(int i=0;i<ll.size();i++){
//			int aux=ll.get(i);
//			LinkedList<Integer> aux2=(LinkedList<Integer>) ll.clone();
//			aux2.remove(i);
//			LinkedList<String> ll2=parser(aux2);
//			for(String s:ll2){
//				retList.add(aux+s);
//			}
//		}
//		return retList;
//	}
//
//}
