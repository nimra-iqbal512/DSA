import java.util.Arrays;

/**
 * Write a generator function that returns a generator object which yields the fibonacci sequence.
The fibonacci sequence is defined by the relation Xn = Xn-1 + Xn-2.
The first few numbers of the series are 0, 1, 1, 2, 3, 5, 8, 13.

Example 1:

Input: callCount = 5
Output: [0,1,1,2,3]
Explanation:
const gen = fibGenerator();
gen.next().value; // 0
gen.next().value; // 1
gen.next().value; // 1
gen.next().value; // 2
gen.next().value; // 3

Example 2:

Input: callCount = 0
Output: []
Explanation: gen.next() is never called so nothing is outputted 

Constraints:
0 <= callCount <= 50
 */

public class GenerateFibonacciSequence {

	public static int[] solution1(int n){
		int sequence[] =  new int[n];

		// if(n == 0) return sequence;

		if(n > 0) sequence[0] = 0;
		if(n > 1) sequence[1] = 1;

		for(int i=2; i<n; i++){
			sequence[i] = sequence[i-1] + sequence[i-2];
		}
		return sequence;

		// TC = 0(n), SC = 0(n)
	}
	public static void main(String[] args) {
		System.out.println("Hello World");

		int callCount = 5;

		System.out.println(Arrays.toString(solution1(callCount)));
	}
}
