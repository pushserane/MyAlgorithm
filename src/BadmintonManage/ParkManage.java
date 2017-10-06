package BadmintonManage;

import java.util.List;

/**
 * name : ParkManage
 * type : Abstract
 * author : Serane
 * 功能；球场管理系统抽象类，管理球场管理实例。
 * 接受命令输入，将其传输给场地管理实例
 */
public abstract class ParkManage implements ParkManageInterface{
	private BookingCommand bookingCommand;//预定命令
	private List<Park> parkList;//场地实例
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
