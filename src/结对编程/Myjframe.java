package 结对编程;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Myjframe extends JFrame implements ActionListener {
	 cell[][] arr;
	 int n;
	 Panel[][] p;
	 Myjframe(cell[][] arr,int n)
	 {
		 this.arr=arr;
		 this.n=n;
		 p=new Panel[n][n];
		 for(int i=0;i<n;i++)
		    {
		    	for(int j=0;j<n;j++)
		        {
		        	p[i][j]=new Panel();
		        	p[i][j].setBackground(Color.WHITE);
		        }
		    }
	 }
	void start()
	 {
			JFrame frame=new JFrame("game of lives");

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.setBounds(200, 50, 1500, 900);
			frame.setVisible(true);
			frame.setLayout(null);

			Panel p1=new Panel();

			Panel p2=new Panel();

			p1.setBounds(0, 0, 1500, 700);
			p1.setLayout(new GridLayout(n - 2, n - 2)) ;
			arr=cell.first(arr,n);
			arr=cell.setarea(arr, n);
			for(int i = 1 ; i < n - 1 ; i++ ) 
			{
				for(int j = 1 ; j < n - 1 ; j++ ) 
				{
					p1.add(p[i][j]);
				}
			} 
		    p2.setBounds(0, 700, 1500, 200);
		    p2.setBackground(Color.black);
		    Button button1=new Button("随机生成");
		    Button button2=new Button("变换一次");
		    Button button3=new Button("清除");
		    p2.setLayout(new GridLayout(1,3));
		    button1.addActionListener(this);
		    button2.addActionListener(this);
		    button3.addActionListener(this);   
		    
		    p2.add(button1);
		    p2.add(button2);
		    p2.add(button3);
		    frame.add(p2);
		    frame.add(p1);
	 }
	 public void changing(cell [][] arr,int n)
	 {
	     for(int i=1;i<n-1;i++ ) 
			{
				for(int j=1;j<n-1;j++ ) 
				{
					
					if (arr[i][j].Status == 1)
					{
						p[i][j].setBackground(Color.RED);
						}
					else if (arr[i][j].Status==0)
					{
						p[i][j].setBackground(Color.GREEN);
					}
				}
			} 
	 }
	 @Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()=="随机生成")
				{
				this.arr=cell.RAD(arr,n);
				changing(arr,n);
			}
			else if(e.getActionCommand()=="变换一次")
				{
				this.arr=cell.first(arr,n);
				this.arr=cell.statis(arr,n);
				this.arr=cell.change(arr,n);
				changing(arr,n);
				}
			else if(e.getActionCommand()=="清除")
			{
				for(int i=0;i<n;i++)
			    {
			    	for(int j=0;j<n;j++)
			        {
			        	p[i][j].setBackground(Color.WHITE);
			        	arr[i][j].setStatus(0);
			        }
			    }
			}
		}
}
