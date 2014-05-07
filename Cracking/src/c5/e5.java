package c5;

public class e5 {
	int numBits(int a ,int b){
		int aux= a^b;
		int counter=0;
		int multiple=2;
		
		if(aux%2==1){
			counter++;
			aux-=1;
		}
		
		while(aux!=0){
			if(aux%multiple==0){
				counter++;
				aux-=multiple;
			}
			multiple*=2;
		}
		return counter;
	}
}
