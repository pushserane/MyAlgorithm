package BadmintonManage;

import java.util.ArrayList;
import java.util.List;
/**
 * name : Park
 * type : Abstract
 * author : Serane
 * 功能；具体场地抽象类
 * 
 */
public abstract class Park implements ParkInterface{
	private List<ParkItem> itemList;//场地实例列表
	/**
	 * @return
	 */
	public List<ParkItem> getItemList(){
		return this.itemList;
	}
	/**
	 * @param itemList
	 */
	public void setItemList(List<ParkItem> itemList){
		this.itemList = itemList;
	}
	/**
	 * @param parkItem
	 * 添加场地实例
	 */
	public abstract void addParkItem();
	/**
	 * 打印场地收入汇总
	 */
	public void incomeCount(){
		double sumCount = 0;
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "收入汇总");
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "---");
		for(int i=0;i<getItemList().size();i++){
			sumCount += getItemList().get(i).getIncomeCount();
			if(i!=getItemList().size()-1)System.out.println(BadmintonManageHint.PLACE_HOLDER + "");
		}
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "---");
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "总计: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
	}
	public List<String> incomeCountString(){
		double sumCount = 0;
		List<String> strList = new ArrayList<String>();
		strList.add(BadmintonManageHint.PLACE_HOLDER + "收入汇总");
		strList.add(BadmintonManageHint.PLACE_HOLDER + "---");
		for(int i=0;i<getItemList().size();i++){
			List<String> tempList = getItemList().get(i).getIncomeCountString();
			sumCount += Double.valueOf(tempList.remove(0));
			strList.addAll(tempList);
			if(i!=getItemList().size()-1)strList.add(BadmintonManageHint.PLACE_HOLDER + "");
		}
		strList.add(BadmintonManageHint.PLACE_HOLDER + "---");
		strList.add(BadmintonManageHint.PLACE_HOLDER + "总计: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
		return strList;
	}
}
