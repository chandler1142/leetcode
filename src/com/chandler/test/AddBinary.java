package com.chandler.test;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {
	public String addBinary2(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		int da = 0;
		int db = 0;
		int adv = 0;
		StringBuffer result = new StringBuffer();
		while (i >= 0 && j >= 0) {
			da = a.charAt(i--) == '0' ? 0 : 1;
			db = b.charAt(j--) == '0' ? 0 : 1;
			int d = da + db + adv;
			result.append(d % 2 == 0 ? '0' : '1');
			adv = d >> 1;
		}
		if (i >= 0) {
			while (i >= 0) {
				da = a.charAt(i--) == '0' ? 0 : 1;
				int d = da + adv;
				result.append(d % 2 == 0 ? '0' : '1');
				adv = d >> 1;
			}
		} else if (j >= 0) {
			while (j >= 0) {
				db = b.charAt(j--) == '0' ? 0 : 1;
				int d = db + adv;
				result.append(d % 2 == 0 ? '0' : '1');
				adv = d >> 1;
			}
		}
		if (adv == 1) {
			result.append('1');
		}
		return result.reverse().toString();
	}
	
	public String addBinary(String a,String b) {
		int num1 = Integer.valueOf(a, 2);
		int num2 = Integer.valueOf(b, 2);
		int num = num1 + num2;
		String c="";
		while(num>0){
			int temp = num%2;
			c = temp+c;
			num = num/2;
		}
		return c;
	}
	public StringBuffer addBinary03(String a,String b){
		int l1 = a.length()-1;
		int l2 = b.length()-1;
		int abv=0;
		int la=0;
		int lb=0;
		StringBuffer str = new StringBuffer();
		while(l1>=0&&l2>=0){
			la = a.charAt(l1--)== '0'?0:1;
			lb = b.charAt(l2--)== '0'?0:1;
			int sum = la+lb+abv;
			str.append(sum%2==0?"0":"1");
			abv = sum/2;
		}
		if(l1>=0){
			la = a.charAt(l1--)== '0'?0:1;
			int sum = la+abv;
			str.append(sum%2==0?"0":"1");
		}else if(l2>=0){
			lb = b.charAt(l2--)== '0'?0:1;
			int sum = lb+abv;
			str.append(sum%2==0?"0":"1");
		}
		
		if(abv==1){
			str.append("1");
		}
		return str.reverse();
		
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();   //获取开始时间   
		AddBinary b = new AddBinary();
		
		for(int i=0;i<10000000;i++){
			b.addBinary("10","10");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
