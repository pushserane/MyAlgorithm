package BadmintonManage;

/**
 * name : ParkItemInterface
 * type : Interface
 * author : Serane
 * ���ܣ�����ӿڣ����峡��Ӧ�еķ���
 */
public interface ParkItemInterface {
	/**
	 * @param bookingCommand
	 * ȡ��Ԥ��
	 */
	public void cancelling(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * Ԥ��
	 */
	public void booking(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * @return
	 * �ж�Ԥ���Ƿ����
	 */
	public boolean isBookExist(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * @return
	 * �ж�Ԥ���Ƿ�������Ԥ����ͻ
	 */
	public boolean isBookConflict(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * @return
	 * ��ȡ��ǰԤ��������Ԥ���а���ʼʱ������Ӧ�е�λ��
	 */
	public int getPosition(BookingCommand bookingCommand);
	/**
	 * ʱ�����
	 */
	public void timeConsume();
}
