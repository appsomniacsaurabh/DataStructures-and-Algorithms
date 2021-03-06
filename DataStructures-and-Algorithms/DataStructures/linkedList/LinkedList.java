package linkedList;
import java.util.*;

public class LinkedList {
	
	public static Scanner s;
	public static void main(String[] args){
		
	    s = new Scanner(System.in);
		Node head = takeInput();
		printOutput(head);
		
		Node tail = findTail(head);
		System.out.println("The tail is:  "+ tail.data);
		
		System.out.println("the length is: "+ length(head, 0));
		
//		if(checkPallindrome(head)){
//			
//			System.out.println("The list is a Pallindrome");
//		}else{
//			
//			System.out.println("The is Not Pallindrome");
//		}
		
		
		System.out.println("Enter the position you want to insert at: ");
		int insertPosition = s.nextInt();
		Node newHeadInserted = insertAtIth(head, head, insertPosition, 0);
		System.out.println("LinkedList after insertion: ");
		printOutput(newHeadInserted);
		
		System.out.println("Enter the positions you want to swap the nodes at: ");
		int swap_pos_1 = s.nextInt();
		int swap_pos_2 = s.nextInt();
		Node newHeadSwapped = swapNodes(head, swap_pos_1, swap_pos_2);
		System.out.println("After being swapped: ");
		printOutput(newHeadSwapped);
		
		System.out.println("After reversing the List:  ");
		Node rev_head = reverse(head, head, head.next);
		printOutput(rev_head);

		System.out.println("Enter the position of the node you want to delete");
		int deletePosition = s.nextInt();
		Node newHeadDeleted = deleteAtIth(head,head, deletePosition, 0);
		System.out.println("LinkedList after deletion: ");
		printOutput(newHeadDeleted);
//			
	}
	
	public static void printOutput(Node head){
		
		if(head==null){
			return;
		}
		System.out.println(head.data);
		printOutput(head.next);	
	}
	
	public static int length(Node head, int count){
		
		if(head==null){
			return count;
		}
		return length(head.next, ++count);	
	}
	
	
	public static Node findTail(Node head){
		
		if(head.next == null){
			return head;
		}
		return findTail(head.next);
		
	}
	
	public static boolean checkPallindrome(Node head){

		int length = length(head, 0);
		Node first_part_head = head, second_part_head = head;
		if(length%2==0){
			
			for(int i=0; i<length-2;i++){
				second_part_head = second_part_head.next;
			}			
		}
		
		Node rev_head = reverse(head, second_part_head, second_part_head.next);
		
		if(checkPallindromeAfterRev(first_part_head, rev_head)){
			
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkPallindromeAfterRev(Node first_part_head, Node rev_head){
		
		if(rev_head == null || first_part_head ==null){
			return true;
		}
		
		if(first_part_head.data!= rev_head.data){
			return false;
		}else{
			
			return checkPallindromeAfterRev(first_part_head.next, rev_head.next);
		}
		
	}
	
	public static Node reverse(Node head, Node prev, Node present){
		
		if(prev.next==null || present==null){
			head.next=null;
			return prev;
		}
		
		Node temp_prev = present;
		Node temp_present = present.next;
		present.next = prev;
		return reverse(head, temp_prev, temp_present);
	}
	
	public static Node swapNodes(Node head, int swap_pos_1, int swap_pos_2){
		
		Node swap_1 = head, swap_2 = head;
		Node prev_1 = head;
		Node prev_2 = head;
		
		for(int i=0;i<swap_pos_1;i++){
			
			swap_1 = swap_1.next;
		}
		
		for(int i=0;i<swap_pos_2;i++){
			
			swap_2 = swap_2.next;
		}
		
		
		for(int i=0;i<swap_pos_1-1;i++){
			prev_1 = prev_1.next;
		}
		
		for(int i=0;i<swap_pos_2-1 ;i++){
			
			prev_2 = prev_2.next;
		}
		
		Node temp_2 = swap_2.next;
		prev_1.next = swap_2;
		swap_2.next = swap_1.next;
		swap_1.next = temp_2;
		prev_2.next = swap_1;
	
		return head;
	}
	
	public static Node insertAtIth(Node head, Node temp, int i, int prev){
		
		if(head == null || temp == null){
			return head;
		}
		
		if(i==0){
			
			System.out.println("Enter the element you want to insert: ");
			int element = s.nextInt();
			Node node = new Node(element);
			node.next = temp;
			head = node;
			
			return head;
			
		}else{
			
			if(i-1 == prev){
			
				System.out.println("Enter the element you want to insert: ");
				int element = s.nextInt();
				Node node = new Node(element);
				node.next = temp.next;
				temp.next = node;
			
				return head;
				
			}
		}
		
		return insertAtIth(head, temp.next, i, ++prev);
	}
	
	public static Node deleteAtIth(Node head, Node temp, int i, int prev){
		
		if(head == null || temp==null){
			return head;
		}
		
		if(i==0){
			
			head = head.next;
			return head;
		}else{
		
			if(i-1==prev){
				temp.next = temp.next.next;
				return head;
			}
		}
		
		return deleteAtIth(head, temp.next, i, ++prev);
		
	}
	
	public static Node takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the head: ");
		int n = s.nextInt();
		Node head = null;
		Node temp = null;
		while(n!=-1){
			
			Node newNode = new Node(n);
			if(head == null){
				head = newNode;
				temp = head;
			}else{
				temp.next = newNode;
				temp = temp.next;
			}
			System.out.println("Enter next element: ");
			n = s.nextInt();	
		}
		return head;
	}

}
