package jd;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        sc.close();
        int testLength = testString.length();
        int index = 0;
        for(int i=0;i<testLength;i++){
        	//System.out.println(testString.substring(i, testLength));
        	if(isHuiWen(testString.substring(i, testLength))){
        		index = i;
        		//System.out.println(i+"|success");
        		break;
        	}
        }
        System.out.println(testLength + index);
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