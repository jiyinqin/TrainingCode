package cn.CodeCock.myCollection;

import javax.management.RuntimeErrorException;

/**
* @author CodeCock
* @version 创建时间：2019年4月8日 下午4:27:29
* 增加remove方法
*/
public class MyLinkedList03 {

	private Node first;
	private Node last;
	private int size;
		
	public void remove(int index) {
		Node temp = getNode(index);
		if(temp!=null) {
			Node up = temp.previous;
			Node down = temp.next;
			if(up!=null) {
				up.next = down;
			}
			if(down!=null) {
				down.previous = up;
			}
			//被删除的元素是第一个元素时
			if(index==0) {
				first=down;
			}
			//被删除的元素是最后一个元素时
			if(index==size-1) {
				last=up;
			}
			size--;
		}
	}
	
	public Object get(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引数字不合法："+index);
		}	
		Node temp = getNode(index);
		return temp!=null?temp.element:null;
	}
	
	public Node getNode(int index) {
		Node temp = null;
		if(index<=(size>>1)) {  //size>>1相当于除以2
			temp = first;
			for(int i=0;i<index;i++) {
				temp = temp.next;
			}
		}else {
			temp = last;
			for(int i=size-1;i>index;i--) {
				temp = temp.previous;
			}
		}
		return temp;
	}
	
	public void add(Object obj) {
		Node node = new Node(obj);
		
		if(first==null) {
			node.previous=null;
			node.next=null;
			first=node;
			last=node;
		}else {
			node.previous=last;
			node.next=null;
			last.next=node;
			last=node;
		}
		size++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyLinkedList03 list = new MyLinkedList03();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
	}
	
}
