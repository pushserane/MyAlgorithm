package temp;

public class TestMyMain {
	public static void main(String[] args){
		double testNum = 23.00;
		String testNum2 = "24.00";
		System.out.println(testNum%1==0);
		boolean testBoolean = (testNum%1==0)?(printTestTrue()):(printTestFalse());
		String testString = (testNum%1==0)?(printTestTrueString()):(printTestFalseString());
		System.out.println(testString);
		String testString2 ="" + ((testNum%1==0)?((int)testNum):testNum2);//23.0,:两边为同等位置，猜测：编译器保持两边类型一样，在（int）强制转型后又自动转型为double；
		printType((1%1==0)?((int)testNum):testNum2);
		printType((int)testNum);
		System.out.println(testString2);
		String testString3 = "" + (int)testNum;//23
		System.out.println(testString3);
		Body body = new Man();
		printType(body);
		String t =""+ printType((1%1==0)?printType((int)testNum):printType(testNum));
	}
	public static double printType(Object test){
		System.out.println(test.getClass().toString());
		return 1.0;
	}
	public static boolean printTestTrue(){
		System.out.println("i am test true");
		return true;
	}
	public static boolean printTestFalse(){
		System.out.println("i am test false");
		return false;
	}
	public static String printTestTrueString(){
		return "i am test true";
	}
	public static String printTestFalseString(){
		return "i am test false";
	}
}
class Body{
	
}
class Man extends Body{
	
}
