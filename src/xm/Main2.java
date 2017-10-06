package xm;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String testStr = sc.nextLine();
		if(testStr.charAt(0)=='0'){
			if(testStr.equals("0000"))
				System.out.println("0.0.0.0");
			return;
		}
		getAllIp(testStr);
		/*int[] test = new int[]{1,2,3,4};
		printIp(testStr,test);
		*/
	}

	public static boolean getAllIp(String testStr) {
		// TODO Auto-generated method stub
		int[] length = new int[3];
		for(int one=1;one<4;one++){
			if(one>=testStr.length())continue;
			if(isLegal(testStr.substring(0,one))){
				length[0] = one;
				
				for(int two=1;two<4;two++){
					if(one+two>=testStr.length())continue;
					if(isLegal(testStr.substring(one,one+two))){
						length[1]=one+two;
						for(int three=1;three<4;three++){
							if(one+two+three>=testStr.length())continue;
							if(isLegal(testStr.substring(one+two,one+two+three))){
								length[2]=one+two+three;
								if(isLegal(testStr.substring(one+two+three,testStr.length()))){
									printIp(testStr,length);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
	public static void printIp(String testStr,int[] length){
		int index = 0;
		for(int i=0;i<testStr.length();i++){
			if(index!=3)
			if(i==length[index]){
				System.out.print(".");
				index++;
			}
			System.out.print(testStr.charAt(i));
		}
		System.out.println("");
	}
	public static boolean isLegal(String ipNum){
		if(ipNum.charAt(0)=='0'&&ipNum.length()!=1)return false;
		if(ipNum.length()>3)return false;
		int num = 0;
		try{
			num = Integer.parseInt(ipNum);
		}catch(NumberFormatException e){
			return false;
		}
		if(num<0||num>255)return false;
		return true;
	}
}
