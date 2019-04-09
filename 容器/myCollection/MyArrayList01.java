package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version ����ʱ�䣺2019��4��4�� ����7:57:34
* �Զ���ʵ��һ��ArrayList�����ײ�ԭ��
*/
public class MyArrayList01 {

	private Object[] elementDate;
	private int size;
	
	private static final int DEFALT_CAPCITY = 10;
	
	public MyArrayList01(){
		elementDate = new Object[DEFALT_CAPCITY];
	}
	
	public MyArrayList01(int capacity) {
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
	
	public void add(Object obj) {
		elementDate[size++] = obj;
	}
	
	public static void main(String[] args) {
		MyArrayList01 s1 = new MyArrayList01(20);
		s1.add("aa");
		s1.add("bb");
		System.out.println(s1);
	}
}
