package BadmintonManage;
/**
 * name : BadmintonBooking
 * type : Instance
 * author : Serane
 * 功能；羽毛球场预定
 */
public class BadmintonBooking extends Booking{

	String bookingUserId;
	//int bookingDateYear;
	//int bookingDateMonth;
	//int bookingDateDay;
	int bookingDateWhichDay;//1-7分别表示星期一到星期天

	String bookingPark;
	int bookingParkId;

	BadmintonBooking(BookingCommand bookingCommand){
		this.setInputBooking(bookingCommand.getInputBooking());
		this.bookingUserId = bookingCommand.getBookingUserId();
		this.setBookingDate(bookingCommand.getBookingDate());
		//this.bookingDateYear = bookingCommand.bookingDateYear;
		//this.bookingDateMonth = bookingCommand.bookingDateMonth;
		//this.bookingDateDay = bookingCommand.bookingDateDay;
		bookingDateWhichDay = bookingCommand.getBookingDateWhichDay();
		setBookingTimeSlot(bookingCommand.getBookingTimeSlot());
		this.setStartHour(bookingCommand.getStartHour());
		this.setEndHour(bookingCommand.getEndHour());
		this.bookingPark = bookingCommand.getBookingPark();
		this.bookingParkId = bookingCommand.getBookingParkId();
		this.calculateEarn();
		this.setTimeStamp(bookingCommand.getTimeStamp());
		//this.setTimeStamp(bookingDate + " " + this.bookingTimeSlot.split("~")[0]);
	}
	public void calculateEarn(){
		int timeBreakLength = 0;
		int[] timeBreak = null;
		int[] chargeBreak = null;
		if(bookingDateWhichDay<6){
			timeBreakLength = BadmintonManageHint.WEEKDAY_CHARGE_TABLE.size();
			timeBreak = new int[timeBreakLength+1];
			timeBreak[0] = BadmintonManageHint.WEEKDAY_CHARGE_TABLE.get(0).get(0);
			chargeBreak = new int[timeBreakLength];
			for(int i=1;i<=timeBreakLength;i++){
				timeBreak[i] = BadmintonManageHint.WEEKDAY_CHARGE_TABLE.get(i-1).get(1);
				chargeBreak[i-1] = BadmintonManageHint.WEEKDAY_CHARGE_TABLE.get(i-1).get(2);
			}
		}else{
			timeBreakLength = BadmintonManageHint.WEEKEND_CHARGE_TABLE.size();
			timeBreak = new int[timeBreakLength+1];
			timeBreak[0] = BadmintonManageHint.WEEKEND_CHARGE_TABLE.get(0).get(0);
			chargeBreak = new int[timeBreakLength];
			for(int i=1;i<=timeBreakLength;i++){
				timeBreak[i] = BadmintonManageHint.WEEKEND_CHARGE_TABLE.get(i-1).get(1);
				chargeBreak[i-1] = BadmintonManageHint.WEEKEND_CHARGE_TABLE.get(i-1).get(2);
			}
		}
		this.setEarn(calculateTimeBreak(getStartHour(),getEndHour(),timeBreak,chargeBreak));//
		//this.setPromotion(promotion);;
		getPromotionNum();
		/*
		System.out.println("startHour="+startHour+" endHour="+endHour+" timeBreak="+timeBreak.length +" chargeBreak="+chargeBreak.length);
		System.out.println("timeBreak:");
		for(int i:timeBreak)System.out.print(i+",");
		System.out.println("\nchargeBreak:");
		for(int i:chargeBreak)System.out.print(i+",");
		System.out.println("");
		*/
	}
	double getPromotionNum(){
		//this.getBookingDate();这条booking本身的预定时间
		//当预定的时间段在我的折扣范围内的话，就对其计算折扣
		String[] promotionItems = null;
		for(String promotionItem:BadmintonManageHint.PROMOTION){
			//System.out.println(promotionItem);//test
			promotionItems = promotionItem.split(" ");
			
		}
		return 0;
	}
	
	double calculateTimeBreak(int startTime,int endTime,int[] timeBreak,int[] chargeBreak){
		double calculateOut = 0;
		for(int i=1;i<timeBreak.length;i++){
			calculateOut += getInTimeBreak(startTime,endTime,timeBreak[i-1],timeBreak[i])*chargeBreak[i-1];
			//System.out.println("calculateOut="+calculateOut+" inTimeBreak=" + getInTimeBreak(startTime,endTime,timeBreak[i-1],timeBreak[i]) + " charge="+chargeBreak[i-1]);//test
		}
		return calculateOut;
	}
	int getInTimeBreak(int startTime,int endTime,int leftBreak,int rightBreak){
		if(startTime<leftBreak&&endTime>leftBreak&&endTime<rightBreak){
			return endTime - leftBreak;
		}
		else if(startTime>=leftBreak&&endTime<=rightBreak){
			return endTime - startTime;
		}
		else if(startTime<=leftBreak&&endTime>=rightBreak){
			return rightBreak - leftBreak;
		}
		else if(leftBreak<startTime&&rightBreak>startTime&&rightBreak<endTime){
			return rightBreak - startTime;
		}
		else return 0;
	}
	/*public void setTimeStamp(String data_startHour){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
		try {
			date = simpleDateFormat.parse(data_startHour);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.timeStamp = date.getTime();
		System.out.println("timeStamp=" + timeStamp);
    }*/
	public void cancelBook(){
		this.setBreak(true);
		if(bookingDateWhichDay<6){
			setEarn(this.getEarn()*BadmintonManageHint.WEEKDAY_CANCEL_RATE);
		}else{
			setEarn(this.getEarn()*BadmintonManageHint.WEEKEND_CANCEL_RATE);
		}	
	}
	public String toString(){
		//System.out.println(this.earn%1==0);//test
		//System.out.println((this.earn)%1==0?(int)this.earn:this.earn);//test
		StringBuffer outputString = new StringBuffer();
		outputString.append(this.getBookingDate() + " " 
					+ this.getBookingTimeSlot() );
		/*if(isBreak){
			return this.bookingDate + " " 
					+ this.bookingTimeSlot + " " 
					+ BadmintonManageHint.DEFAULT_FINE+ " "
					+ BadmintonManageHint.getOutputEarn(this.earn)
					+ BadmintonManageHint.UNIT;
		}else{
			return this.bookingDate + " "
					+ this.bookingTimeSlot + " "
					+ BadmintonManageHint.getOutputEarn(this.earn)
					+ BadmintonManageHint.UNIT;
		}*/
		if(isBreak()){
			outputString.append(" " + BadmintonManageHint.DEFAULT_FINE);
		}
		outputString.append(" " + BadmintonManageHint.getOutputNum(this.getEarn()) + BadmintonManageHint.UNIT);
		return outputString.toString();
	}
}
