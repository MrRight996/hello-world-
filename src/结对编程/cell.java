package ��Ա��;


/*1����Χϸ�����������3��С��2ʱ����ϸ��������Ϊ3ʱ��Ϊ2ʱ״̬����
2���ó���Ҫ�ֶ��ģ�飬���߼�����ʱ�����̣�
3��ÿ����Ҫ��ɫ����2�Σ�����Ǳ�̵��˺ͽ�������ˣ�
4��4��뷢���۽�ͼ
*/
public class cell  {
 int Status; //0Ϊ���� 1Ϊ���-1��ʾ�߽�
 int LiveCellnumber;//��Χ��ϸ������

//���캯��
 cell() 
 {
 	this.Status=0;
 	this.LiveCellnumber=0;
 }
//����ֵ
 void setStatus(int NewStatues)
 {
	 this.Status=NewStatues;
 } 
 void setLiveCellnumber(int LiveCellnumber)
 {
	 this.LiveCellnumber=LiveCellnumber;
 }
//�������cell����Χ��ϸ����ϸ������
static cell[][]  statis(cell[][] arr,int n)
{
	 //����ȫ����ϸ��
 for (int i=1;i<n - 1;i++)
 {
 	 for(int j=1;j<n-1;j++)
 	    {
 		 //����ϸ��cell[i][j]��Χ��ϸ��,ͳ�ƻ�ϸ���ĸ���
 	    		for(int i1=i-1;i1<=i+1;i1++)
 	    	    {
 	    			for(int i2=j-1;i2<=j+1;i2++)
     	    	    {
 	    				//�����Լ�����
 	    				if(i1==i&&i2==j)
 	    				{
 	    				continue;	
 	    				}
 	    				//�����߽�����
 	    				if(arr[i1][i2].Status==-1)
       	    	    {
 	    					continue;
       	    	     }
 	    				//������ϸ������
     	    	        if(arr[i1][i2].Status==0)
     	    	       {
     	    	    	   
     	    	    	   continue;
     	    	        }
     	    	        //������ϸ������¼
     	    	        if(arr[i1][i2].Status==1)
     	    	        {
     	    	    	  arr[i][j].LiveCellnumber++;
     	    	         }
     	    	    }
     	    	    }
 	    	}
   }
 return arr;
}
//�߽��ʼ��
 static cell[][]  setarea(cell[][] arr,int n)
{
	  for(int i=0;i<n;i++)
	    {
		  //���߽��Status��Ϊ-1,����ֱ������
	    	arr[0][i].setStatus(-1);
	    	arr[i][0].setStatus(-1);
	    	arr[n-1][i].setStatus(-1);
	    	arr[i][n-1].setStatus(-1);
	    }
	  return arr;
}
//����ϸ�����ͻ�ϸ���������0����ʼ����
 static cell[][]  first(cell[][] arr,int n)
{
	 //����ȫ����ϸ��
	 for(int i=1;i<n-1;i++)
	    {
	    	 for(int j=1;j<n-1;j++)
	    	    {
	    		 arr[i][j].setLiveCellnumber(0);
	    	    }
	    }
	 return arr;
}
//ϸ����״̬���б仯	
 static cell[][]  change(cell[][] arr,int n)
{

	for(int i=1;i<n-1;i++) 
	{
		for(int j=1;j<n-1;j++)
		{
			//��Χ��ϸ������ĿΪ3���Ϊ��
			if(arr[i][j].LiveCellnumber==3)
			{
				arr[i][j].Status=1;
			}
			//��Χ��ϸ������ĿΪ2�򱣳ֲ���
			else if(arr[i][j].LiveCellnumber==2)
			{
				continue;
			}
			//�����������Ϊ����
			else
			{
				arr[i][j].Status=0;
			}
		}
	}
	return arr;
}
//�������
 static cell[][] RAD(cell[][] arr,int n)
 {
	    for(int i=1;i<n-1;i++)
	    {
	    	for(int j=1;j<n-1;j++)
	    	{
	    		//�������������ϸ���ĳ�ʼ״̬���������Ϊ��������
	    		if(Math.random()*10<=5) 
	    		{
	    			arr[i][j].setStatus(1);
	    		}
	    		else {
	    			arr[i][j].setStatus(0);
	    		}
	    	}
	    }
	    return arr;
 }
}




