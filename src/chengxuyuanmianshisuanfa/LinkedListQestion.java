package chengxuyuanmianshisuanfa;

import java.awt.print.Printable;
import java.util.List;

import javax.xml.soap.Node;

import javaexmple.MergeSort;

public class LinkedListQestion {
	 class ListNode {
		 int val;
		  ListNode next;
		  ListNode(int x) {
		         val = x;
		          next = null;
		      }
	}
	

      /**
       * Sort a linked list in O(n log n) time using constant space complexity.
       */
	public ListNode sortList(ListNode head) {
		//采用归并方法:1.拆分2.合并
		
		if (head == null) return head;
		if (head.next == null) {
			return head;
		}
		ListNode slow;
		ListNode fast;
		slow = head;
		fast = head.next;
		while (fast != null&&fast.next != null) {
			    fast = fast.next.next;
			    slow = slow.next;
		}
		ListNode left = head;

//		System.out.println(slow.next.val);
        ListNode rightHead = sortList(slow.next);
        slow.next = null;  //把左半部分和右半部分分开
    	ListNode leftHead = sortList(left);
		return merge(leftHead, rightHead);
	        
}



		
private int count =0;

	/**
	 * 归并法里的第二步，合并
	 * @param i
	 * @param midNode
	 */
	private ListNode merge(ListNode left, ListNode right) {
	
		
		ListNode current1 =  left;
		ListNode current2 = right;
		ListNode current ,tail ;
		current = new ListNode(-1);
		tail = current;
	   if (current1 == null) 
	   {
		   return current2;
	   }
	   if (current2 == null) {

		   return current1;}
	  
	   while (current1 != null && current2 != null) {
		   	if (current1.val <current2.val) { 
				  tail.next = current1;
				  current1 = current1.next;
			}else {
				   tail.next = current2;
				  current2 = current2.next;
			}
		   	 tail = tail.next;
	}
	  if (current1!=null) {
		  tail.next = current1;
	}else if (current2!= null) {
		 tail.next = current2;
	}

	  return current.next;
	}






public ListNode createLinkeList(int[] list) {
	
	//创建头节点
	ListNode head = new ListNode(-1);
	ListNode tail = head;
	//尾插法
	for (int i = 0; i < list.length; i++) {
		tail.next = new ListNode(list[i]);
		tail = tail.next;
	}
	return head.next;
	   
}
		
	}

