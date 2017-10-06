package BadmintonManageTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import BadmintonManage.BadmintonParkManageSystem;
/**
 * name : BadmintonParkManageSystemTest
 * type : Test Instance
 * author : Serane
 * 功能：按测试文本输入测试用例
 */
public class BadmintonParkManageSystemTest {
	public static void main(String[] args){
		String testFileName = "testFile/TestBookingCommand1";
		long startTime = System.nanoTime();
		//String testFileName = "testFile";
		//String testFileName = "testFile/RandomTestFile1";
		boolean T = true;//打印开关
		if(args.length!=0){
			testFileName = args[0];
			T = false;
		}
		File file = new File(testFileName);
		BadmintonParkManageSystemTest badmintonParkManageSystemTest = new BadmintonParkManageSystemTest();
		badmintonParkManageSystemTest.startTest(file,T);
		if(T)System.out.println("UsedTime:" + (System.nanoTime()-startTime));
	}
	public void startTest(File file,boolean T){
		FileReader reader = null;
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File fileItem:files){
				startTest(fileItem,T);
			}
		}else{		
			try {
				reader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(T)System.out.println("Test File Name:"+file.getName());
			new BadmintonParkManageSystem().start(reader);
		}	
	}
}
