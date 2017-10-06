package BadmintonManage;
/**
 * name : BookingCommandInterface
 * type : Interface
 * author : Serane
 * 功能；预定命令接口
 */
public interface BookingCommandInterface {
	/**
	 * @return
	 * 命令是否合法
	 */
	public boolean isCommandLegal();
}
