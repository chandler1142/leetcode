package com.chandler.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

public class Anagrams {

	public static ArrayList<String> anagrams(String[] array) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> rl = new ArrayList<String>();
		for(int i=0;i<array.length;i++){
			char[] ch = array[i].toCharArray();
			Arrays.sort(ch);
			list.add(new String(ch));
		}
		int[] nums = new int[array.length];
		int temp = 0;
		for(int i=0;i<list.size();i++){
			if(nums[i]==0){
				nums[i] = 1;
				temp = 1;
				for(int j=i+1;j<list.size();j++){
					if(nums[j]==0 && list.get(j).equals(list.get(i))){
						temp++;
						nums[j] = 1;
					}
				}
				
				if(temp == 1){
					nums[i] = 0;
				}
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]==1){
				rl.add(array[i]);
			}
		}
		return rl;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"tea","eat","ate","tony"};
		ArrayList<String> list = anagrams(str);
		for(String s:list){
			System.out.println(s);
		}
	}

}
