package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version 创建时间：2019年4月4日 下午7:57:34
* 增加remove方法
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
			throw new RuntimeException("容器的容量不能为负数");
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

		//什么时候扩容
		if(size == elementDate.length) {
			//怎么扩容
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
		//索引合法判断[0,size) 
		if(index<0||index>size-1) {
			//不合法
			throw new RuntimeException("索引不合法："+index);
		}
	}
	
	public void remove(E element) {
		//element，将它和所有元素挨个比较，获得第一个比较为true的，返回
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {   //容器中所有的比较操作都是用的equals而不是==
				
				//将该元素从此处移除
				remove(i);
			}
		}
	}
	
	public void remove(int index) {
		
		//删除前：a,b,c,d,e,f,g,h
		//删除后：a,b,c,e,f,g,h
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
