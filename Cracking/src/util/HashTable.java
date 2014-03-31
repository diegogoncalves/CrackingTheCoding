package util;


import java.util.ArrayList;


public class HashTable<K,V> {

	class Pair{
		K k;
		V v;
		Pair(K k1,V v1){
			k=k1;v=v1;
		}
	}

	private int capacity;
	private ArrayList <ArrayList<Pair>> hashTable; 

	HashTable(){
		hashTable=new ArrayList<ArrayList<Pair>>(50);
		for(int i=0;i<50;i++) hashTable.add ( new ArrayList<Pair>());
		capacity=50;
	}

	HashTable(int cap){
		capacity=cap;
		hashTable=new ArrayList<ArrayList<Pair>>(capacity);
		for(int i=0;i<capacity;i++) hashTable.add ( new ArrayList<Pair>());

	}

	boolean put(K key,V value){

		Pair p=new Pair(key,value);
		int hash=key.hashCode()%capacity;;
		ArrayList<Pair> aux=hashTable.get(hash%50);

		//check if the element is already in the hashTable
		for(Pair element:aux){
			if(element.k==p.k) {
				return false;
			}
		}

		aux.add(p);
		return true;
	}




	V get(K key){

		int hash=key.hashCode()%capacity;
		ArrayList<Pair> aux=hashTable.get(hash);
		if(aux==null) return null;

		for(Pair element:aux){
			if(element.k==key) {
				return element.v;
			}
		}
		return null;
	}

	

}



