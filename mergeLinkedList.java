package LinkedList;

public class mergeLinkedList {
	static Node head;
	
	public static class Node
	{
		int data;
		Node next;
		
		Node (int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	static void push(int data)
	{
		Node temp=new Node(data);
		temp.next=head;
		head=temp;
	}
	
	static Node merge(Node head)
	{
		if(head==null || head.next==null)
			return head;
		
		Node middle=getMiddle(head);
		
		Node nextMiddle=middle.next;
		
		middle.next=null;
		
		Node left=merge(head);
		Node right=merge(nextMiddle);
		
		Node sortedList=mergeSort(left,right);
		
		return sortedList;
	}
	
	static Node getMiddle(Node head)
	{
		if(head==null || head.next!=null)
			return head;
		Node slow_ptr=head;
		Node fast_ptr=head;
		
		while(fast_ptr!=null && fast_ptr.next!=null)
		{
			slow_ptr=slow_ptr.next;
			fast_ptr=fast_ptr.next.next;			
		}
		
		return slow_ptr;
	}
	
	static Node mergeSort(Node left,Node right)
	{
		Node result=null;
		
		if(left==null)
			return right;
		else if(right==null)
			return left;
		
		if(left.data<=right.data)
		{
			result=left;
			result.next=mergeSort(left.next,right);
		}
		else
		{
			result=right;
			result.next=mergeSort(left,right.next);
		}
		return result;
	}

	public static void main(String[] args) {
		push(2);
		push(1);
		push(8);
		push(7);
		push(1);
		push(6);
		
		System.out.println("Original List ");
		printList(head);
		
		head=merge(head);
		System.out.println("Sorted List : ");
		printList(head);
	}
	
	static void printList(Node head)
	{
		Node curr=head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		System.out.println();
	}

}
