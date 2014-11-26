package com.chandler.test;

import java.util.LinkedList;
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
	
	public static LinkedList getLinkedList(String str){
		LinkedList list = new LinkedList();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(Character.isDigit(ch)){
				list.add(ch);
			}
		}
		return list;
	}
	public static LinkedList addLinkedList(LinkedList l1,LinkedList l2){
		LinkedList tempList = new LinkedList();
		int length1 = l1.size()-1;
		int length2 = l2.size()-1;
		int adv=0;
		while(length1>=0&&length2>=0){
			int a = (char)l1.get(length1--)-48;
			int b = (char)l2.get(length2--)-48;
			int sum = (a+b+adv)%10;
			adv = (a+b+adv)/10;
			tempList.add(sum);
		}
		if(length1>=0){
			int a = (char)l1.get(length1--)-48;
			int sum = (a+adv)%10;
			adv = (a+adv)/10;
			tempList.add(sum);
		}else if(length2>=0) {
			int b = (char)l2.get(length2--)-48;
			int sum = (b+adv)%10;
			adv=(b+adv)/10;
			tempList.add(sum);
		}
		
		if(adv == 1){
			tempList.add(1);
		}
		return tempList;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] list = input.split("[+]");
		LinkedList list1 = getLinkedList(list[0]);
		LinkedList list2 = getLinkedList(list[1]);
		
		LinkedList newlist = addLinkedList(list1,list2);
		for(int i=0;i<newlist.size();i++){
			System.out.print(newlist.get(i));
			if(i != newlist.size()-1){
				System.out.print(" -> ");
			}
		}
		
	}

}
