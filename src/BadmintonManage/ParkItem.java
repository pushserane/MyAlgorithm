package BadmintonManage;

import java.util.ArrayList;
import java.util.List;
/**
 * name : ParkItem
 * type : Abstract
 * author : Serane
 * 功能；场地抽象类，管理场地实例。
 */
public abstract class ParkItem implements ParkItemInterface{
	private String parkName;
	/**
	 * @return the parkName
	 */
	public String getParkName() {
		return parkName;
	}
	/**
	 * @param parkName the parkName to set
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	private List<Booking> bookingList;
	/**
	 * @return the bookingList
	 */
	public List<Booking> getBookingList() {
		return bookingList;
	}
	/**
	 * @param bookingList the bookingList to set
	 */
	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	/**
	 * @param booking
	 * 添加预定booking
	 */
	public void addBooking(Booking booking){
		getBookingList().add(booking);
	}
	/**
	 * @param position
	 * @param booking
	 * 在特定位置position添加预定booking
	 */
	public void addBooking(int position,Booking booking){
		getBookingList().add(position, booking);
	}
	/**
	 * @return
	 * 小场地收入汇总
	 */
	public double getIncomeCount() {
		double sumCount = 0;
		System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.PLACE_STRING + ":" + this.parkName);
		for(Booking bookItem:getBookingList()){
			System.out.println(BadmintonManageHint.PLACE_HOLDER + bookItem);
			sumCount += bookItem.getEarn();
		}
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "小计: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
		return sumCount;
	}
	public List<String> getIncomeCountString(){
		double sumCount = 0;
		List<String> strList = new ArrayList<String>();
		strList.add(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.PLACE_STRING + ":" + this.parkName);
		for(Booking bookItem:getBookingList()){
			strList.add(BadmintonManageHint.PLACE_HOLDER + bookItem);
			sumCount += bookItem.getEarn();
		}
		strList.add(BadmintonManageHint.PLACE_HOLDER + "小计: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
		strList.add(0, "" + sumCount);
		return strList;
	}
	/**
	 * 获取当前预定应插入的位置
	 */
	public abstract int getPosition(BookingCommand bookingCommand);
	/**
	 * 时间管理
	 */
	public void timeConsume(){
		for(Booking bookItem:getBookingList()){
			if(!bookItem.isCompleted()){
				//if(bookItem.getBookingDate().equals(anObject))
				if(bookItem.getTimeStamp()<BadmintonManageHint.SYSTEM_TIMESTAMP){
					if(!bookItem.isLocked())
						bookItem.setLocked(true);
					if(bookItem.getEndHour()<=BadmintonManageHint.time)
						bookItem.setCompleted(true);
				}else if(bookItem.getTimeStamp()==BadmintonManageHint.SYSTEM_TIMESTAMP){
					bookItem.setLocked(true);
				}else{
					break;
				}
			}
		}
	}
}
