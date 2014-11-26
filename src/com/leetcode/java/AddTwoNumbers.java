package com.leetcode.java;

import java.util.Scanner;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		int plus = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + plus;
			plus = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 != null) {
			if (plus != 0) {
				cur.next = addTwoNumbers(l1, new ListNode(plus));
			} else {
				cur.next = l1;
			}
		} else if (l2 != null) {
			if (plus != 0) {
				cur.next = addTwoNumbers(l2, new ListNode(plus));
			} else {
				cur.next = l2;
			}
		} else if (plus != 0) {
			cur.next = new ListNode(plus);
		}

		return head.next;
	}
	public static ListNode getNodes(String list){
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(int i=0;i<list.length();i++){
			char ch = list.charAt(i);
			if(ch>='0'&&ch<='9'){
				cur.next = new ListNode(ch-48);
				cur = cur.next;
			}
		}
		return head.next;
	}
	
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] list = input.split("[+]");
	
		ListNode node1 = getNodes(list[0]);
		
		ListNode node2 = getNodes(list[1]);
		ListNode node3 = addTwoNumbers(node1,node2);
		while(node3!=null){
			System.out.print(node3.val+(node3.next!=null?"->":""));
			
			node3 = node3.next;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}