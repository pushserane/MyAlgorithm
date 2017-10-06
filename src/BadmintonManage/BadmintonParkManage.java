package BadmintonManage;

import java.util.ArrayList;

/**
 * name : BadmintonParkManage
 * type : Instance
 * author : Serane
 * 功能；羽毛球场管理系统，管理羽毛球场管理实例。
 * 接受命令输入，将其传输给场地管理实例
 * 预留用于多种场地管理
 */
public class BadmintonParkManage extends ParkManage{
	
	BadmintonParkManage(){
		setParkList(new ArrayList<Park>());
		addPark();
	}
	@Override
	/**
	 * 如果场地合法，则传输给具体场地实例处理
	 */
	public void parkBooking(String inputBooking){
		if(isBookingCommandLegal(inputBooking)){//在分析命令输入是否合法的同时设置bookingCommand
			getParkList().get(0).booking(getBookingCommand());
		}else{
			System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.BOOKING_IS_INVALID);
		}
	}
	@Override
	/**
	 * 场地收入汇总
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
	 * 判断命令是否合法
	 */
	private boolean isBookingCommandLegal(String inputBooking){
		setBookingCommand(new BadmintonBookingCommand(inputBooking));
		//在分析命令输入是否合法的同时设置bookingCommand
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
	 * 初始化场地列表，目前只管理羽毛球场，预留
	 */
	public void addPark() {
		// TODO Auto-generated method stub
		getParkList().add(new BadmintonPark());
	}
}
