package BadmintonManage;
/**
 * name : Booking
 * type : abstract
 * author : Serane
 * ���ܣ�Ԥ�������࣬����Ԥ���е�ֵ
 */
public abstract class Booking implements BookingInterface{
	private long timeStamp;//�Կ�ʼʱ��Ϊʱ���
	private boolean isBreak = false;//�Ƿ�ΥԼ�����Ƿ���ȡ��
	private boolean isCompleted = false;//�Ƿ����,��ϵͳʱ�侭����Ԥ��ʱ��
	private boolean isLocked = false;//��Ԥ�����ڽ���ʱ������Ŀ������������ȡ��
	private String bookingDate;//Ԥ������
	private int startHour;//Ԥ����ʼʱ��
	private int endHour;//Ԥ������ʱ��
	private String bookingTimeSlot;//Ԥ��ʱ���
	private String inputBooking;//Ԥ�����
	private double earn = 0;//����
	private double promotion = 0;//�ۿ�
	
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
