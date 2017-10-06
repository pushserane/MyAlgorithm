package jd;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testNum = sc.nextLong();
        sc.close();
        long test = 2000000001;
        System.out.println(test*(test+1)/2);
        if(testNum>0)System.out.println(getNum3(testNum,1,2000000001));
        else if(testNum==0){
        	System.out.println(0);
        }else{
        	System.out.println("");
        }
    	return;
        //System.out.println(testNum);
        
    }
    public static long getNum2(long testNum,long start,long end){
    	long startNum = (start-1)*(start)/2;
    	long endNum = end*(end+1)/2;
    	long middle = start + ((end-start)/2);
    	long middleStart = (middle-1)*(middle)/2;
    	long middleEnd = (middle+1)*middle/2;
    	if(testNum>middleStart&&testNum<=middleEnd)return middle;
    	else if(testNum>middleEnd)
    		return getNum2(testNum,middle+1,end);
    	else return getNum2(testNum,start,middle-1);
    }
    public static long getNum3(long testNum,long start,long end){
    	long middle = start + ((end-start)/2);
    	long middleStart = (middle-1)*(middle)/2;
    	long middleEnd = (middle+1)*middle/2;
    	while(start<=end){
    		middle = start + ((end-start)/2);
        	middleStart = (middle-1)*(middle)/2;
        	middleEnd = (middle+1)*middle/2;
        	if(testNum>middleStart&&testNum<=middleEnd)return middle;
        	else if(testNum>middleEnd){
        		start = middle+1;
        	}
        	else end = middle-1;
        	System.out.println(testNum+"|start="+start+"|end="+end+"|middle="+middle);
    	}
		return middle;
    }
    
    public static int getNum(long testNum){
    	int start = 0;
    	int end = 1;
    	if(testNum>start&&testNum<=end)return 1;
    	for(int i=2;;i++){
    		start = end;
    		end += i;
    		if(testNum>start&&testNum<=end)
    			return i;
    	}
    }
}