package c01;

public class e5 {

	static String stringCompression(String s){
		StringBuilder aux1=new StringBuilder();
		char aux2;
		int count=1;
		if(s.length()==0 ||s.length()==1) return s;
		
		aux2=s.charAt(0);
	
	
		for(int i = 1;i<s.length() ;i++){
			if(s.charAt(i)==aux2 ) count++;
			else{
				aux1.append(aux2);
				aux1.append(count);
				aux2=s.charAt(i);
				count=1;
			}
			if(i==s.length()-1){
				aux1.append(aux2);
				aux1.append(count);
				aux2=s.charAt(i);
			}
		}
		String s2=aux1.toString();
		if(s.length()<=s2.length())return s;
		else return s2;
		
		}
		
	
	public static void main(String[] args) {
		String s="aab";
		System.out.print(stringCompression(s));

	}

}
