package c01;



public class e7 {

	
	static void change(int [][]v){
		v[0][0]=100;
	}
	
	static void setMatrix(int v[][]){
		
		int n=v[0].length; //number of columns
		int m= v.length; //number of lines
		
		int [][] aux= new int [m][n];
		//copying the values of the array v to the array aux
		for(int i=0;i<m;i++)	System.arraycopy(v[i], 0, aux[i], 0,n);
		
		boolean[] isRowSet = new boolean[m];
		boolean[] isColumnSet = new boolean[n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
			{
				if(v[i][j]==0){
					
					if(!isRowSet[i]){
						for(int k=0;k<n;k++) aux[i][k]=0;
						isRowSet[i]=true;
					}
					if(!isColumnSet[j]){
						for(int k=0;k<m;k++) aux[k][j]=0;
						isColumnSet[j]=true;
					}
				}
			}
		}
		
		for(int i=0;i<m;i++)	System.arraycopy(aux[i], 0, v[i], 0,n);

		
	}
	
	public static void main(String[] args) {

		int[][] matrix={{1,0},{3,0},{4,5}};
		setMatrix(matrix);
		for(int[] m :matrix)
		{
			for(int x:m)
			{
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}

}
