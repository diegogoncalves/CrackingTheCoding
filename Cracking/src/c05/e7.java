package c05;

import java.util.HashSet;

public class e7 {
	int fetchJAi(int j,int i){
		return 1;
	}

	int missingInteger(int n){
		HashSet<Integer> hs=new HashSet<Integer>();
		int aux;
		
		
		//assuming the size of the array is n
		for(int i=0;i<n;i++)
		{
			aux=0;
			for(int j=0;j<32;j++) aux+=(fetchJAi(j, i)<<j);
			hs.add(aux);
		}
		
		for(int i=0;i<=n;i++){
			if(!hs.contains(i)) return i;
		}
		
		return 0;
	}
}
