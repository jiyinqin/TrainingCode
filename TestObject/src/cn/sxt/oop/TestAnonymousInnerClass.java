package cn.sxt.oop;

/**
 * 测试匿名内部类
 * @author Administrator
 *
 */
public class TestAnonymousInnerClass {
	
	public static  void  test01(AA a){
		System.out.println("###########");
		a.aa();
	}
	
	public static void main(String[] args) {
		TestAnonymousInnerClass.test01(new AA(){

			@Override
			public void aa() {
				System.out.println("TestAnonymousInnerClass.main(...).new AA() {...}.aa()");
			}
			
		});
		
	}

}


interface  AA {
	void  aa();
}

