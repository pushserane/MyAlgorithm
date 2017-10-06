package BadmintonManage;

import java.util.ArrayList;
import java.util.List;
/**
 * name : Park
 * type : Abstract
 * author : Serane
 * ���ܣ����峡�س�����
 * 
 */
public abstract class Park implements ParkInterface{
	private List<ParkItem> itemList;//����ʵ���б�
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
	 * ��ӳ���ʵ��
	 */
	public abstract void addParkItem();
	/**
	 * ��ӡ�����������
	 */
	public void incomeCount(){
		double sumCount = 0;
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "�������");
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "---");
		for(int i=0;i<getItemList().size();i++){
			sumCount += getItemList().get(i).getIncomeCount();
			if(i!=getItemList().size()-1)System.out.println(BadmintonManageHint.PLACE_HOLDER + "");
		}
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "---");
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "�ܼ�: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
	}
	public List<String> incomeCountString(){
		double sumCount = 0;
		List<String> strList = new ArrayList<String>();
		strList.add(BadmintonManageHint.PLACE_HOLDER + "�������");
		strList.add(BadmintonManageHint.PLACE_HOLDER + "---");
		for(int i=0;i<getItemList().size();i++){
			List<String> tempList = getItemList().get(i).getIncomeCountString();
			sumCount += Double.valueOf(tempList.remove(0));
			strList.addAll(tempList);
			if(i!=getItemList().size()-1)strList.add(BadmintonManageHint.PLACE_HOLDER + "");
		}
		strList.add(BadmintonManageHint.PLACE_HOLDER + "---");
		strList.add(BadmintonManageHint.PLACE_HOLDER + "�ܼ�: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
		return strList;
	}
}
