package BadmintonManage;
/**
 * name : BookingCommand
 * type : Abstract
 * author : Serane
 * 功能；预定命令抽象类
 */
public abstract class BookingCommand implements BookingCommandInterface{
	private String inputBooking;//预定语句
	private int bookingType;//是预定还是取消
	private int bookingParkId;//场地id号，用于在场地列表中获取场地实例
	private long timeStamp;//预定开始时间时间戳，值为bookingDate-startHour:00
	private String bookingUserId;//预定用户
	private String bookingDate;//预定日期
	private int startHour;//预定开始时间
	private int endHour;//预定结束时间
	private String bookingPark;//预定场地名
	private int bookingDateWhichDay;//1-7分别表示星期一到星期天
	private String bookingTimeSlot;//预定时间段
	/**
	 * @return the inputBooking
	 */
	public String getInputBooking() {
		return inputBooking;
	}
	/**
	 * @param inputBooking the inputBooking to set
	 */
	public void setInputBooking(String inputBooking) {
		this.inputBooking = inputBooking;
	}
	/**
	 * @return the bookingType
	 */
	public int getBookingType() {
		return bookingType;
	}
	/**
	 * @param bookingType the bookingType to set
	 */
	public void setBookingType(int bookingType) {
		this.bookingType = bookingType;
	}
	/**
	 * @return the bookingParkId
	 */
	public int getBookingParkId() {
		return bookingParkId;
	}
	/**
	 * @param bookingParkId the bookingParkId to set
	 */
	public void setBookingParkId(int bookingParkId) {
		this.bookingParkId = bookingParkId;
	}
	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the bookingUserId
	 */
	public String getBookingUserId() {
		return bookingUserId;
	}
	/**
	 * @param bookingUserId the bookingUserId to set
	 */
	public void setBookingUserId(String bookingUserId) {
		this.bookingUserId = bookingUserId;
	}
	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the startHour
	 */
	public int getStartHour() {
		return startHour;
	}
	/**
	 * @param startHour the startHour to set
	 */
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	/**
	 * @return the endHour
	 */
	public int getEndHour() {
		return endHour;
	}
	/**
	 * @param endHour the endHour to set
	 */
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	/**
	 * @return the bookingPark
	 */
	public String getBookingPark() {
		return bookingPark;
	}
	/**
	 * @param bookingPark the bookingPark to set
	 */
	public void setBookingPark(String bookingPark) {
		this.bookingPark = bookingPark;
	}
	/**
	 * @return the bookingDateWhichDay
	 */
	public int getBookingDateWhichDay() {
		return bookingDateWhichDay;
	}
	/**
	 * @param bookingDateWhichDay the bookingDateWhichDay to set
	 */
	public void setBookingDateWhichDay(int bookingDateWhichDay) {
		this.bookingDateWhichDay = bookingDateWhichDay;
	}
	/**
	 * @return the bookingTimeSlot
	 */
	public String getBookingTimeSlot() {
		return bookingTimeSlot;
	}
	/**
	 * @param bookingTimeSlot the bookingTimeSlot to set
	 */
	public void setBookingTimeSlot(String bookingTimeSlot) {
		this.bookingTimeSlot = bookingTimeSlot;
	}
	
	
}
