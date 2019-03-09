package cn.sxt.oop;

/**
 * 抽象类的意义就在于：为子类提供统一的、规范的模板。子类必须实现相关的抽象方法！ 
 * @author Administrator
 *
 */
public abstract  class Animal {
	
	//第一：没有实现。第二：子类必须实现。
	abstract  public  void   shout();
	
	public void run(){
		System.out.println("跑啊跑！");
	}
	
	public static void main(String[] args) {
		Animal   a = new Dog();
		
//		Integer  i;
		
	}
	
}


class  Dog extends   Animal {

	@Override
	public void shout() {
		System.out.println("汪汪汪！");
	}
	
}