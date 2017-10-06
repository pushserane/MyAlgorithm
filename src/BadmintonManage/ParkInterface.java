package BadmintonManage;
/**
 * name : ParkManageSystemInterface
 * type : Interface
 * author : Serane
 * 功能；场地接口，定义场地应有的方法
 */
public interface ParkInterface {
	/**
	 * @param bookingCommand
	 * 使用bookingCommand命令预定或取消预定
	 */
	public void booking(BookingCommand bookingCommand);
	/**
	 * 获取收入汇总
	 */
	public void incomeCount();
}
