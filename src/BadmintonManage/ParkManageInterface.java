package BadmintonManage;
/**
 * name : ParkManageInterface
 * type : Interface
 * author : Serane
 * 功能；场地管理接口，定义场地管理应有的方法
 */
public interface ParkManageInterface {
	/**
	 * @param inputBooking
	 * 以inputBooking为命令语句预定或取消场地
	 */
	public void parkBooking(String inputBooking);
	/**
	 * 计算场地收入汇总
	 */
	public void parkCount();
}
