package cn.sxt.test;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author Administrator
 *
 */
public class PrintFileTree {
	public static void main(String[] args) {
		File  f = new File("C:\\Python400集（第一季）【北京尚学堂·百战程序员】");
		
		printFile(f,0);
	}
	
	static void  printFile(File  file, int  level){
		
		//输出层数
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] files = file.listFiles();
			
			for(File  temp: files){
				printFile(temp,level+1);
			}
			
		}
	}
	
}
