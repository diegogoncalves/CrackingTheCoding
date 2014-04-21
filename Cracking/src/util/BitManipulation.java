package util;

public class BitManipulation {

	static boolean getBit(int num,int i){
		return (num & (1<<i))!=0;
	}
	
	static int setBit(int num,int i){
		return num|(1<<i);
	}
	
	static int clearBit(int num,int i){
		return num&(~(1<<i));
	}
	
	static int clearBitsMSBthrough(int num,int i){
		int mask=~((~0)<<i);
		System.out.println(Integer.toBinaryString(mask));
		return num&mask;
	}
	
	static int clearBitsIthrough0(int num,int i){
		int mask=(~0)<<(i+1);
		return num&mask;
	}
	
	static int updateBit(int num, int i, boolean v) {
		return v?setBit(num, i):clearBit(num, i);
	}


}
