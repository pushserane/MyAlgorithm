package BadmintonManageTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RandomTestFileCreater{
	public static void main(String[] args) throws IOException{
		File newTestFile = new File("testFile/RandomTestFile1");
		FileWriter fileWriter = null;

		fileWriter = new FileWriter(newTestFile);

		String userName = "testUser";
		String bookingDate = null;
		String bookingTime = null;
		String bookingPark = null;
		String isCancelling = null;
		int testNum = 10;
		String testCommand = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Random random = new Random(System.nanoTime()%100);
		Calendar calendar = Calendar.getInstance();
		
		for(int i=0;i<testNum;i++){
			calendar.set(random.nextInt(10000), random.nextInt(100), random.nextInt(100));
			bookingDate = simpleDateFormat.format(calendar.getTime());
			bookingTime = random.nextInt(50)+":"+random.nextInt(120)+"~"+random.nextInt(50)+":"+random.nextInt(120);
			bookingPark = String.valueOf((char)(random.nextInt(26)+'A'));
			isCancelling = (random.nextDouble()>0.5)?"C":"";
			testCommand = userName + " " + bookingDate + " " + bookingTime + " " + bookingPark + " " + isCancelling;
			//System.out.println(testCommand);
			fileWriter.write(testCommand+"\n");
		}
		fileWriter.write("\n");
		fileWriter.flush();
		fileWriter.close();
	}
}