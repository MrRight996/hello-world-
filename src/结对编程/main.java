package 结对编程;
import java.util.Scanner;

import 结对编程.cell;
public class main {
	public static void main(String[] args) {
		 System.out.println("请输入正方形棋盘大小n");
		  	int n;
		  	Scanner scanner = new Scanner(System.in);
		  	n=scanner.nextInt();
		  	scanner.close();
		  	n=n+2;
    cell[][] arr=new cell [n][n];//加了一层边界
    for(int i=0;i<n;i++)
    {
    	for(int j=0;j<n;j++)
        {
        	arr[i][j]=new cell();
        }
    }
    Myjframe p= new Myjframe(arr,n);
    p.start();
  	}
}
