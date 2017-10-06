package hw;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static List<String> Indirect;
    public static void main(String[] args) {
    	Indirect = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        for(int i = 0; i < totalNum*2; i++){
        	temp = sc.nextLine();
        	Indirect.add(temp);
        }
        String command = sc.nextLine();
        sc.close();
        String[] quanming = new String[totalNum];
        String[] subM = new String[totalNum];
        String[] fM = new String[totalNum];
        String[] sM = new String[totalNum];
        String[] numbers = new String[totalNum];
        //System.out.println(totalNum);
        for(int i = 0; i < totalNum; i++){
        	numbers[i] = Indirect.get(i*2+1);
        	quanming[i] = Indirect.get(i*2);
        	String temp_t = Indirect.get(i*2);
        	String[] temps_p = temp_t.split(" ");
        	for(int j=0;j<temps_p.length;j++)
        		subM[i] += temps_p[j].charAt(0);
        	fM[i] = temps_p[0];
        	sM[i] = temps_p[1];
        }
        
    }
}