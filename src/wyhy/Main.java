package wyhy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int strNum = Integer.parseInt(sc.nextLine());
		String[] strings = new String[strNum];
		int index = 0;
		while(sc.hasNext()){
			strings[index++]=sc.nextLine();
		}
		if(index!=strNum)strings[index]="";
		int Count = 0;
		for(int i=0;i<strNum;i++){
			for(int j=0;j<strNum;j++){
				if(i!=j){
					if(isHuiWen(strings[i].trim()+strings[j]))
						Count++;
				}
			}
		}
		System.out.println(Count);
	}
	public static boolean isHuiWen(String str){
    	StringBuffer sb = new StringBuffer(str);  
    	sb.reverse();// ½«StrÖÐµÄ×Ö·û´®µ¹ÖÃ  
    	int count = 0;
    	for (int i = 0; i < str.length(); i++) {  
    		if (str.charAt(i) == sb.charAt(i)) {  
    	            count++;  
    	        }  
    	    }  
    	    if (count == str.length()) {  
    	        return true;
    	    } else {  
    	        return false;
    	    }  
    }
}
