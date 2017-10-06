package BadmintonManage;

import java.util.List;

/**
 * name : ParkManage
 * type : Abstract
 * author : Serane
 * ���ܣ��򳡹���ϵͳ�����࣬�����򳡹���ʵ����
 * �����������룬���䴫������ع���ʵ��
 */
public abstract class ParkManage implements ParkManageInterface{
	private BookingCommand bookingCommand;//Ԥ������
	private List<Park> parkList;//����ʵ��
	/**
	 * @return the bookingCommand
	 */
	public BookingCommand getBookingCommand() {
		return bookingCommand;
	}
	/**
	 * @param bookingCommand the bookingCommand to set
	 */
	public void setBookingCommand(BookingCommand bookingCommand) {
		this.bookingCommand = bookingCommand;
	}
	/**
	 * @return the badmintonPark
	 */
	public List<Park> getParkList() {
		return parkList;
	}
	/**
	 * @param badmintonPark the badmintonPark to set
	 */
	public void setParkList(List<Park> parkList) {
		this.parkList = parkList;
	}
	/**
	 * @param park
	 */
	public abstract void addPark();
}
