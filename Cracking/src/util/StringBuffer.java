package util;

import java.util.ArrayList;

public class StringBuffer {

	private ArrayList<String> buffer;
	
	StringBuffer(){
		buffer= new ArrayList<String>();
	}
	
	public StringBuffer append(String s){
		buffer.add(s);
		return this;
	}
	
	public String toString(){
		int n=0;
		for(String a:buffer) n+=a.length();
		char[] aux=new char[n];
		n=0;
		for(String a:buffer) {
			for(int i=0;i<a.length();i++){
				aux[n+i]=a.charAt(i);
			}
			n+=a.length();
		}	
		return new String(aux);
		
	}
	
	public static void main(String[] args) {
		StringBuffer m=new StringBuffer();
		System.out.print(m.append("oi").append(",tudo bem?").toString());

	}
	
}
