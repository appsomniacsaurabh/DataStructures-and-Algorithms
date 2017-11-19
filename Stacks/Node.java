package Stacks;

public class Node<T> {
	
	public T data;
	public Node next;
	
	public Node(T data){
		this.data = data;
		this.next = null;
	}
	
	public Node(T data, Node next){
		this.data = data;
		this.next = next;
		
	}

}
