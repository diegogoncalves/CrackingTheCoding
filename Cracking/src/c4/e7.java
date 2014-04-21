package c4;

public class e7 {

	Node<?> root;

	class Node<T>{
		Node<T> left;
		Node<T> right;
		T value;
	}
	
	
	public <T> Node<?> ancestor(T p,T q){	
		return ancestor(p, q,root,0);
	}
	
	private <T> Node<?> ancestor(T p,T q,Node<?> n,Integer status){
		if(n==null)return null;
		else{
			Node<?> anc;
			Integer oldStatus;
			anc=ancestor(p, q,n.left,status);
			
			if(status==3)return anc;
			else{
				oldStatus=status;
				anc=ancestor(p, q,n.left,status);
				if(status==3){
					if(oldStatus==0)return anc;
					else return n;
				}
				if(n.value==p){
					if(n.value==q)return n;
					else{
						status(status,true);
						if(status==3)return n;
					}
				}
				if(n.value==q){
					status(status,false);
					if(status==3)return n;
				}
				return null;
			}
		}
		
	}
	
	private  void status(Integer oldStatus,boolean wasPModified){
		switch (oldStatus) {
		case 0:
			if(wasPModified)oldStatus= 2;
			else oldStatus= 1;
		default:
			oldStatus= 3;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BinaryTree<T>{

}