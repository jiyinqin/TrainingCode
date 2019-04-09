package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version ����ʱ�䣺2019��4��4�� ����7:57:34
* ����remove����
*/
public class MyArrayList05<E> {

	private Object[] elementDate;
	private int size;
	
	private static final int DEFALT_CAPCITY = 10;
	
	public MyArrayList05(){
		elementDate = new Object[DEFALT_CAPCITY];
	}
	
	public MyArrayList05(int capacity) {
		
		if(capacity<0) {
			throw new RuntimeException("��������������Ϊ����");
		}else if(capacity == 0) {
			elementDate = new Object[DEFALT_CAPCITY];
		}else {
			elementDate = new Object[capacity];
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0?true:false;
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
	
	public void remove(E element) {
		//element������������Ԫ�ذ����Ƚϣ���õ�һ���Ƚ�Ϊtrue�ģ�����
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {   //���������еıȽϲ��������õ�equals������==
				
				//����Ԫ�شӴ˴��Ƴ�
				remove(i);
			}
		}
	}
	
	public void remove(int index) {
		
		//ɾ��ǰ��a,b,c,d,e,f,g,h
		//ɾ����a,b,c,e,f,g,h
		int numMoved = elementDate.length-index-1;
		if(numMoved>0) {
			System.arraycopy(elementDate, index+1, elementDate, index, numMoved);
		}
			elementDate[--size] = null;
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
		MyArrayList05 s1 = new MyArrayList05(20);
		
		for(int i=0;i<40;i++) {
			s1.add("CodeCock"+i);
		}
		
		s1.set("dddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(10));
		
		s1.remove(3);
		s1.remove("CodeCock11");
		System.out.println(s1);
		System.out.println(s1.size);
		System.out.println(s1.isEmpty());
	}
}
