package BadmintonManage;

import java.util.ArrayList;
import java.util.List;
/**
 * name : ParkItem
 * type : Abstract
 * author : Serane
 * ���ܣ����س����࣬������ʵ����
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
	 * ���Ԥ��booking
	 */
	public void addBooking(Booking booking){
		getBookingList().add(booking);
	}
	/**
	 * @param position
	 * @param booking
	 * ���ض�λ��position���Ԥ��booking
	 */
	public void addBooking(int position,Booking booking){
		getBookingList().add(position, booking);
	}
	/**
	 * @return
	 * С�����������
	 */
	public double getIncomeCount() {
		double sumCount = 0;
		System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.PLACE_STRING + ":" + this.parkName);
		for(Booking bookItem:getBookingList()){
			System.out.println(BadmintonManageHint.PLACE_HOLDER + bookItem);
			sumCount += bookItem.getEarn();
		}
		System.out.println(BadmintonManageHint.PLACE_HOLDER + "С��: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
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
		strList.add(BadmintonManageHint.PLACE_HOLDER + "С��: " + BadmintonManageHint.getOutputNum(sumCount) + BadmintonManageHint.UNIT);
		strList.add(0, "" + sumCount);
		return strList;
	}
	/**
	 * ��ȡ��ǰԤ��Ӧ�����λ��
	 */
	public abstract int getPosition(BookingCommand bookingCommand);
	/**
	 * ʱ�����
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
