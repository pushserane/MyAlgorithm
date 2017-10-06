package hw;
import java.util.Scanner;

public class CountTheNumberOfChar {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine().toLowerCase();
    	char cr = sc.nextLine().toLowerCase().charAt(0);
    	sc.close();
    	int count = 0;
    	//System.out.println(str);
    	//System.out.println(cr);
    	for(char i:str.toCharArray()){
    		if(cr == i)count++;
    	}
    	System.out.println(count);
    }
}
