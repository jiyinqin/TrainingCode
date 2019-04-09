package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version ����ʱ�䣺2019��4��4�� ����7:57:34
* ����set��get����
* ��������߽�ļ��
*/
public class MyArrayList04<E> {

	private Object[] elementDate;
	private int size;
	
	private static final int DEFALT_CAPCITY = 10;
	
	public MyArrayList04(){
		elementDate = new Object[DEFALT_CAPCITY];
	}
	
	public MyArrayList04(int capacity) {
		
		if(capacity<0) {
			throw new RuntimeException("��������������Ϊ����");
		}else if(capacity == 0) {
			elementDate = new Object[DEFALT_CAPCITY];
		}else {
			elementDate = new Object[capacity];
		}
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
	
	public E get(int index) {
		
		checkRange(index);
		
		return (E)elementDate[index];
	}
	
	public void set(E element,int index) {
		
		checkRange(index);
		
		elementDate[index]=element;
		
	}
	
	public void checkRange(int index) {
		//�����Ϸ��ж�[0,size) 
		if(index<0||index>size-1) {
			//���Ϸ�
			throw new RuntimeException("�������Ϸ���"+index);
		}
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
		MyArrayList04 s1 = new MyArrayList04(20);
		
		for(int i=0;i<40;i++) {
			s1.add("CodeCock"+i);
		}
		
		s1.set("dddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(10));
	}
}
