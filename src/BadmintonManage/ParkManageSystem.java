package BadmintonManage;
/**
 * name : ParkManageSystem
 * type : abstract
 * author : Serane
 * ���ܣ����ع���ϵͳ�ĳ����࣬�����ع���ʵ��
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
