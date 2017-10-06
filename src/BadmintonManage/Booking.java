package BadmintonManage;
/**
 * name : Booking
 * type : abstract
 * author : Serane
 * 功能；预定抽象类，管理预定中的值
 */
public abstract class Booking implements BookingInterface{
	private long timeStamp;//以开始时间为时间戳
	private boolean isBreak = false;//是否违约，即是否已取消
	private boolean isCompleted = false;//是否完成,即系统时间经过了预定时间
	private boolean isLocked = false;//当预定正在进行时，对条目加锁，不允许取消
	private String bookingDate;//预定日期
	private int startHour;//预定开始时间
	private int endHour;//预定结束时间
	private String bookingTimeSlot;//预定时间段
	private String inputBooking;//预定语句
	private double earn = 0;//收入
	private double promotion = 0;//折扣
	
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
	 * @return the isBreak
	 */
	public boolean isBreak() {
		return isBreak;
	}
	/**
	 * @param isBreak the isBreak to set
	 */
	public void setBreak(boolean isBreak) {
		this.isBreak = isBreak;
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
	 * @return the earn
	 */
	public double getEarn() {
		return earn;
	}
	/**
	 * @param earn the earn to set
	 */
	public void setEarn(double earn) {
		this.earn = earn;
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
	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}
	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}
	/**
	 * @param isLocked the isLocked to set
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	/**
	 * @return the promotion
	 */
	public double getPromotion() {
		return promotion;
	}
	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(double promotion) {
		this.promotion = promotion;
	}
}
