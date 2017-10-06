package cb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int treeNum = sc.nextInt();
		int[] father = new int[treeNum-1];
		int[] values = new int[treeNum];
		//System.out.println("hello");
		for(int i=0;i<treeNum-1;i++)
			father[i]=sc.nextInt();
		for(int i=0;i<treeNum;i++)
			values[i]=sc.nextInt();
		sc.close();
		//System.out.println("hello");
		long count = 0;
		for(int i=1;i<treeNum;i++){
			//System.out.println("id="+i);
			count += getNum(i,father,values);
		}
		System.out.println(count);
	}
	public static int getNum(int id,int[] father,int[] values){
		List<Integer> idList = new ArrayList<Integer>();
		idList.clear();
		idList.add(id);
		int _id = id;
		while(true){
		_id = getChild(_id,father);
		if(_id!=-1){
			idList.add(_id);
			}else break;
		}
		int max = getMax(values,idList);
		return (max>values[id])?max-values[id]:values[id]-max;
	}
	public static int getChild(int id,int[] father){
		for(int i=0;i<father.length;i++){
			if(father[i]==id)
				return i+1;
		}
		return -1;
	}
	public static int getMax(int[] values,List<Integer> idList){
		int max = 0;
		for(int i=0;i<values.length;i++){
			if(idList.contains(i));
			else{
				if(max<values[i])
					max = values[i];
			}
		}
		//System.out.println("max="+max);
		return max;
	}
}