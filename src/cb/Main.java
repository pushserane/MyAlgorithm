package cb;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int questionNum = sc.nextInt();
		//System.out.println(questionNum);
		long[][] questions = new long[questionNum][2];
		for(int i=0;i<questionNum;i++){
			questions[i][0]=sc.nextLong();
			questions[i][1]=sc.nextLong();
		}
		sc.close();
		//for(int i=0;i<questionNum;i++){
		//	System.out.println(questions[i][0]+" : "+questions[i][1]);
		//}
		for(int i=0;i<questionNum;i++){
			System.out.println("case "+(i+1)+": "+getNum2(questions[i]));
		}
	}
	public static long getNum(long[] questionItem){
		long start = questionItem[0];
		long end = questionItem[1];
		int temp = getSingleNum(start);
		long indexNum = start;
		int tempNum = 0;
		for(long i=start;i<=end;i++){
			tempNum = getSingleNum(i);
			if(temp<tempNum){
				temp = tempNum;
				indexNum = i;
			}
		}
		return indexNum;
	}
	public static long getNum2(long[] questionItem){
		long start = questionItem[0];
		long end = questionItem[1];
		long indexNum = 1;
		int index = 1;
		long tempNum = indexNum;
		int tempI = index;
		while(indexNum<start){
			tempNum = indexNum;
			tempI = index;
			indexNum = indexNum*2 + 1;
			index ++;
		}
		while(indexNum<end){
			tempNum = indexNum;
			tempI = index;
			indexNum = indexNum*2 + 1;
			index ++;
		}
		for(long i=tempNum;i<=end;i++){
			if(index<getSingleNum(i)){
				tempNum = i;
				index = getSingleNum(i);
			}
		}
		return tempNum;
	}
	public static int getSingleNum(long qn){
		int count = 0;
		while(qn!=0){
			if(qn%2==0){
				qn = qn/2;
			}else{
				qn = qn/2;
				count++;
			}
		}
		return count;
	}
}
