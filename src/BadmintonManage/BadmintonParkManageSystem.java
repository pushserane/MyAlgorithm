package BadmintonManage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * name : BadmintonParkManageSystem
 * type : Instance
 * author : Serane
 * 功能；羽毛球场管理系统，继承于场地管理系统
 * 管理羽毛球场地管理实例。
 * 接受命令输入，将其传输给场地管理实例
 */
public class BadmintonParkManageSystem extends ParkManageSystem{
	/**
	 * 实例化场地管理
	 */
	public BadmintonParkManageSystem(){
		setBadmintonParkManage(new BadmintonParkManage());
		//timeControl();
	}
	@Override
	/**
	 * 默认启动方式
	 */
	public void start() {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BadmintonManageHint.setPromotion();
		systemWork(bufferedReader);
	}
	/**
	 * @param input:FileReader
	 * 按行读取文件内容作为命令
	 */
	public void start(FileReader input){//test
		BufferedReader bufferedReader = new BufferedReader(input);
		BadmintonManageHint.setPromotion();
		systemWork(bufferedReader,System.out);
	}
	/**
	 * @param bufferedReader
	 * @param outputStream
	 * 从bufferedReader获取命令，将其传输到场地管理实例
	 * outputStream用来设置输出方式/暂未使用
	 */
	private void systemWork(BufferedReader bufferedReader,OutputStream outputStream){
		String inputBooking;
		//BadmintonManageHint.setTime(2017, 9, 8, 10);
		//BadmintonManageHint.setTime();
		try {
			inputBooking = bufferedReader.readLine();
			while(inputBooking.length()!=0){//当遇到换行时终止
				System.out.println(inputBooking);//test
				getBadmintonParkManage().parkBooking(inputBooking.trim());//将命令传输给场地管理实例
				inputBooking = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//System.out.println("Change line");//test
		System.out.println("");
		getBadmintonParkManage().parkCount();//输出场地管理实例所管理的场地的收入汇总
	}
	/**
	 * @param bufferedReader
	 * 从bufferedReader获取命令，将其传输到场地管理实例
	 */
	private void systemWork(BufferedReader bufferedReader){
		String inputBooking;
		//BadmintonManageHint.setTime(2017, 9, 8, 10);
		try {
			inputBooking = bufferedReader.readLine();
			while(inputBooking.length()!=0){//当遇到换行时终止
				//System.out.println(inputBooking);//test
				getBadmintonParkManage().parkBooking(inputBooking.trim());//将命令传输给场地管理实例
				inputBooking = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//System.out.println("Change line");//test
		System.out.println("");
		getBadmintonParkManage().parkCount();//输出场地管理实例所管理的场地的收入汇总
	}
	private void timeControl(){
		BadmintonManageHint.setSystemData(new Date());
		Timer timer = new Timer();
		timer.schedule(new BadmintonParkTimeManage(getBadmintonParkManage()), getTime(), 3*1000);
	}
	private Date getTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,BadmintonManageHint.getSystemDate().getHours());
		calendar.set(Calendar.MINUTE, BadmintonManageHint.getSystemDate().getMinutes());
		calendar.set(Calendar.SECOND, BadmintonManageHint.getSystemDate().getSeconds() + 10);
		Date time = calendar.getTime();
		return time;
	}
	/**
	 * @param args
	 * 主程序启动入口
	 * 实例化场地管理系统并启动
	 */
	public static void main(String[] args){
		BadmintonParkManageSystem badmintonParkManageSystem = new BadmintonParkManageSystem();
		badmintonParkManageSystem.start();
	}
}