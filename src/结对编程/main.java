package ��Ա��;
import java.util.Scanner;

import ��Ա��.cell;
public class main {
	public static void main(String[] args) {
		 System.out.println("���������������̴�Сn");
		  	int n;
		  	Scanner scanner = new Scanner(System.in);
		  	n=scanner.nextInt();
		  	scanner.close();
		  	n=n+2;
    cell[][] arr=new cell [n][n];//����һ��߽�
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
