package chengxuyuanmianshisuanfa;

import chengxuyuanmianshisuanfa.LinkedListQestion.ListNode;

public class TestMain {

	public static void main(String[] args) {
		  LinkedListQestion link = new LinkedListQestion();
		   int[] data = {2,1};
		   ListNode head = link.createLinkeList(data);
	    	head = link.insertionSortList(head); 
		   while(head!=null){
			      System.out.println(head.val);
			      head = head.next;
		   }
	}
}
