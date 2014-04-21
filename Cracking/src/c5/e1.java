package c5;

public class e1 {

	public static int insert(int n,int m,int i,int j){
		//clear bits from i to j
		int mask1=~((1<<(j+1))-1)|((1<<i)-1);
		int mask2=m<<i;
		
		return (n&mask1)|mask2;
	}


}

