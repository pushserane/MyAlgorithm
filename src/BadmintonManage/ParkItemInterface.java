package BadmintonManage;

/**
 * name : ParkItemInterface
 * type : Interface
 * author : Serane
 * 功能；球场项接口，定义场地应有的方法
 */
public interface ParkItemInterface {
	/**
	 * @param bookingCommand
	 * 取消预定
	 */
	public void cancelling(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * 预定
	 */
	public void booking(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * @return
	 * 判断预定是否存在
	 */
	public boolean isBookExist(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * @return
	 * 判断预定是否与已有预定冲突
	 */
	public boolean isBookConflict(BookingCommand bookingCommand);
	/**
	 * @param bookingCommand
	 * @return
	 * 获取当前预定在已有预定中按开始时间排序应有的位置
	 */
	public int getPosition(BookingCommand bookingCommand);
	/**
	 * 时间管理
	 */
	public void timeConsume();
}
