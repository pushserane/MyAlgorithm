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
 * ���ܣ���ë�򳡹���ϵͳ���̳��ڳ��ع���ϵͳ
 * ������ë�򳡵ع���ʵ����
 * �����������룬���䴫������ع���ʵ��
 */
public class BadmintonParkManageSystem extends ParkManageSystem{
	/**
	 * ʵ�������ع���
	 */
	public BadmintonParkManageSystem(){
		setBadmintonParkManage(new BadmintonParkManage());
		//timeControl();
	}
	@Override
	/**
	 * Ĭ��������ʽ
	 */
	public void start() {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BadmintonManageHint.setPromotion();
		systemWork(bufferedReader);
	}
	/**
	 * @param input:FileReader
	 * ���ж�ȡ�ļ�������Ϊ����
	 */
	public void start(FileReader input){//test
		BufferedReader bufferedReader = new BufferedReader(input);
		BadmintonManageHint.setPromotion();
		systemWork(bufferedReader,System.out);
	}
	/**
	 * @param bufferedReader
	 * @param outputStream
	 * ��bufferedReader��ȡ������䴫�䵽���ع���ʵ��
	 * outputStream�������������ʽ/��δʹ��
	 */
	private void systemWork(BufferedReader bufferedReader,OutputStream outputStream){
		String inputBooking;
		//BadmintonManageHint.setTime(2017, 9, 8, 10);
		//BadmintonManageHint.setTime();
		try {
			inputBooking = bufferedReader.readLine();
			while(inputBooking.length()!=0){//����������ʱ��ֹ
				System.out.println(inputBooking);//test
				getBadmintonParkManage().parkBooking(inputBooking.trim());//�����������ع���ʵ��
				inputBooking = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//System.out.println("Change line");//test
		System.out.println("");
		getBadmintonParkManage().parkCount();//������ع���ʵ��������ĳ��ص��������
	}
	/**
	 * @param bufferedReader
	 * ��bufferedReader��ȡ������䴫�䵽���ع���ʵ��
	 */
	private void systemWork(BufferedReader bufferedReader){
		String inputBooking;
		//BadmintonManageHint.setTime(2017, 9, 8, 10);
		try {
			inputBooking = bufferedReader.readLine();
			while(inputBooking.length()!=0){//����������ʱ��ֹ
				//System.out.println(inputBooking);//test
				getBadmintonParkManage().parkBooking(inputBooking.trim());//�����������ع���ʵ��
				inputBooking = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//System.out.println("Change line");//test
		System.out.println("");
		getBadmintonParkManage().parkCount();//������ع���ʵ��������ĳ��ص��������
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
	 * �������������
	 * ʵ�������ع���ϵͳ������
	 */
	public static void main(String[] args){
		BadmintonParkManageSystem badmintonParkManageSystem = new BadmintonParkManageSystem();
		badmintonParkManageSystem.start();
	}
}