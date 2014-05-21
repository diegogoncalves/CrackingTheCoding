package util;




public class Arrays {

	private Arrays(){}

	/*
	 * sort using quickSort
	 */
	public static  void sort(int[] a){
		sort(a,0,a.length);
	}
	public static void sort(int[] a, int fromIndex, int toIndex) {
		int pivot= fromIndex+(toIndex-fromIndex-1)/2;

		if(toIndex>fromIndex+1){

			//pivot is going to be in fromIndex
			swap(a,pivot,fromIndex);
			pivot=fromIndex;

			//divide in two subsets 
			for(int i=fromIndex+1;i<toIndex;i++){
				if(a[i]<a[pivot]){
					if(i==pivot+1){
						swap(a,pivot++,i);
					}
					else{
						swap(a,pivot+1,i);
						swap(a,pivot+1,pivot++);
						
					}
				}
			}

			sort(a,fromIndex,pivot);
			sort(a,pivot+1,toIndex);
		}
	}

	/*
	 * sort using mergeSort
	 */
	static public   <T extends Comparable<T>> void sort(T[] a){
		sort(a, 0, a.length);
	}

	static public   <T extends Comparable<T>> void sort(T[] a,int fromIndex,int toIndex){
		int middle=fromIndex+ (toIndex-fromIndex-1)/2;
		int indexLeft=0;
		int indexRight=0;
		T leftObject=null,rightObject=null;


		if(toIndex>fromIndex+1){



			Object[] auxArray=new Object[toIndex-fromIndex];

			sort(a,fromIndex,middle+1);
			sort(a,middle+1,toIndex);

			for(int i=0;i<toIndex-fromIndex;i++){

				if(indexLeft<middle+1-fromIndex) {
					leftObject=a[fromIndex+indexLeft];
				}
				if(indexRight<toIndex-middle-1) {
					rightObject=a[middle+1+indexRight];
				}

				if(leftObject!=null && rightObject!=null){
					if(leftObject.compareTo(rightObject)<=0){
						auxArray[i]=leftObject;
						indexLeft++;
					}
					else{
						auxArray[i]=rightObject;
						indexRight++;
					}
				}
				else if(leftObject!=null){
					auxArray[i]=leftObject;
					indexLeft++;
				}
				else{
					auxArray[i]=rightObject;
					indexRight++;
				}
				leftObject=rightObject=null;
			}

			for(int i=0;i<toIndex-fromIndex;i++)a[fromIndex+i]=(T)auxArray[i];
		}
	}

	static public<T> T[] copyOfRange(T[] original,int from,int to){
		int size=to-from;
		T[] retObject=(T[])new Object[size];
		for(int i=0;i<size;i++) retObject[i]=original[from+i];
		return retObject;
	}



	private static void swap(int a[],int x,int y){
		int aux=a[x];
		a[x]=a[y];
		a[y]=aux;
	}
	
	public static int binarySearch(int[] a, int key){
		return binarySearch(a,0,a.length,key);
	}
	
	public static int binarySearch(int a[],int fromIndex, int toIndex, int key){
		int middle=fromIndex+(toIndex-fromIndex-1)/2;
		
		if(key==a[middle])return middle;
		else{
			if(key<a[middle]){
				if(middle<=fromIndex) return -middle;
				else return binarySearch(a, fromIndex, middle, key);
			}
			else {
				if(toIndex<=middle+1) return -middle-1;
				else return binarySearch(a, middle+1, toIndex, key);
			}
		}
		
	}
	public static void main(String[] args) {
		int[]x=new int[]{2,7,8,3};
		sort(x);
		System.out.println(binarySearch(x, 10));

	}
}
