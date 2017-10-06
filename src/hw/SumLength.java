package hw;
import java.util.Scanner;

public class SumLength {
	public static void main(String[] args){
		int n;//�߶���Ŀ
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double[][] lines = new double[n][2];//���ڱ����߶ε���ֹ��
		for(int i=0;i<n;i++){
			lines[i][0] = sc.nextDouble();
			lines[i][1] = sc.nextDouble();
		}
		sc.close();
		//��������
		/*System.out.println(n);
		for(int i=0;i<n;i++){
			System.out.println(lines[i][0]+"|"+lines[i][1]);
		}*/
		double[] sort = new double[n];
		for(int i=0;i<n;i++)
			sort[i] = lines[i][1];
		sortLines(lines,sort);//��������Ӵ�С����
		
		//��������
		/*System.out.println(n);
		for(int i=0;i<n;i++){
			System.out.println(lines[i][0]+"|"+lines[i][1]);
		}*/
		double result = getSumLength(lines);
		System.out.println(result);
	}
	public static void sortLines(double[][] lines,double[] sort){//�����߶ΰ�����������
		int n = sort.length;
		double key = sort[0];
		double key_0 = lines[0][0];
		double key_1 = lines[0][1];
		for(int j = 1,i = 0;j < n;j++){
			key = sort[j];
			key_0 = lines[j][0];
			key_1 = lines[j][1];
			i = j - 1;
			while(i >= 0 && sort[i] < key){
				sort[i+1] = sort[i];
				lines[i+1][0] = lines[i][0];
				lines[i+1][1] = lines[i][1];
				i = i - 1;
			}
			sort[i+1] = key;
			lines[i+1][0] = key_0;
			lines[i+1][1] = key_1;
		}
	}
	public static double getSumLength(double[][] lines){//���㸲�ǵĳ���
		int n = lines.length;
		double sum = lines[0][1]-lines[0][0];
		double[] temp = lines[0];
		for(int i=1;i<n;i++){
			if(lines[i][1]>temp[0]){
				if(lines[i][0]<temp[0]){
					sum += lines[i][1] - lines[i][0];
					sum -= lines[i][1] = temp[0];
					temp[0] = lines[i][0];
				}
			}else{
				sum += lines[i][1] - lines[i][0];
				temp = lines[i];
			}
		}
		return sum;
	}
}
