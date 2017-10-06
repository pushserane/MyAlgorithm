package BadmintonManage;
/**
 * name : ParkManageSystem
 * type : abstract
 * author : Serane
 * 功能；场地管理系统的抽象类，管理场地管理实例
 */
public abstract class ParkManageSystem implements ParkManageSystemInterface{
	/**
	 * instance of class park manage 
	 */
	private ParkManage badmintonParkManage;

	/**
	 * @return the badmintonParkManage
	 */
	public ParkManage getBadmintonParkManage() {
		return badmintonParkManage;
	}

	/**
	 * @param badmintonParkManage the badmintonParkManage to set
	 */
	public void setBadmintonParkManage(ParkManage badmintonParkManage) {
		this.badmintonParkManage = badmintonParkManage;
	}
}
