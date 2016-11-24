package chengxuyuanmianshisuanfa;

import java.awt.print.Printable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

import sort.MergeSort;

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
		// ���ù鲢����:1.���2.�ϲ�

		if (head == null)
			return head;
		if (head.next == null) {
			return head;
		}
		ListNode slow;
		ListNode fast;
		slow = head;
		fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode left = head;

		// System.out.println(slow.next.val);
		ListNode rightHead = sortList(slow.next);
		slow.next = null; // ����벿�ֺ��Ұ벿�ַֿ�
		ListNode leftHead = sortList(left);
		return merge(leftHead, rightHead);

	}

	private int count = 0;

	/**
	 * �鲢����ĵڶ������ϲ�
	 * 
	 * @param i
	 * @param midNode
	 */
	private ListNode merge(ListNode left, ListNode right) {

		ListNode current1 = left;
		ListNode current2 = right;
		ListNode current, tail;
		current = new ListNode(-1);
		tail = current;
		if (current1 == null) {
			return current2;
		}
		if (current2 == null) {

			return current1;
		}

		while (current1 != null && current2 != null) {
			if (current1.val < current2.val) {
				tail.next = current1;
				current1 = current1.next;
			} else {
				tail.next = current2;
				current2 = current2.next;
			}
			tail = tail.next;
		}
		if (current1 != null) {
			tail.next = current1;
		} else if (current2 != null) {
			tail.next = current2;
		}

		return current.next;
	}

	public ListNode createLinkeList(int[] list) {

		// ����ͷ�ڵ�
		ListNode head = new ListNode(-1);
		ListNode tail = head;
		// β�巨
		for (int i = 0; i < list.length; i++) {
			tail.next = new ListNode(list[i]);
			tail = tail.next;
		}
		return head;

	}

	/**
	 * Sort a linked list using insertion sort. Ҫά����ǰ�ڵ��ǰָ���Լ�����λ�õ�ǰ��ڵ�
	 */
	public ListNode insertionSortList(ListNode head) {
		// ά������λ�ã�
		ListNode p = head;
		ListNode q = head.next;
		ListNode r = q; // ���д������ǰ��ָ��
		ListNode s = q.next;
		while (s != null) {
			while (s.val > q.val && q.val != s.val) {
				p = q;
				q = q.next;
			}
			if (q.val == s.val) {
				p = head;
				q = head.next;
				r = r.next;
				s = s.next;
			} else {
				r.next = s.next;
				s.next = q;
				p.next = s;
				s = r.next;
				// ��p��q�ص���ʼλ�ý�����һ��
				p = head;
				q = head.next;
			}
		}
		return head;

	}

	/**
	 * ���ֲ��뷽ʽ��̫��
	 * 
	 * @param head
	 * @return
	 */
	public ListNode insert(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next;
		head.next = null;
		ListNode curPre, sorted;
		while (cur != null) {
			curPre = cur;
			cur = cur.next;
			curPre.next = null;
			if (head.val > curPre.val) {
				curPre.next = head;
				head = curPre;
				continue;
			}
			sorted = head;
			while (sorted.next != null) {
				if (sorted.next.val > curPre.val) {
					curPre.next = sorted.next;
					sorted.next = curPre;
					break;
				}
				sorted = sorted.next;
			}
			if (sorted.next == null) {
				sorted.next = curPre;
			}
		}
		return head;
	}

	/**
	 * Given a singly linked list L: L0��L1������Ln-1��Ln, reorder it to:
	 * L0��Ln��L1��Ln-1��L2��Ln-2���� You must do this in-place without altering the
	 * nodes' values. For example, Given{1,2,3,4}, reorder it to{1,4,2,3}.
	 */
		public void reorderList(ListNode head) {
			  