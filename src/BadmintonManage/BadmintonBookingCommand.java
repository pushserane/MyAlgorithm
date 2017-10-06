package BadmintonManage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * name : BadmintonBookingCommand
 * type : Instance
 * author : Serane
 * 功能；羽毛球场预定命令
 */
public class BadmintonBookingCommand extends BookingCommand{
	int bookingDateYear;//预定年，预留
	int bookingDateMonth;//预定月，预留
	int bookingDateDay;//预定天，预定
	
	BadmintonBookingCommand(String inputBooking){
		this.setInputBooking(inputBooking);
	}
	/*
	public String toString(){
		return  "inputBooking:" + inputBooking +
		";bookingUserId:" + bookingUserId +
		";\nbookingDate:" + bookingDate +
		";bookingDateYear:" + bookingDateYear +
		";bookingDateMonth:" + bookingDateMonth +
		";bookingDateDay:" + bookingDateDay +
		";bookingDateWhichDay:" + bookingDateWhichDay + //1-7分别表示星期一到星期天
		";\nbookingTimeSlot:" + bookingTimeSlot +
		";startHour:" + startHour +
		";endHour:" + endHour +
		";\nbookingPark:" + bookingPark +
		";bookingParkId:" + bookingParkId +
		";bookingType:" + bookingType;
	}//test*/
	/**
	 * 判断命令是否合法，同时设置命令中各参数
	 */
	public boolean isCommandLegal(){
		String[] _inputBooking = getInputBooking().split(" ");
		if(!isCommandLengthLegal(_inputBooking.length)){
			return false;
		}else{
			if(!bookingUserCheck(_inputBooking[0].trim())){
				//System.out.println("error: bookingUserCheck");//test
				return false;
			}
			if(!bookingDateCheck(_inputBooking[1].trim())){
				//System.out.println("error: bookingDateCheck");//test
				return false;
			}
			if(!bookingTimeCheck(_inputBooking[2].trim())){
				//System.out.println("error: bookingTimeCheck");//test
				return false;
			}
			if(!bookingParkCheck(_inputBooking[3].trim())){
				//System.out.println("error: bookingParkCheck");//test
				return false;
			}
			if(_inputBooking.length==5){
				if(!bookingTypeCheck(_inputBooking[4].trim()))
					return false;
			}
		}
		this.setTimeStamp(this.getBookingDate() + " " + this.getBookingTimeSlot().split("~")[0]);//设置时间戳
		return true;
	}
	/**
	 * @param type
	 * @return
	 * 检查预定类型，是否为取消预定
	 */
	private boolean bookingTypeCheck(String type){
		if(type.equals("C")){
			this.setBookingType(BadmintonManageHint.BOOKING);
			return true;
		}else return false;
	}
	/**
	 * @param park
	 * @return
	 * 检查预定场地是否合法
	 */
	private boolean bookingParkCheck(String park){
		//System.out.println(park);//test
		/*if(BadmintonManageHint.PARK_LIST.contains(park)){
			this.bookingPark = park;
			return true;
		}*/
		for(int i=0;i<BadmintonManageHint.PARK_LIST.size();i++){
			if(BadmintonManageHint.PARK_LIST.get(i).equals(park)){
				this.setBookingPark(park);
				this.setBookingParkId(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * @param timeSlot
	 * @return
	 * 检查预定时间是否合法
	 */
	private boolean bookingTimeCheck(String timeSlot){
		String[] _timeSlot = timeSlot.split("~");
		//System.out.println(_timeSlot.length);//test
		if(_timeSlot.length!=2)return false;
		if(_timeSlot[0].length()!=5||_timeSlot[1].length()!=5)return false;
		//System.out.println("--");//test
		String[] startTime = _timeSlot[0].split(":");
		String[] endTime = _timeSlot[1].split(":");
		if(startTime.length!=2||endTime.length!=2)return false;
		//System.out.println("--");//test
		if(startTime[0].length()!=2||startTime[1].length()!=2||endTime[0].length()!=2||endTime[1].length()!=2)
			return false;
		//System.out.println("--");//test
		int startHour=0,endHour=0,startMinute=0,endMinute=0;
		try{
			startHour = Integer.parseInt(startTime[0]);
			startMinute = Integer.parseInt(startTime[1]);
			endHour = Integer.parseInt(endTime[0]);
			endMinute = Integer.parseInt(endTime[1]);
		}catch(java.lang.NumberFormatException e){
			return false;
		}
		//System.out.println("--");//test
		if(startHour<9||startHour>22)return false;
		if(endHour<9||endHour>22)return false;
		if(startMinute!=0||endMinute!=0)return false;
		//System.out.println("--");//test
		if(startHour>=endHour)return false;
		this.setBookingTimeSlot(timeSlot);
		this.setStartHour(startHour);
		this.setEndHour(endHour);
		return true;
	}
	/**
	 * @param userId
	 * @return
	 * 检查预定用户是否合法
	 */
	private boolean bookingUserCheck(String userId){
		this.setBookingUserId(userId);
		return true;
	}
	/**
	 * @param date
	 * @return
	 * 检查预定日期是否合法
	 */
	private boolean bookingDateCheck(String date){
		String[] _date = date.split("-");
		//System.out.println(_date.length);//test
		if(_date.length!=3)return false;
		int year=0,month=0,day=0;
		try{
			if(_date[0].length()!=4||_date[1].length()!=2||_date[2].length()!=2)return false;
			year = Integer.parseInt(_date[0]);
			month = Integer.parseInt(_date[1]);
			day = Integer.parseInt(_date[2]);
			//System.out.println(year+"-"+month+"-"+day);
		}catch(java.lang.NumberFormatException e){
			return false;
		}
		if(!isDateLegal(year,month,day))return false;
		this.bookingDateYear = year;
		this.bookingDateMonth = month;
		this.bookingDateDay = day;
		this.setBookingDate(date);
		this.setBookingDateWhichDay(getWhichDay());
		//System.out.println(this.bookingDateYear+"|"+this.bookingDateMonth+"|"
		//			+this.bookingDateDay+"|"+this.bookingDate+"|"+this.bookingDateWhichDay);//test
		return true;
	}
	/**
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 * 检查日期是否合法
	 */
	private boolean isDateLegal(int year,int month,int day){
		//year check unknown
		
		//month and day check
		if(month<1|month>12)return false;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			if(day<1||day>31)
				return false;
		}else if(month==4||month==6||month==9||month==11){
			if(day<1||day>30)
				return false;
		}else{
			if(isLeapYear(year)){
				if(day<1||day>29)
					return false;
			}else{
				if(day<1||day>28)
					return false;
			}
		}
		return true;
	}
	/**
	 * @param year
	 * @return
	 * 判断year是否是闰年
	 */
	private boolean isLeapYear(int year){
		if(year%4==0&&year%100!=0||year%400==0)
			return true;
		return false;
	}
	/**
	 * @return
	 * 获取预定日期是星期几
	 */
	private int getWhichDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(format.parse(this.getBookingDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dayForWeek = 0;
		if(c.get(Calendar.DAY_OF_WEEK) == 1){
			dayForWeek = 7;
		}else{
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	/**
	 * @param length
	 * @return
	 * 判断命令长度是否合法
	 */
	private boolean isCommandLengthLegal(int length){
		//System.out.println(length);//test
		return length==4||length==5;//预定命令由4个小字符串组成，预定取消命令由5个小字符串组成
	}
	/**
	 * 设置时间戳
	 */
	private void setTimeStamp(String data_startHour){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
		try {
			date = simpleDateFormat.parse(data_startHour);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setTimeStamp(date.getTime());
		//System.out.println("timeStamp=" + timeStamp);//test
    }
}
