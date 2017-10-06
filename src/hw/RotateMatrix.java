package hw;
import java.util.Scanner;

public class RotateMatrix {
	public static void main(String[] args){
		int n;//输入的方阵大小
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		printMatix(n);
	}
	public static void printMatix(int n){
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				matrix[i][j]=0;
		int direction = 0;//使用direction来控制方向：0：左；1：下；2：右；3:上
		matrix[0][0] = 1;
		int time = 1;
		giveValue(matrix,0,0,direction,time);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	public static void giveValue(int[][] matrix,int x,int y,int direction,int time){
		int tempValue = matrix[x][y];
		//System.out.println(tempValue);
		int max = matrix.length;
		if(time == max*max)return;
		switch(direction){
			case 0:
				if(y+1>=max||matrix[x][y+1]!=0){
					direction = (direction+1)%4;
					giveValue(matrix,x,y,direction,time);
				}else{
					matrix[x][y+1] = tempValue+1;
					giveValue(matrix,x,y+1,direction,time+1);
				}
				break;
			case 1:
				if(x+1>=max||matrix[x+1][y]!=0){
					direction = (direction+1)%4;
					giveValue(matrix,x,y,direction,time);
				}else{
					matrix[x+1][y] = tempValue+1;
					giveValue(matrix,x+1,y,direction,time+1);
				}
				break;
			case 2:
				if(y-1<0||matrix[x][y-1]!=0){
					direction = (direction+1)%4;
					giveValue(matrix,x,y,direction,time);
				}else{
					matrix[x][y-1] = tempValue+1;
					giveValue(matrix,x,y-1,direction,time+1);
				}
				break;
			case 3:
				if(x-1<0||matrix[x-1][y]!=0){
					direction = (direction+1)%4;
					giveValue(matrix,x,y,direction,time);
				}else{
					matrix[x-1][y] = tempValue+1;
					giveValue(matrix,x-1,y,direction,time+1);
				}
				break;
		}
	}
}
