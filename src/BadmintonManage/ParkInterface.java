package BadmintonManage;
/**
 * name : ParkManageSystemInterface
 * type : Interface
 * author : Serane
 * ���ܣ����ؽӿڣ����峡��Ӧ�еķ���
 */
public interface ParkInterface {
	/**
	 * @param bookingCommand
	 * ʹ��bookingCommand����Ԥ����ȡ��Ԥ��
	 */
	public void booking(BookingCommand bookingCommand);
	/**
	 * ��ȡ�������
	 */
	public void incomeCount();
}
