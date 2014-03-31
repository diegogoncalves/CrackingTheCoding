package others;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringSerialization implements Serializable {


	transient String  s;
	String cyphered;

	StringSerialization(String u){
		s=u;
	}

	char genChar(int c){
		if(c<10) c+='0';
		else c+='A'-10;
		return (char)c;
	}

	private int deGenChar(char c){
		if(c<'A') c-='0';
		else c-='A'-10;
		return c;
	}


	void cypher(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			sb.append(genChar(s.charAt(i)/36));
			sb.append(genChar(s.charAt(i)%36));
		}
		cyphered=sb.toString();
	}

	void decypher(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<cyphered.length();i+=2){
			sb.append((char)(36*deGenChar(cyphered.charAt(i))+deGenChar(cyphered.charAt(i+1))));
		}
		s=sb.toString();

	}




	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		//always perform the default de-serialization first
		aInputStream.defaultReadObject();
		decypher();
	}



	private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
		cypher();
		//perform the default serialization for all non-transient, non-static fields
		aOutputStream.defaultWriteObject();
	}

	public static void main(String[] args) {
		StringSerialization ss=new StringSerialization("testing aw");
		ss.cypher();
		System.out.println(ss.cyphered);
		ss.decypher();
		System.out.println(ss.s);
	}

}

