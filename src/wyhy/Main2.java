package wyhy;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		if(row<=0){
			System.out.println("input error");
			return;
		}
		int line = sc.nextInt();
		if(line<=0){
			System.out.println("input error");
			return;
		}
		int[][] tables = new int[row][line];
		int indexRow = 0;
		int indexLine = 0;
		while(sc.hasNext()){
			tables[indexRow][indexLine++]=sc.nextInt();
			System.out.println("line="+line+"|lineIndex="+indexLine);
			if(indexLine==line){
				indexRow++;
				indexLine=0;
			}
			if(indexRow==row)break;
		}
		if(indexRow!=row||indexLine!=0){
			System.out.println("input error");
			return;
		}
		int k = 0;
		if(sc.hasNext()){
			k = sc.nextInt();
			if(k<=0){
				System.out.println("input error");
				return;
			}
		}else{
			System.out.println("input error");
			return;
		}
		if(search(k,tables)){
			System.out.println("1");
			return;
		}
		System.out.println("0");
	}
	public static boolean search(int k ,int[][] tables){
		for(int i=0;i<tables.length;i++){
			for(int j=0;j<tables[0].length;j++){
				if(k==tables[i][j])return true;
			}
		}
		
		return false;
	}
}
