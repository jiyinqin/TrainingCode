package cn.sxt.oop;

/**
 * 测试字符串类的基本用法
 * @author Administrator
 *
 */
public class TestString {
	public static void main(String[] args) {
		String  str = "abc";
		String str2 = new String("def");
		String str3 = "abc"+"defgh";
		String str4 = "18"+19;			//不是加法，是字符串连接符。
		System.out.println(str4);
		
		System.out.println("##############");
		String  str10 = "gaoqi";
		String  str11 = "gaoqi";
		String  str12 = new String("gaoqi");
		
		
		System.out.println(str10 == str11);
		System.out.println(str12 == str11);		//str11和str12不是同一个对象。
		
		
		//通常比较字符串时，使用equals
		System.out.println(str12.equals(str11));
		
		
		
		
	}
}
