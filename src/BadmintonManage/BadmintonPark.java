package BadmintonManage;

import java.util.ArrayList;
/**
 * name : BadmintonPark
 * type : Instance
 * author : Serane
 * ���ܣ���ë��ʵ��
 * ������ë��
 */
public class BadmintonPark extends Park{
	
	BadmintonPark(){
		setItemList(new ArrayList<ParkItem>());
		addParkItem();
		}
	@Override
	/**
	 * ��ȡ����Id
	 * ������������ѡ��Ԥ����ȡ��Ԥ��
	 */
	public void booking(BookingCommand bookingCommand){
		//System.out.println(bookingCommand);//test
		if(bookingCommand.getBookingType()==BadmintonManageHint.BOOKING)
			getItemList().get(bookingCommand.getBookingParkId()).booking(bookingCommand);
		else getItemList().get(bookingCommand.getBookingParkId()).cancelling(bookingCommand);
	}

	@Override
	/**
	 * ���ݳ��ر���ӳ���
	 */
	public void addParkItem() {
		// TODO Auto-generated method stub
		for(String park:BadmintonManageHint.PARK_LIST){
			getItemList().add(new BadmintonParkItem(park));
			//badmintonList.add(new BadmintonParkItem(park));
		}
	}
}