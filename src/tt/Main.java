package tt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxK = 0;
        int userNum = sc.nextInt();
        int[] users = new int[userNum];
        for(int i=0;i<userNum;i++){
        	users[i] = sc.nextInt();
        	if(maxK < users[i])maxK=users[i];
        }
        int searchNum = sc.nextInt();
        int[][] searchs = new int[searchNum][3];
        for(int i=0,j=0;i<searchNum;i++){
        	for(j=0;j<3;j++)
        		searchs[i][j] = sc.nextInt();
        }
        sc.close();
        int[][] kNum = new int[userNum][maxK];
        for(int i=0,j=0;i<userNum;i++)
        	for(j=0;j<maxK;j++)
        		kNum[i][j] = 0;
        initKNum(users,kNum);
        for(int i=0;i<searchNum;i++){
        	System.out.println(takeOverSearch(searchs[i],kNum));
        } 
    }
	private static int takeOverSearch(int[] search, int[][] kNum) {
		// TODO Auto-generated method stub
		int start = search[0];
		int end = search[1];
		int k = search[2];
		if(start==1){
			return kNum[end-1][k-1];
		}else{
			return kNum[end-1][k-1]-kNum[start-2][k-1];
		}
	}
	static void initKNum(int[] users,int[][] kNum){
    	for(int i=0;i<users.length;i++){
    		kNum[i][users[i]-1]++;
    		for(int j=i+1;j<users.length;j++)
    			kNum[j][users[i]-1]++;
    	}
    }
}
    /*
    5
    1 2 3 3 5
    3
    1 2 1
    2 4 5
    3 5 3
    */
