package c03;

public class e1 {
	Object array[];
	int head1,head2,head3;
	boolean is1Empty,is2Empty,is33Empty;

	e1(int n){
		array=new Object[n];
		head1=0;head2=1;head3=2;
	}




	boolean push1(Object o){
		head1+=3;
		if(head1>=array.length){
			head1-=3;
			return false;
		}
		else{
			if(head1==4)is1Empty=false;
			array[head1]=o;
			return true;
		}
	}
	
	Object pop1(){
		if(is1Empty)return null;
		else{
			head1-=3;
			if(head1==1)is1Empty=true;
			return array[head1];
		}

	}

}