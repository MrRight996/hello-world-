package ½á¶Ô±à³Ì;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class cellTest {
	static cell[][] arr=new cell[5][5];
	@Before
	public  void setUpBeforeClass() throws Exception {
		for(int i=0;i<5;i++)
		{
			for(int j = 0 ; j < 5 ; j++)
			{
				arr[i][j] = new cell();
			}

		}
	}

	@Test
	public void testCell() {
		assertEquals(0,arr[2][1].Status);
	
	}

	@Test
	public void testSetStatus() {
		arr[0][0].setStatus(0);
		assertEquals(0,arr[0][0].Status);
	}

	@Test
	public void testSetLiveCellnumber() {
		arr[0][0].setLiveCellnumber(0);
		assertEquals(0,arr[0][0].LiveCellnumber);
	}

	@Test
	public void testStatis() {
		arr[1][1].setStatus(1);
		arr[1][2].setStatus(1);
		arr[1][3].setStatus(1);
		arr=cell.statis(arr, 5);
		assertEquals(3,arr[2][2].LiveCellnumber);
	}

	@Test
	public void testSetarea() {
		arr=cell.setarea(arr, 5);
		assertEquals(-1,arr[0][3].Status);
	}

	@Test
	public void testFirst() {
		arr=cell.first(arr, 5);
		assertEquals(0,arr[2][3].LiveCellnumber);
	}

	@Test
	public void testChange() {
		arr[1][2].setLiveCellnumber(1);
		assertEquals(0,arr[1][2].Status);
	}

}
