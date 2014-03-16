package c1;

import java.util.Arrays;


public class e1 {

	static boolean hasUniqueCharacters(String s){
		boolean v[]=new boolean[26];
		Arrays.fill(v, false);

		s.toLowerCase();

		for(int i=0;i<s.length();i++){
			if (v[s.charAt(i)-'a']== true ){
				return false;
			}
			else v[s.charAt(i)-'a'] = true;
		}
		return true;
	}

	public static void main(String[] args) {

		String s="tes";
		System.out.print(hasUniqueCharacters(s));


	}

}
