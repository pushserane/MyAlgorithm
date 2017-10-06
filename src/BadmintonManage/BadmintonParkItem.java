package BadmintonManage;

import java.util.ArrayList;
import java.util.List;
/**
 * name : BadmintonParkItem
 * type : Instance
 * author : Serane
 * 功能：羽毛球场实例，管理具体预定
 */
public class BadmintonParkItem extends ParkItem{
	//int parkId;
	BadmintonParkItem(String parkName){
		setParkName(parkName);
		//this.parkId = getBadmintonId(parkName);
		setBookingList(new ArrayList<Booking>());
	}
	/*int getBadmintonId(String parkName){
		for(int i=0;i<BadmintonManageHint.PARK_LIST.size();i++){
			if(BadmintonManageHint.PARK_LIST.get(i).equals(parkName))
				return i;
		}
		return 0;
	}*/
	@Override
	/**
	 * 获取预定应插入的位置
	 */
	public int getPosition(BookingCommand bookingCommand) {
		// TODO Auto-generated method stub
		return getPositionBinarySearch(bookingCommand,getBookingList());
	}
	/**
	 * @param bookingCommand
	 * @param bookingList
	 * @return
	 * 使用二分查找应插入的位置
	 */
	private int getPositionBinarySearch(BookingCommand bookingCommand, List<Booking> bookingList){
		long kTimeStamp = bookingCommand.getTimeStamp();
		int start = 0;
		int end = bookingList.size() - 1;
		int mid = 0;
		while(start <= end){
			mid = start + (end - start)/2;
			if(bookingList.get(mid).getTimeStamp() == kTimeStamp)return mid;
			else if(bookingList.get(mid).getTimeStamp() < kTimeStamp){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return start;
	}
	@Override
	/**
	 * 判断预定是否与已有预定冲突
	 */
	public boolean isBookConflict(BookingCommand bookingCommand) {
		// TODO Auto-generated method stub
		for(Booking bookItem:getBookingList()){
			if(!bookItem.isBreak()/*&&!bookItem.isCompleted()*/){
				if(bookingCommand.getBookingDate().equals(bookItem.getBookingDate())){
					if((bookingCommand.getStartHour()<bookItem.getStartHour()&&bookingCommand.getEndHour()>bookItem.getStartHour()
							&&bookingCommand.getEndHour()<bookItem.getEndHour())
						||(bookingCommand.getStartHour()>bookItem.getStartHour()&&bookingCommand.getStartHour()<bookItem.getEndHour()
							&&bookingCommand.getEndHour()>bookItem.getEndHour())
						||(bookingCommand.getStartHour()<=bookItem.getStartHour()&&bookingCommand.getEndHour()>=bookItem.getEndHour())
						||(bookingCommand.getStartHour()>bookItem.getStartHour()&&bookingCommand.getEndHour()<bookItem.getEndHour())
					){
					return true;
					}
				}
			}
		}
		return false;
	}
	@Override
	/**
	 * 取消预定
	 */
	public void cancelling(BookingCommand bookingCommand) {
		// TODO Auto-generated method stub
		if(isBookExist(bookingCommand)){
			for(int i=0;i<getBookingList().size();i++){
				if(getBookingList().get(i).getInputBooking().equals 
						(bookingCommand.getInputBooking().substring(0, bookingCommand.getInputBooking().length()-2))){
					getBookingList().get(i).cancelBook();
					break;
				}
			}
			System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.BOOKING_IS_ACCEPTED);
		}else{
			System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.BOOKING_CANCEL_NOT_EXIST);
		}
		//System.out.println("cancelling/badmintonBook　length:"+badmintonBook.size());//test
	}
	@Override
	/**
	 * 预定
	 */
	public void booking(BookingCommand bookingCommand) {
		// TODO Auto-generated method stub
		if(isBookConflict(bookingCommand)){
			System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.BOOKING_CONFLICT);
		}else{
			//System.out.println(getPosition(bookingCommand) + "|" + badmintonBook);//test
			//badmintonBook.add(getPosition(bookingCommand),new BadmintonBook(bookingCommand));
			getBookingList().add(getPosition(bookingCommand),new BadmintonBooking(bookingCommand));
			
			//System.out.println(badmintonBook);//test
			//badmintonBook.get(badmintonBook.size()-1).setEarn();
			System.out.println(BadmintonManageHint.PLACE_HOLDER + BadmintonManageHint.BOOKING_IS_ACCEPTED);
		}
		//System.out.println("booking/badmintonBook　length:"+badmintonBook.size());//test
	}
	@Override
	/**
	 * 判断当前预定是否存在
	 */
	public boolean isBookExist(BookingCommand bookingCommand) {
		// TODO Auto-generated method stub
		for(Booking bookItem:getBookingList()){
			if(!bookItem.isBreak()/*&&!bookItem.isCompleted()&&!bookItem.isLocked()*/)
				if(bookItem.getInputBooking().equals(bookingCommand.getInputBooking().substring(0, bookingCommand.getInputBooking().length()-2)))
					return true;
		}
		return false;
	}
}

