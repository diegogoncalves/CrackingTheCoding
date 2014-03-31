package util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph<T> {

	HashMap<T,Node> members;
	Graph(){
		members=new HashMap<T,Node>();
	}

	void addNode(T value){

		members.put(value,new Node(value));
	}
	
	boolean isThereRoute(T begin,T end){
		Node aux=members.get(begin);
		if(aux==null)return false;
		else return aux.isThereRoute(end);
	}
	
	Collection getElements(){
		return members.values();
	}


	class Node{
		LinkedList<Node> ll;
		T key;

		Node(T value){
			key=value;
		}
		void connect(Node n){
			ll.add(n);
		}

		boolean isThereRoute(T n){
			HashSet<T> hs=new HashSet<T>();
			return isThereRoute( n, hs);
		}

		boolean isThereRoute(T n,HashSet<T> hs){
			if(key==n) return true;
			hs.add(key);
			for(Node aux:ll){
				if(!hs.contains(aux.key)){
					if(aux.isThereRoute(n,hs)) return true;
				}
			}
			return false;
		}
	}
}


