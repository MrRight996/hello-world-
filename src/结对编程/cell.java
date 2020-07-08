package 结对编程;


/*1、周围细胞存活数大于3或小于2时，该细胞死亡，为3时存活，为2时状态不变
2、该程序要分多个模块，（逻辑、计时、棋盘）
3、每个人要角色互换2次（大概是编程的人和讲道理的人）
4、4点半发讨论截图
*/
public class cell  {
 int Status; //0为死亡 1为存活-1表示边界
 int LiveCellnumber;//周围活细胞数量

//构造函数
 cell() 
 {
 	this.Status=0;
 	this.LiveCellnumber=0;
 }
//赋初值
 void setStatus(int NewStatues)
 {
	 this.Status=NewStatues;
 } 
 void setLiveCellnumber(int LiveCellnumber)
 {
	 this.LiveCellnumber=LiveCellnumber;
 }
//将计算各cell的周围死细胞活细胞数量
static cell[][]  statis(cell[][] arr,int n)
{
	 //遍历全部的细胞
 for (int i=1;i<n - 1;i++)
 {
 	 for(int j=1;j<n-1;j++)
 	    {
 		 //遍历细胞cell[i][j]周围的细胞,统计活细胞的个数
 	    		for(int i1=i-1;i1<=i+1;i1++)
 	    	    {
 	    			for(int i2=j-1;i2<=j+1;i2++)
     	    	    {
 	    				//遇到自己跳过
 	    				if(i1==i&&i2==j)
 	    				{
 	    				continue;	
 	    				}
 	    				//遇到边界跳过
 	    				if(arr[i1][i2].Status==-1)
       	    	    {
 	    					continue;
       	    	     }
 	    				//遇到死细胞跳过
     	    	        if(arr[i1][i2].Status==0)
     	    	       {
     	    	    	   
     	    	    	   continue;
     	    	        }
     	    	        //遇到活细胞将记录
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
//边界初始化
 static cell[][]  setarea(cell[][] arr,int n)
{
	  for(int i=0;i<n;i++)
	    {
		  //将边界的Status设为-1,遇到直接跳过
	    	arr[0][i].setStatus(-1);
	    	arr[i][0].setStatus(-1);
	    	arr[n-1][i].setStatus(-1);
	    	arr[i][n-1].setStatus(-1);
	    }
	  return arr;
}
//将死细胞数和活细胞数都变成0（初始化）
 static cell[][]  first(cell[][] arr,int n)
{
	 //遍历全部的细胞
	 for(int i=1;i<n-1;i++)
	    {
	    	 for(int j=1;j<n-1;j++)
	    	    {
	    		 arr[i][j].setLiveCellnumber(0);
	    	    }
	    }
	 return arr;
}
//细胞的状态进行变化	
 static cell[][]  change(cell[][] arr,int n)
{

	for(int i=1;i<n-1;i++) 
	{
		for(int j=1;j<n-1;j++)
		{
			//周围活细胞的数目为3则变为活
			if(arr[i][j].LiveCellnumber==3)
			{
				arr[i][j].Status=1;
			}
			//周围活细胞的数目为2则保持不变
			else if(arr[i][j].LiveCellnumber==2)
			{
				continue;
			}
			//其他的情况就为死亡
			else
			{
				arr[i][j].Status=0;
			}
		}
	}
	return arr;
}
//随机生成
 static cell[][] RAD(cell[][] arr,int n)
 {
	    for(int i=1;i<n-1;i++)
	    {
	    	for(int j=1;j<n-1;j++)
	    	{
	    		//生成随机数，将细胞的初始状态随机地设置为生活着死
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




