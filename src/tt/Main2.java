package tt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ballNum = sc.nextInt();
        int searchLength = sc.nextInt();
        int colorNum = sc.nextInt();
        int[] balls = new int[ballNum];
        List<Integer> ballColor = new ArrayList<Integer>();
        for(int i=0;i<ballNum;i++){
        	balls[i] = sc.nextInt();
        	for(int j=0;j<balls[i];j++){
        		ballColor.add(sc.nextInt()-1);
        	}
        	//System.out.println(ballColor.size());
        }
        //System.out.println(ballColor);
        System.out.println(getWrongNum(searchLength,ballColor,colorNum,balls));
        sc.close();
    }

	private static int getWrongNum(int searchLength, List<Integer> ballColor,int colorNum,int[] balls) {
		// TODO Auto-generated method stub
		int temp = 0;
		for(int i=0;i<colorNum;i++){
			if(getWrongColor(searchLength,ballColor,i,balls)){
				temp++;
				//System.out.println("color="+i);
			}
		}
		return temp;
	}
	private static boolean getWrongColor(int searchLength, List<Integer> ballColor,int color,int[] balls){
		int start = 0;
		int end = 0;
		boolean result = false;
		if(searchLength>=balls.length)
			return searchAll(color,ballColor);
		else
			for(int i=0;i<searchLength;i++){
				end += balls[i];
			}
		for(int i=0;i<balls.length;i++){
			result = search(start,end,color,ballColor);
			start += balls[i];
			if(i+searchLength>=balls.length){
				end += balls[(i+searchLength)%balls.length];
				end = end%ballColor.size();
			}else end += balls[i+searchLength];
			if(result) return result;
		}
		return false;
	}

	private static boolean search(int start, int end, int color, List<Integer> ballColor) {
		// TODO Auto-generated method stub
		int temp = 0;
		if(start<end){
			for(int i=start;i<end;i++)
				if(ballColor.get(i)==color)
					temp++;
		}else{
			for(int i=start;i<ballColor.size();i++)
				if(ballColor.get(i)==color)
					temp++;
			for(int i=0;i<end;i++)
				if(ballColor.get(i)==color)
					temp++;
		}
		return temp>1;
	}
	private static boolean searchAll(int color,List<Integer> ballColor){
		int temp = 0;
		for(int i=0;i<ballColor.size();i++)
			if(ballColor.get(i)==color)
				temp++;
		return temp>1;
	}
}
/*
5 2 3
3 1 2 3
0
2 2 3
1 2
1 3
*/
