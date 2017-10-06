package BadmintonManage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * name : BadmintonManageHint
 * type : Static Instance
 * author : Serane
 * 功能；用于保存静态变量
 */
public class BadmintonManageHint {
	//失败，预定语句不合法
	public static final String BOOKING_IS_INVALID = "Error: the booking is invalid!";
	//预定或取消成功，预定成功
	public static final String BOOKING_IS_ACCEPTED = "Success: the booking is accepted!";
	//预定失败。预定冲突
	public static final String BOOKING_CONFLICT = "Error: the booking conflicts with existing bookings!";
	//取消失败，预定不存在
	public static final String BOOKING_CANCEL_NOT_EXIST = "Error: the booking being cancelled does not exist!";
	//单位
	public static final String UNIT = "元";
	//输出占位符
	public static final String PLACE_HOLDER = "> ";
	//违约金
	public static final String DEFAULT_FINE = "违约金";
	//场地
	public static final String PLACE_STRING = "场地";
	//球场表
	public static final List<String> PARK_LIST = Arrays.asList("A", "B", "C", "D");
	//命令类型
	public static final int BOOKING = 0;
	public static final int CANCELLING = 1;
	
	//收费表
	/*
	public static final int WEEKDAY_NINE_TWELVE = 30;
	public static final int WEEKDAY_TWELVE_EIGHTEEN = 50;
	public static final int WEEKDAY_EIGHTEEN_TWENTY = 80;
	public static final int WEEKDAY_TWENTY_TWENTYTWO = 60;
	public static final int WEEKEND_NINE_TWELVE = 40;
	public static final int WEEKEND_TWELVE_EIGHTEEN = 50;
	public static final int WEEKEND_EIGHTEEN_TWENTYTWO = 60;
	*/
	public static final double WEEKDAY_CANCEL_RATE = 0.5;
	public static final double WEEKEND_CANCEL_RATE = 0.25;
	//List子项中3个int字段分别是：起始时间；结束时间；价格
	public static final List<List<Integer>> WEEKDAY_CHARGE_TABLE = Arrays.asList(
			Arrays.asList(9,12,30),
			Arrays.asList(12,18,50),
			Arrays.asList(18,20,80),
			Arrays.asList(20,22,60)
			);
	public static final List<List<Integer>> WEEKEND_CHARGE_TABLE = Arrays.asList(
			Arrays.asList(9,12,40),
			Arrays.asList(12,18,50),
			Arrays.asList(18,22,60)
			);
	//加入时间管理
	//系统当前时间
	public static int year = 1999;
	public static int month = 12;
	public static int day = 5;
	public static int time = 12;
	public static int whatDay = 1;
	public static boolean setTime(int year_,int month_,int day_,int time_){
		year = year_;
		month = month_;
		day = day_;
		time = time_;
		return true;
	}
	public static Date SYSTEM_DATE = new Date();
	public static long SYSTEM_TIMESTAMP;
	public static boolean setSystemData(Date date){
		SYSTEM_DATE = date;
		System.out.println("SYSTEM_DATE="+SYSTEM_DATE);//test
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			String dateString = simpleDateFormat.format(date).substring(0,14)+"00";
			//System.out.println(dateString);//test
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SYSTEM_TIMESTAMP = date.getTime();
		
		//System.out.println("SYSTEM_TIMESTAMP="+SYSTEM_TIMESTAMP);//test
		return true;
	}
	public static Date getSystemDate(){
		return SYSTEM_DATE;
	}
	public static String getOutputNum(double earn){
		return "" + (earn%1==0?String.valueOf((int)earn):earn);
	}
	//优惠
	public static List<String> PROMOTION = new ArrayList<String>();
	public static void setPromotion(){
		PROMOTION.add("2016-04-01 2016-04-02 6");
		PROMOTION.add("2017-08-01 2017-08-03 8");
		//System.out.println("setPromotion success");
	}
}
