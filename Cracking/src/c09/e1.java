package c09;

public class e1 {
	static long ways(int n){
		if(n==1)return 1;
		else if(n==2)return 2;
		else if(n==3) return 4;
		else if(n==4)return 7;
		else return 2*ways(n-3)+2*ways(n-2)+ways(n-4);
	}
	
	public static void main(String[] args) {
		System.out.println(ways(37));
	}
	
}

//10