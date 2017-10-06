package BadmintonManage;

import java.util.ArrayList;

/**
 * name : BadmintonParkManage
 * type : Instance
 * author : Serane
 * ���ܣ���ë�򳡹���ϵͳ��������ë�򳡹���ʵ����
 * �����������룬���䴫������ع���ʵ��
 * Ԥ�����ڶ��ֳ��ع���
 */
public class BadmintonParkManage extends ParkManage{
	
	BadmintonParkManage(){
		setParkList(new ArrayList<Park>());
		addPark();
	}
	@Override
	/**
	 * ������غϷ�����������峡��ʵ������
	 */
	public void parkBooking(String inputBooking){
		if(isBookingCommandLegal(inputBooking)){//�ڷ������������Ƿ�Ϸ���ͬʱ����bookingCommand
			getParkList().get(0).booking(getBookingCommand());
		}else{
			System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.BOOKING_IS_INVALID);
		}
	}
	@Override
	/**
	 * �����������
	 */
	public void parkCount(){
		//System.out.println("badmintonIncomeCount");//test
		/*for(Park park:getParkList()){
			List<String> parkCountList = park.incomeCountString();
			for(String str:parkCountList)
				System.out.println(str);
		}
		*/
		for(Park park:getParkList()){
			park.incomeCount();
		}
	}
	/**
	 * @param inputBooking
	 * @return
	 * �ж������Ƿ�Ϸ�
	 */
	private boolean isBookingCommandLegal(String inputBooking){
		setBookingCommand(new BadmintonBookingCommand(inputBooking));
		//�ڷ������������Ƿ�Ϸ���ͬʱ����bookingCommand
		/*if(bookingCommand.isCommandLegal()){
			//System.out.println("input: "+inputBooking);//test
			//if(bookingCommand.bookingType == 0)badmintonBooking(bookingCommand);
			//else badmintonCancelling(bookingCommand);
			return true;
		}else return false;*/
		return getBookingCommand().isCommandLegal();
	}
	@Override
	/**
	 * ��ʼ�������б�Ŀǰֻ������ë�򳡣�Ԥ��
	 */
	public void addPark() {
		// TODO Auto-generated method stub
		getParkList().add(new BadmintonPark());
	}
}
