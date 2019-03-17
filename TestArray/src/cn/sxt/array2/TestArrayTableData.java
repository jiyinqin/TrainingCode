package cn.sxt.array2;

import java.util.Arrays;

/**
 * 测试数组存储表格数据
 * @author Administrator
 *
 */
public class TestArrayTableData {
	public static void main(String[] args) {
		Object[]  emp1 = {1001,"高淇",18,"讲师","2006.6.6"};
		Object[]  emp2 = {1002,"高2淇",19,"程序员","2016.6.6"};
		Object[]  emp3 = {1003,"高3淇",22,"销售","2026.6.6"};
		
		Object[][] tableData = new Object[3][];
		tableData[0] = emp1;
		tableData[1] = emp2;
		tableData[2] = emp3;
		
		for(Object[] temp: tableData){
			System.out.println(Arrays.toString(temp));
		}
		
		
	}
}
