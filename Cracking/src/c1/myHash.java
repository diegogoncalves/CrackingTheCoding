package c1;

import java.util.ArrayList;



public class myHash<K,V> {
	
	class Pair{
		K k;
		V v;
		Pair(K k1,V v1){
			k=k1;v=v1;
		}
	}
	
	ArrayList <ArrayList<Pair>> hashTable; 
	
	myHash(){
		hashTable=new ArrayList<ArrayList<Pair>>(50);
	}
	
	/**return the hashcode of the key */
	int hashCode(K k){
		return K;
	}
	
	void put(K key,V value){
		Pair p=new Pair(key,value);
		boolean isIncluded=false;
		int hash=hashCode(key);
		ArrayList<Pair> aux=hashTable.get(hash);
		//create list
		if(aux==null){
			aux=new ArrayList<Pair>();
		}
		//check if the element is already in the hashTable
		else
		{
			for(Pair elements:aux){
				if(elements==p) {
					isIncluded=true;
					break;
				}
			}
		}
		
		if(isIncluded==false) aux.add(p);
		}
		
	
	
	V get(K key){
		
		int hash=hashCode(key);
		ArrayList<Pair> aux=hashTable.get(hash);
		for(Pair elements:aux){
			if(elements.k==key) {
				return elements.v;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
