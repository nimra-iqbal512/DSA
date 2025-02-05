/**
 * FibonacciNumber
 */
public class FibonacciNumber {

	public static int count = 0;

	public static int solution1(int n){
		if(n < 0) throw new IllegalArgumentException("Input cannot be negative.");
		count++;
		
		if(n == 0)  return 0;
		if(n == 1)	return 1;

		int sum = solution1(n - 1) + solution1(n - 2);
		return sum;

		// TC = 0(2^n), SC = 0(n)
	}
	
	public static int solution2(int n){

		// Efficient than solution1
		// Using DP - Efficient Approach (Top Down Approach)


		// int memo[] = new int[n+1];
		
		/*
		* In Java, when you create an array of a primitive data type like int, all elements are automatically initialized to 0 (not null). Since int is a primitive type, it cannot hold a null value. If you want to initialize an array such that all elements are null, you need to use an array of the wrapper class Integer instead.
		*/
		
		Integer memo[] = new Integer[n+1];	//All elements of the array are automatically initialized to null
		memo[0] = 0;
		if(n > 0) memo[1] = 1;
		
		int result = fib(memo, n);
		return result;

		// TC = 0(n), SC = 0(n)
	}

	public static int fib(Integer[] memo, int n){
		count++;
		if(memo[n] != null)	return memo[n];	
		
		if(n < 0) throw new IllegalArgumentException("Input cannot be negative.");

		// System.out.println("n = " + n);
		int sum = fib(memo, n - 1) + fib(memo, n - 2);
		memo[n] = sum;
		return sum;
	}

	public static int solution3(int n){
		// Using DP - Efficient Approach (Bottom Up Approach - Tabulation Technique)

		int fib[] = new int[n+1];
		fib[0] = 0;
		if(n > 0) fib[1] = 1;

		for(int i=2; i<=n; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];

		// TC = 0(n), SC = 0(n)

	}

	public static void main(String[] args) {
		System.out.println("Fibonacci Number");

		// int n = 5;
		// int n = 0;
		int n = 4;
		// int n = 6;
		// int n = 16;

		count = 0;
		System.out.println(solution1(n));
		System.out.println("Count: " + count);
		
		count = 0;
		System.out.println(solution2(n));
		System.out.println("Count: " + count);

		System.out.println(solution3(n));
	}
}