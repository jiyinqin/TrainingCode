package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version 创建时间：2019年4月4日 下午7:57:34
* 增加泛型
*/
public class MyArrayList02<E> {

	private Object[] elementDate;
	private int size;
	
	private static final int DEFALT_CAPCITY = 10;
	
	public MyArrayList02(){
		elementDate = new Object[DEFALT_CAPCITY];
	}
	
	public MyArrayList02(int capacity) {
		elementDate = new Object[capacity];
	}

	@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("[");
			for(int i=0;i<size;i++) {
				sb.append(elementDate[i]+",");
			}
			sb.setCharAt(sb.length()-1, ']');
			return sb.toString();
		}
	
	public void add(E element) {
		elementDate[size++] = element;
	}
	
	public static void main(String[] args) {
		MyArrayList02 s1 = new MyArrayList02(20);
		s1.add("aa");
		s1.add("bb");
		System.out.println(s1);
	}
}
