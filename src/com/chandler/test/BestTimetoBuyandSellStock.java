package com.chandler.test;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 */
public class BestTimetoBuyandSellStock {

	public int getMaxProfit(int[] prices){
		int lowest=0;
		int maxprofit=0;
		if(prices.length>0){
			for(int i=0;i<prices.length;i++){
				if(lowest > prices[i]){
					lowest = prices[i];
				}
				maxprofit = Math.max(maxprofit,prices[i]-lowest );
			}
		}
		return maxprofit;
	}
	public static void main(String[] args) {

	}

}
