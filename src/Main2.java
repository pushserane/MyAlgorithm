import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        double temp = 0.0;
        int[] Order = new int[n];
        for(int i=0;i<n;i++)Order[i]=0;
        int[] redMetric = new int[n*2+1];
        while(ifEnd(Order)){
        	sum += getRed(Order,redMetric);
        	temp += 1.0;
        	//for(int i:Order)System.out.print(i+" ");
        	//System.out.println(" ");
        	incOrder(Order);
        }
        sum +=getRed(Order,redMetric);
        temp+=1.0;
        DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
        df.setMaximumFractionDigits(1);
        System.out.println(df.format(sum/temp));
	}
	public static void incOrder(int[] Order){
		int length = Order.length;
		int inc = 1;
		for(int i=0;i<length;i++){
			if(Order[i]==0){
				Order[i]+=1;
				inc = 0;
			}else{
				Order[i]=0;
			}
			if(inc == 0)return;
		}
	}
	public static boolean ifEnd(int[] order){
		int length = order.length;
		for(int i=0;i<length;i++){
			if(order[i]==0)return true;
		}
		return false;
	}
	public static int getRed(int[] Order,int[] redMetric){
		int length = Order.length;
		for(int i=0;i<length*2+1;i++)
			redMetric[i]=0;
		redMetric[length]=1;
		int index = length;
		for(int i=0;i<length;i++){
			if(Order[i]==0){
				index-=1;
				if(redMetric[index]==0)redMetric[index]=1;
			}else{
				index+=1;
				if(redMetric[index]==0)redMetric[index]=1;
			}
		}
		int sum =0;
		for(int i=0;i<length*2+1;i++)
			if(redMetric[i]==1)sum++;
		//System.out.println("temp:"+sum);
		return sum;
	}
}