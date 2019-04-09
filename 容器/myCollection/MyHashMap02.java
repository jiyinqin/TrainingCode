package cn.CodeCock.myCollection;
/**
* @author CodeCock
* @version ����ʱ�䣺2019��4��8�� ����9:39:00
* ʵ��toString����������鿴Map�еļ�ֵ����Ϣ
*/
public class MyHashMap02 {
	Node2[] table;  //λͰ����
	int size;  //��ŵļ�ֵ�Եĸ���
	
	public MyHashMap02() {
		table = new Node2[16];  //����һ�㶨���2����������
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		//����bucket����
		for(int i=0;i<table.length;i++) {
			Node2 temp = table[i];
			//��������
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	public void put(Object key,Object value) {
		//�������µĽڵ����
		Node2 newNode = new Node2();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];
		
		Node2 iterLast = null; //���ڱ��������һ��Ԫ��
		boolean keyRepeat = false;
		if(temp==null) {
			//�˴�����Ԫ��Ϊ����ֱ�Ӱ��½ڵ�Ž�ȥ
			table[newNode.hash]=newNode;
			size++;
		}else {
			//�˴�����Ԫ�ز�Ϊ���������Ӧ����
			while(temp!=null) {
				//�ж�key����ظ����򸲸�
				if(temp.key.equals(key)) {
					keyRepeat = true;
					temp.value = value;  //ֻ�Ǹ���value���ɣ�������ֵ(hash,key,next)���ֲ���
					break;
				}else {
					//key���ظ�,�������һ��
					iterLast = temp;
					temp = temp.next;
				}
			}
			if(!keyRepeat) {  //û�з���key�ظ������������ӵ��������
				iterLast.next = newNode;
				size++;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		MyHashMap02 m = new MyHashMap02();
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
	}
	
	public static int myHash(int v,int length) {
		//System.out.println("hash in myHash:"+(v&(length-1)));  //ֱ��λ���㣬Ч�ʸ�
		//System.out.println("hash in myHash:"+(v%(length-1)));  //ȡģ���㣬Ч�ʵ�
		return v&(length-1);
	}
}
