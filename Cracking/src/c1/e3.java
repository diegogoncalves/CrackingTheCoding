package c1;

public class e3 {

	static boolean isEqual(String s1,String s2){
		int []v1=new int[128];
		if(s1.length()!=s2.length())return false;
		for(int i=0;i<s1.length();i++)v1[s1.charAt(i)]++;
		for(int i=0;i<s1.length();i++)v1[s2.charAt(i)]--;
		for(int i=0;i<128;i++){
			if(v1[i]!=0)return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		String s1="oioio";
		String s2="oioio";
		System.out.println(isEqual(s1,s2));

	}

}
