package BadmintonManage;
/**
 * name : BookingCommand
 * type : Abstract
 * author : Serane
 * ���ܣ�Ԥ�����������
 */
public abstract class BookingCommand implements BookingCommandInterface{
	private String inputBooking;//Ԥ�����
	private int bookingType;//��Ԥ������ȡ��
	private int bookingParkId;//����id�ţ������ڳ����б��л�ȡ����ʵ��
	private long timeStamp;//Ԥ����ʼʱ��ʱ�����ֵΪbookingDate-startHour:00
	private String bookingUserId;//Ԥ���û�
	private String bookingDate;//Ԥ������
	private int startHour;//Ԥ����ʼʱ��
	private int endHour;//Ԥ������ʱ��
	private String bookingPark;//Ԥ��������
	private int bookingDateWhichDay;//1-7�ֱ��ʾ����һ��������
	private String bookingTimeSlot;//Ԥ��ʱ���
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
