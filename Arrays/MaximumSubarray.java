import java.util.Arrays;

/** 
 * Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.
 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/

public class MaximumSubarray {

	public static int solution1(int[] nums){
		// In this BruteForce Solution, we'll find the sum of all sub-arrays and will return the larger one.
		
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for(int count=0; count<nums.length; count++){
			for(int i=count; i<nums.length; i++){
				currentSum = 0;
				for(int j=count; j<=i; j++){
					currentSum += nums[j];
				}
				if(currentSum > maxSum){
					maxSum = currentSum;
				}
			}
		}
		return maxSum;

		// TC = 0(n*3), SC = 0(1)
	}


	public static int solution2(int[] nums){
		// Again a BruteForce Solution
		
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for(int start=0; start<nums.length; start++){
			currentSum = 0;
			for(int end=start; end<nums.length; end++){
				currentSum += nums[end];
				if(currentSum > maxSum){
					maxSum = currentSum;
				}
			}
		}
		return maxSum;

		// TC = 0(n*2), SC = 0(1)
	}

	public static int solution3(int[] nums){
		// Efficient Solution using Kadane's Algorithm

		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for(int i=0; i<nums.length; i++){
		// // =================================
		// 	currentSum += nums[i];

		// 	if(maxSum < currentSum){
		// 		maxSum = currentSum;
		// 	}

		// 	if(currentSum < 0){
		// 		currentSum = 0;
		// 	}

		// // =================================
			// maxSum = Math.max(maxSum, currentSum += nums[i]);
			// currentSum = Math.max(currentSum, 0);
		
		// // =================================
			currentSum += nums[i];
			maxSum = currentSum > maxSum ? currentSum : maxSum;
			currentSum = currentSum < 0 ? 0 : currentSum;
		}

		return maxSum;

		// TC = 0(n), SC = 0(1)
	}
	
	public static int solution4(int[] nums){
		// Using Divide and Conquer Approach
		return subArray(nums, 0, nums.length-1);
		
		// TC = 0(n logn), SC = 0(logn)
	}

	public static int subArray(int[] nums, int startIndex, int lastIndex){

		if(startIndex == lastIndex){
			return nums[startIndex];
		}

		int midIndex = (startIndex+lastIndex)/2;

		int leftMax = subArray(nums, startIndex, midIndex);
		int rightMax = subArray(nums, midIndex+1, lastIndex);
		int crossOver = maxCrossingSubarray(nums, startIndex, midIndex, lastIndex);

		return Math.max(Math.max(leftMax, rightMax), crossOver);
	}

	public static int maxCrossingSubarray(int[] nums, int startIndex, int midIndex, int lastIndex){
		int leftMaxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = midIndex; i >= startIndex; i--){
			sum += nums[i];
			leftMaxSum = Math.max(leftMaxSum, sum);
		}

		int rightMaxSum = Integer.MIN_VALUE;
		sum = 0; 
		for(int i = midIndex + 1; i <= lastIndex; i++){
			sum += nums[i];
			rightMaxSum = Math.max(rightMaxSum, sum);
		}

		return leftMaxSum + rightMaxSum;
	} 

	public static void main(String[] args) {	
		System.out.println("Hello World");

		// int nums[] = {5, 4, -1, 7, 8};
		int nums[] = {-5, 4, 6, -3};
		// int nums[] = {-5, 4, 6, -3, 4, -1};
		// int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		System.out.println(solution1(nums));
		System.out.println(solution2(nums));
		System.out.println(solution3(nums));
		System.out.println(solution4(nums));
	}
}
