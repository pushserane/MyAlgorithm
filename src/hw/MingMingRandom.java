package hw;
import java.util.Scanner;

public class MingMingRandom {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int number = sc.nextInt();
    	int[] numbers = new int[number];
    	for(int i=0;i<number;i++)numbers[i] = sc.nextInt();
    	sc.close();
    	//ȥ��
    	
    	//����
    	
    	//����һ��ʹ�ü���������Ϊ��Ŀ��ȷָ������Ϊ��������1��=N��=1000
    	int[] motherQueue = new int[1000];
    	for(int i=0;i<1000;i++)
    		motherQueue[i] = 0;
    	for(int i=0;i<number;i++)motherQueue[numbers[i]-1]++;
    	for(int i=0;i<1000;i++)
    		if(motherQueue[i]!=0)System.out.println(i+1);
    }
}
