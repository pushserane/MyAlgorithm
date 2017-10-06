public class Main {
    public static void main(String[] args) {
    	double testDouble = 200.0;
    	String test = getOutputEarn(testDouble);
    	String test2 = "" + (testDouble%1==0?String.valueOf((int)testDouble):testDouble);
    	System.out.println(testDouble%1==0);	
    	System.out.println(test2);
    	
    }
    public static String getOutputEarn(double earn){
		return "" + (earn%1==0?String.valueOf(earn):earn);
	}
}