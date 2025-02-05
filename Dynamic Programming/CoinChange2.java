import java.util.Arrays;

public class CoinChange2 {

	public static int solution1(int amount, int[] coins){
		// Using DP

		// int combinations = 0;

		int rows = coins.length + 1;
		int cols = amount + 1;
		int[][] combos = new int[rows][cols];

		// for(int i = 0; i < rows; i++){
		// 	for(int j = 0; j < cols; j++){
		// 		// To make 0 amount, we have only 1 way, and that is not to use any coin
		// 		if(j == 0){
		// 			combos[i][j] = 1;
		// 		}			
		// 		else if(i == 0){
		// 			combos[i][j] = 0;
		// 		}	
		// 		else if(j < coins[i-1]){
		// 			combos[i][j] = combos[i-1][j];
		// 		}
		// 		else{
		// 			combos[i][j] = combos[i-1][j] + combos[i][j-coins[i-1]];
		// 		}
		// 	}
		// }


		// // ====================================================
		// for(int i=0; i<rows; i++){
		// 	combos[i][0] = 1;
		// }

		// for(int j=1; j<cols; j++){
		// 	combos[0][j] = 0;	
		// }

		// for(int i=1; i<rows; i++){
		// 	for(int j=1; j<cols; j++){
		// 		combos[i][j] = combos[i-1][j];

		// 		if(j >= coins[i-1]){
		// 			combos[i][j] += combos[i][j - coins[i-1]];
		// 		}
		// 	}
		// }


		// ====================================================
		combos[0][0] = 1;
		// System.out.println(Arrays.toString(combos[0]));

		// // Instead of this loop, we can only make the first elm (combos[0][0]) to 1, as done above
		// for(int i=0; i<rows; i++){
		// 	combos[i][0] = 1;
		// }

		// // No need to assign 0 explicitly, bcoz int array is initialized with 0 implicitly.
		// for(int j=1; j<cols; j++){
		// 	combos[0][j] = 0;	
		// }

		for(int i=1; i<rows; i++){
			for(int j=0; j<cols; j++){
				combos[i][j] = combos[i-1][j];

				if(j >= coins[i-1]){
					combos[i][j] += combos[i][j - coins[i-1]];
				}
			}
			// System.out.println(Arrays.toString(combos[i]));
		}



		return combos[rows-1][cols-1];

		// TC = 0(n*m), SC = 0(n*m), where n is the number of coins, and m is the amount

		// If can say that TC or SC = 0(n^2), this is wrong. This would only be correct if n(coins) and m(amount) are proportional to each other, but in general, they aren't.
		// So time complexity is not 0(n^2), unlesss amount happens to be proportioanl to coin. i.e. coins = 100, amount = 100, then it can be 0(n^2).
	}

	public static int solution2(int amount, int[] coins){

		// Using DP (more efficient)


		int dp[] = new int[amount + 1];
		dp[0] = 1;	//There is one way to make amount 0, that is using no coin.

		for(int coin: coins){
			for(int j = coin; j <= amount; j++){
				dp[j] += dp[j - coin];	
			}
		}
		return dp[amount];

		// TC = 0(n*m), where n is the number of coins, and m is the amount
		// SC = 0(m)
	}

	
	public static void main(String[] args) {
		System.out.println("Hello Coin Change 2");

		// int amount = 5;
		// // int coins[] = {1, 2, 5};
		// // int coins[] = {2, 3, 5};
		// int coins[] = {2, 3, 5, 15};

		int amount = 15;
		int coins[] = {2, 3, 5, 10};

		// int amount = 10;
		// int coins[] = {10};

		// int amount = 3;
		// int coins[] = {2};

		System.out.println(solution1(amount, coins));
		System.out.println(solution2(amount, coins));
	}
}
