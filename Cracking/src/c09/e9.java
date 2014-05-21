package c09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashSet;


public class e9 {


  	
  
  	static void placeQueens(){
  		LinkedList<Integer> aux=new LinkedList<Integer>();
  		for(int i=0;i<8;i++)aux.add(i);
  		LinkedList<HashSet<Position>>ll=getSets(aux);
  		check(ll);
  	}
  
  	private static LinkedList<HashSet<Position>> getSets(LinkedList<Integer> ll) {
  		LinkedList<HashSet<Position>> retList=new LinkedList<HashSet<Position>>();
  		LinkedList<HashSet<Position>> auxList;
  
  		if(ll.size()==1){
  			HashSet<Position> hs=new HashSet<Position>();
  			hs.add(new Position(new Integer[]{0,ll.getFirst()}));
  			retList.add(hs);
  		}
  		else{
  			for(int i=0;i<ll.size();i++){
  				int auxInt=ll.removeFirst();
  				auxList=getSets(ll);
  				ll.addLast(auxInt);
  				for(HashSet<Position> hs:auxList){
  					hs.add(new Position(new Integer[]{ll.size()-1,auxInt}));
  					retList.add(hs);
  				}
  			}
  		}
  		return retList;
  	}
  
  	private static void check(LinkedList<HashSet<Position>> ll) {
  		for(HashSet<Position> hs: ll){
  			boolean ok=true;
  			for(Position x:hs){
  				for(Position w=new Position(new Integer[]{x.b[0]+1,x.b[1]+1});valid(w.b) && ok;) {
  					if(hs.contains(w)){
  						ok=false;
  					}
  					w.b[0]++;w.b[1]++;
  				}
  				for(Position w=new Position(new Integer[]{x.b[0]-1,x.b[1]-1});valid(w.b) && ok;) {
  					if(hs.contains(w))ok=false;
  					w.b[0]--;w.b[1]--;
  				}
  				for(Position w=new Position(new Integer[]{x.b[0]-1,x.b[1]+1});valid(w.b) && ok;){
  					if(hs.contains(w))ok=false;
  					w.b[0]--;w.b[1]++;
  				}
  				for(Position w=new Position(new Integer[]{x.b[0]+1,x.b[1]-1});valid(w.b) && ok;) {
  					if(hs.contains(w))ok=false;
  					w.b[0]++;w.b[1]--;
  				}
  			}
  			if(ok) print(hs);
  		}
  	}

  	private static void print(HashSet<Position> hs) {
		  		System.out.println("A valid configuration:");
		  		for(Position a:hs){
		  			System.out.println(a.b[0]+","+a.b[1]);
		  		}
  	}

	private static boolean valid(Integer[] w) {
		if(w[0]<0 || w[0]>7 || w[1]<0 || w[1]>7) return false;
		else {
			return true;

		}
	}

	public static void main(String[] args) {
				placeQueens();
	}

}

class Position{
	public Integer b[];
	Position(Integer []a){
		b=a;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Position))
            return false;
        
        Position c=(Position)obj;
		return Arrays.equals(b,c.b);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return b[0]*10+b[1];
	}
}
