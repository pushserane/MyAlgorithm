package xm;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String test = null;
		while(sc.hasNext()){
			test = sc.nextLine();
			//System.out.println("1="+test);
			//System.out.println(test.split("\\.").length);
			if(isLegal(test))System.out.println(1);
			else System.out.println(0);
		}
		sc.close();
	}
	public static boolean isLegal(String str){
		char[] testStr = str.toCharArray();
		for(int i=0;i<testStr.length;i++){
			if(!Character.isDigit(testStr[i])&&testStr[i]!='.')
				return false;
		}
		//System.out.println("2="+str);
		String[] strItem = str.split("\\.");
		//System.out.println("length="+strItem);
		if(strItem.length!=4)return false;
		int[] strInt = new int[4];
		for(int i=0;i<4;i++){
			if(strItem[i].charAt(0)=='0'&&strItem[i].length()>1)
				return false;
		}
		try{
			for(int i=0;i<4;i++){
				strInt[i] = Integer.parseInt(strItem[i]);
			}
		}catch(NumberFormatException e){
			//System.out.println("NumberFormatException");
			return false;
		}
		for(int i=0;i<4;i++){
			if(strInt[i]>255||strInt[i]<0)return false;
		}
		if(strInt[0]==0){
			for(int i=1;i<4;i++)
				if(strInt[i]!=0)return false;
		}
		return true;
	}
}
