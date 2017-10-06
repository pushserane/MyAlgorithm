package xm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	static IPTable ipTable; 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String testStr = null;
		ipTable = new IPTable();
		while(sc.hasNext()){
			testStr = sc.nextLine();
			if(testStr.equals("end"))break;
			takeOverIp(testStr);
		}
		sc.close();
	}
	public static void takeOverIp(String testStr){
		String[] testStrItem = testStr.split(":");
		String ip = testStrItem[1];
		switch(testStrItem[0].charAt(0)){
		case 'i': 
			if(ipTable.addIp(ip)){
				System.out.println("ok");
			}
			break;
		case 'd': 
			if(ipTable.deleteIp(ip)){
				System.out.println("ok");
			}
			break;
		
		case 's':
			if(ipTable.searchIp(ip)){
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			break;
		}
	}
}
class IPTable{
	List<IPItem> ipList;
	IPTable(){
		ipList = new ArrayList<IPItem>();
	}
	public boolean addIp(String ip){
		int position = getPositionBinarySearch(ip,ipList);
		ipList.add(position,new IPItem(ip));
		return true;
	}
	public boolean searchIp(String ip){
		int position = getPositionBinarySearch(ip,ipList);
		if(position<0||position>=ipList.size())return false;
		if(ipList.get(position).ip.equals(ip))return true;
		else return false;
	}
	public boolean deleteIp(String ip){
		if(searchIp(ip)){
			ipList.remove(getPositionBinarySearch(ip,ipList));
		}
		return true;
	}
	int getPositionBinarySearch(String ipStr, List<IPItem> ipList){
		long ipId = getId(ipStr);
		int start = 0;
		int end = ipList.size() - 1;
		int mid = 0;
		while(start <= end){
			mid = start + (end - start)/2;
			if(ipList.get(mid).id == ipId)return mid;
			else if(ipList.get(mid).id < ipId){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return start;
	}
	long getId(String ipStr){
		String[] ipItem = ipStr.split("\\.");
		int[] strInt = new int[4];
		for(int i=0;i<4;i++){
			strInt[i] = Integer.parseInt(ipItem[i]);
		}
		return strInt[0]*100*100*100+strInt[1]*100*100+strInt[2]*100+strInt[3];
	}
}
class IPItem{
	long id;
	String ip;
	IPItem(String ip){
		this.ip = ip;
		this.id = getId(ip);
	}
	long getId(String ip){
		String[] ipItem = ip.split("\\.");
		int[] strInt = new int[4];
		for(int i=0;i<4;i++){
			strInt[i] = Integer.parseInt(ipItem[i]);
		}
		return strInt[0]*100*100*100+strInt[1]*100*100+strInt[2]*100+strInt[3];
	}
}
