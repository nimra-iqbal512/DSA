/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

	public static int pseudocodeConversion(int prices[]){
		int maxProfit = 0;
		int flag = 0;

		for(int i=0; i<prices.length-1; i++){
			int maxSale = 0;
			flag = 0;

			for(int j=i+1; j<prices.length; j++){
				if(prices[j] > prices[i] && prices[j] > maxSale){
					maxSale = prices[j];
					flag = 1;
				}
			}

			if(flag == 1 && maxProfit < maxSale - prices[i]){
				maxProfit = maxSale - prices[i];
			}
		}

		return maxProfit;

		// TC = 0(n^2), SC = 0(1)

	}

	public static int solution1(int prices[]){
		// int maxProfit = 0;
		// for(int i=0; i<prices.length-1; i++){
		// 	int currentProfit = 0;

		// 	for(int j=i+1; j<prices.length; j++){
		// 		if(prices[j] > prices[i] && currentProfit < prices[j] - prices[i]){
		// 			currentProfit = prices[j] - prices[i];
		// 		}
		// 	}

		// 	if(maxProfit < currentProfit){
		// 		maxProfit = currentProfit;
		// 	}
		// }
		// return maxProfit;

		int maxProfit = 0;

		for(int i=0; i<prices.length-1; i++){
			for(int j=i+1; j<prices.length; j++){
				maxProfit = prices[j] > prices[i] && maxProfit < prices[j] - prices[i] ? prices[j] - prices[i] : maxProfit;
			}
		}

		return maxProfit;

		// TC = 0(n^2), SC = 0(1)
	}

	public static int solution2(int prices[]){
		// int maxProfit = 0;

		// // prices[] tells the buy price
		// // maxSale array will tell the possible maximum sold price
		
		// int maxSale[] = new int[prices.length];
		// for(int i=prices.length-1; i>=0; i--){
		// 	if(i == prices.length-1){
		// 		maxSale[i] = prices[i];
		// 	}else{
		// 		if(prices[i] > maxSale[i+1]){
		// 			maxSale[i] = prices[i];
		// 		}else{
		// 			maxSale[i] = maxSale[i+1];
		// 		}
		// 	}
		// }
		// // System.out.println(Arrays.toString(maxSale));

		// for(int i=0; i<prices.length; i++){
		// 	if(maxProfit < maxSale[i] - prices[i]){
		// 		maxProfit = maxSale[i] - prices[i];
		// 	}
		// }
 
		// return maxProfit;


		int maxProfit = 0;
		int maxSale[] = new int[prices.length];
		maxSale[prices.length-1] = prices[prices.length-1];

		for(int i=prices.length-2; i>=0; i--){
			maxSale[i] = Math.max(prices[i], maxSale[i+1]);

			maxProfit = Math.max(maxProfit, maxSale[i] - prices[i]);
		}

		return maxProfit;

		// TC = 0(n), SC = 0(n)
	}


	public static int solution3(int[] prices){
		int maxProfit = 0;
		int minPrice = prices[0];

		for(int i=1; i<prices.length; i++){
			// Program runtime will increase if we use 2 if statements instead of these if-else statements.
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
			// int currentProfit = prices[i] - minPrice;
			else if(maxProfit < prices[i] - minPrice){
				maxProfit = prices[i] - minPrice;
			}
		}

		return maxProfit;

		// TC = 0(n), SC = 0(1)
	}

	public static void main(String[] args) {
		System.out.println("Hello Guys");

		int prices[] = {3, 1, 4, 8, 7, 2, 5};
		// int prices[] = {7, 1, 5, 3, 6, 4};
		// int prices[] = {5, 2, 6, 1, 4};
		// int prices[] = {7,6,4,3,1};

		System.out.println(pseudocodeConversion(prices));
		System.out.println(solution1(prices));
		System.out.println(solution2(prices));
		System.out.println(solution3(prices));
	}
}
