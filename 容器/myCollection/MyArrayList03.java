package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version ����ʱ�䣺2019��4��4�� ����7:57:34
* ������������
*/
public class MyArrayList03<E> {

	private Object[] elementDate;
	private int size;
	
	private static final int DEFALT_CAPCITY = 10;
	
	public MyArrayList03(){
		elementDate = new Object[DEFALT_CAPCITY];
	}
	
	public MyArrayList03(int capacity) {
		elementDate = new Object[capacity];
	}
	
	public void add(E element) {

		//ʲôʱ������
		if(size == elementDate.length) {
			//��ô����
			Object[] newArray = new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);	
			elementDate = newArray;	
		}	
		elementDate[size++] = element;	
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
	
	public static void main(String[] args) {
		MyArrayList03 s1 = new MyArrayList03(20);
		
		for(int i=0;i<40;i++) {
			s1.add("CodeCock"+i);
		}
		
		System.out.println(s1);
	}
}
