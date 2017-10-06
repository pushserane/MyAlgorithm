package BadmintonManage;

import java.util.List;
import java.util.TimerTask;

public abstract class ParkTimeManage extends TimerTask implements ParkTimeManageInterface{
	private ParkManage parkManage;
	private List<Park> parkList;
	/**
	 * @return the parkManage
	 */
	public ParkManage getParkManage() {
		return parkManage;
	}

	/**
	 * @param parkManage the parkManage to set
	 */
	public void setParkManage(ParkManage parkManage) {
		this.parkManage = parkManage;
	}

	/**
	 * @return the parkList
	 */
	public List<Park> getParkList() {
		return parkList;
	}

	/**
	 * @param parkList the parkList to set
	 */
	public void setParkList(List<Park> parkList) {
		this.parkList = parkList;
	}
}
