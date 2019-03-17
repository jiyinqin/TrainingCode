package cn.sxt.array2;

import java.util.Arrays;

/**
 * 测试java.util.Arrays工具类的使用
 * @author Administrator
 *
 */
public class TestArrays {
	public static void main(String[] args) {
		
		int[]  a = {100,20,30,5,150,80,200};
		
		System.out.println(a);
		
		System.out.println(Arrays.toString(a));  
		Arrays.sort(a); 
		System.out.println(Arrays.toString(a));  
		
		System.out.println(Arrays.binarySearch(a, 30));
		
		
		
	}
}
