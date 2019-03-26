package cn.sxt.mycollection;

/**
 * 自定义一个HashMap
 * 实现get方法，根据键对象获得对应的值对象
 * @author 高淇
 *
 */
public class SxtHashMap04<K,V> {
	
	Node3[]  table;    //位桶数组。bucket  array
	int size;				//存放的键值对的个数
	
	public SxtHashMap04() {
		table = new Node3[16];    //长度一般定义成2的整数幂
	}
	
	
	public  V  get(K  key){
		
		int  hash = myHash(key.hashCode(), table.length);
		V value = null; 
		
		if(table[hash]!=null){
			Node3  temp = table[hash];
			
			while(temp!=null){
				
				if(temp.key.equals(key)){   //如果相等，则说明找到了键值对，返回相应的value
					value = (V)temp.value;
					break;
				}else{
					temp = temp.next;
				}
			}
			
		}
		
		return value;
	}
	
	
	public  void   put(K key,  V   value){
		
		//如果要完善，还需要考虑数组扩容的问题！！！
		
		//定义了新的节点对象
		Node3    newNode = new Node3();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key =  key;
		newNode.value = value;
		newNode.next = null;
		
		Node3 temp = table[newNode.hash];
		
		Node3  iterLast = null;  //正在遍历的最后一个元素
		boolean  keyRepeat = false;  
		if(temp==null){
			//此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
			size++;
		}else{
			//此处数组元素不为空。则遍历对应链表。。
			while(temp!=null){
				
				//判断key如果重复，则覆盖
				if(temp.key.equals(key)){
					keyRepeat = true;
					temp.value =  value;  //只是覆盖value即可。其他的值(hash,key,next)保持不变。
					
					break;
					
				}else{
					//key不重复，则遍历下一个。
					iterLast = temp;
					temp = temp.next;
					
				}
			}
			
			if(!keyRepeat){   //没有发生key重复的情况，则添加到链表最后。
				iterLast.next = newNode;
				size++;
			}
			
		}
		
		
		
	}

	
	@Override
	public String toString() {
		//{10:aa,20:bb}
		StringBuilder  sb = new StringBuilder("{");
		
		//遍历bucket数组
		for(int i=0;i<table.length;i++){
			Node3  temp = table[i]; 
			
			//遍历链表
			while(temp!=null){
				sb.append(temp.key+":"+temp.value+",");
				temp  = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}'); 
		return sb.toString();
		
	}
	
	
	public static void main(String[] args) {
		SxtHashMap04<Integer,String>  m = new SxtHashMap04<>();
		m.put(10, "aa");
		m.put(20, "bb");
		
		System.out.println(m.get(85));  
		
	}
	
	
	public static  int  myHash(int  v, int length){
//		System.out.println("hash in myHash:"+(v&(length-1)));		//直接位运算，效率高
//		System.out.println("hash in myHash:"+(v%(length-1)));		//取模运算，效率低
		return  v&(length-1);
	}
	
	
}


