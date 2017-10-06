package BadmintonManage;

import java.util.ArrayList;
/**
 * name : BadmintonPark
 * type : Instance
 * author : Serane
 * 功能；羽毛球场实例
 * 管理羽毛球场
 */
public class BadmintonPark extends Park{
	
	BadmintonPark(){
		setItemList(new ArrayList<ParkItem>());
		addParkItem();
		}
	@Override
	/**
	 * 获取场地Id
	 * 根据命令类型选择预定或取消预定
	 */
	public void booking(BookingCommand bookingCommand){
		//System.out.println(bookingCommand);//test
		if(bookingCommand.getBookingType()==BadmintonManageHint.BOOKING)
			getItemList().get(bookingCommand.getBookingParkId()).booking(bookingCommand);
		else getItemList().get(bookingCommand.getBookingParkId()).cancelling(bookingCommand);
	}

	@Override
	/**
	 * 根据场地表添加场地
	 */
	public void addParkItem() {
		// TODO Auto-generated method stub
		for(String park:BadmintonManageHint.PARK_LIST){
			getItemList().add(new BadmintonParkItem(park));
			//badmintonList.add(new BadmintonParkItem(park));
		}
	}
}