package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version 创建时间：2019年4月8日 下午9:39:00
* 实现get方法，根据键对象获得对应值对象
*/
public class MyHashMap03 {
	Node2[] table;  //位桶数组
	int size;  //存放的键值对的个数
	
	public MyHashMap03() {
		table = new Node2[16];  //长度一般定义成2的整数次幂
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		//遍历bucket数组
		for(int i=0;i<table.length;i++) {
			Node2 temp = table[i];
			//遍历链表
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	public Object get(Object key) {
		int hash = myHash(key.hashCode(),table.length);
		Object value = null;
		if(table[hash]!=null) {
			Node2 temp = table[hash];
			while(temp!=null) {
				if(temp.key.equals(key)) { //如果想等，则说明找到了键值对，返回相应的value
					value = temp.value;
					break;
				}else {
					temp = temp.next;
				}
			}
		}
		return value;
	}
	
	public void put(Object key,Object value) {
		
		//如果要完善，还需要考虑数组扩容的问题
		
		//定义了新的节点对象
		Node2 newNode = new Node2();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];
		
		Node2 iterLast = null; //正在遍历的最后一个元素
		boolean keyRepeat = false;
		if(temp==null) {
			//此处数组元素为空则直接把新节点放进去
			table[newNode.hash]=newNode;
			size++;
		}else {
			//此处数组元素不为空则遍历对应链表
			while(temp!=null) {
				//判断key如果重复，则覆盖
				if(temp.key.equals(key)) {
					keyRepeat = true;
					temp.value = value;  //只是覆盖value即可，其他的值(hash,key,next)保持不变
					break;
				}else {
					//key不重复,则遍历下一个
					iterLast = temp;
					temp = temp.next;
				}
			}
			if(!keyRepeat) {  //没有发生key重复的情况，则添加到链表最后
				iterLast.next = newNode;
				size++;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		MyHashMap03 m = new MyHashMap03();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		m.put(53, "gg");
		m.put(69, "hh");
		m.put(85, "kk");
		System.out.println(m);
//		for(int i=10;i<100;i++) {
//			System.out.println(i+"---"+myHash(i,16));
//		}
		
		System.out.println(m.get(85));
	}
	
	public static int myHash(int v,int length) {
		//System.out.println("hash in myHash:"+(v&(length-1)));  //直接位运算，效率高
		//System.out.println("hash in myHash:"+(v%(length-1)));  //取模运算，效率低
		return v&(length-1);
	}
}
