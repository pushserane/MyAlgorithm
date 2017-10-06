package BadmintonManage;

import java.util.Date;

public class BadmintonParkTimeManage extends ParkTimeManage{
	
	
	BadmintonParkTimeManage(ParkManage parkManage){
		this.setParkManage(parkManage);
		this.setParkList(this.getParkManage().getParkList());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BadmintonManageHint.setSystemData(new Date());
		for(Park parkTypeItem : this.getParkList()){
			for(ParkItem parkItem: parkTypeItem.getItemList()){
				parkItem.timeConsume();
			}
		}
	}

}
