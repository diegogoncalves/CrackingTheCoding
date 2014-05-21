package c09;

public class e3 {
	int magical(int a[]){
		return magical (a,0,a.length-1);
	}

	private int magical(int a[],int start,int end){
		if(start>end)return -1;
		else{
			int middle=(end+start)/2;
			if(a[middle]==middle+1)return middle+1;
			else if(a[middle]<middle+1) return magical(a,middle+1,end);
			else return magical(a,start,middle-1);
		}
	}

	int magicalEqualelements(int a[]){
		return magicalEqualelements (a,0,a.length-1);
	}

	private int magicalEqualelements(int a[],int start,int end){
		int aux;
		if(start>end)return -1;
		else{
			int middle=(end+start)/2;

			if(a[middle]==middle+1)return middle+1;

			else if(a[middle]<middle+1) {
				aux=magicalEqualelements(a,middle+1,end);
				if( aux!=-1)return aux;
				else return magicalEqualelements(a,start,a[middle]);
			}
			else {
				aux=magicalEqualelements(a,start,middle-1);
				if( aux!=-1)return aux;
				else return magicalEqualelements(a,a[middle],end);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println((Integer.MAX_VALUE+2)/2);
	}
}
