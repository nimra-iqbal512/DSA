import java.util.Arrays;
import java.util.HashMap;

/*
1. Two Sum:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/

public class TwoSum{

	public static int[] solution1(int[] nums, int target){
		for(int i=0; i<nums.length-1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					return new int[] {i, j};
				}
			}
		}	
		
		// If indices not found, return null
		return null;

		// TC = 0(n^2), SC = 0(1)
	}


	public static int[] solution2(int[] nums, int target){

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			hashMap.put(nums[i], i);
		}
		for(int i=0; i<nums.length; i++){
			int compliment = target - nums[i];
			if(hashMap.containsKey(compliment) && hashMap.get(compliment) != i){
				return new int[] {i, hashMap.get(compliment)};
			}
		}
 
		return null;

		// TC = 0(n), SC = 0(n)
	}


	public static int[] solution3(int[] nums, int target){

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int compliment = target - nums[i];
			if(hashMap.containsKey(compliment)){
				return new int[] {hashMap.get(compliment), i};
			}
			hashMap.put(nums[i], i);
		}

		return null;

		// TC = 0(n), SC = 0(n)
	}

	public static void main(String[] args) {
		System.out.println("Nimra");

		
		// Pseudocode Implementation

		// int nums[] = {3, 3};
		// System.out.println("Array: " + Arrays.toString(nums));
		// int target = 6;
		// int getIndices[] = new int[2];

		// for(int i=0; i<nums.length; i++){
		// 	for(int j=i+1; j<nums.length; j++){
		// 		if(nums[i] + nums[j] == target){
		// 			getIndices[0] = i;
		// 			getIndices[1] = j;
		// 			System.out.println(Arrays.toString(getIndices));

		// 			return;
		// 		}
		// 	}
		// }
		// // TC = 0(n^2), SC = 0(1)


		// // Method 1
		// // int nums[] = {3, 3};
		// // int indices[] = solution1(nums, 6);
		// int indices[] = solution1(new int[] {2, 7, 11, 15}, 22);
		// System.out.println(Arrays.toString(indices));


		// Method 2
		// int nums[] = {2, 7, 11, 15};
		// int nums[] = {3, 2, 4};
		int nums[] = {3, 3};
		int target = 6;
		int indices[] = solution2(nums, target);
		System.out.println(Arrays.toString(indices));


		// // Method 3
		// int nums[] = {2, 7, 11, 15};
		// // int nums[] = {3, 2, 4};
		// // int nums[] = {3, 3};
		// int target = 13;
		// int indices[] = solution3(nums, target);
		// System.out.println(Arrays.toString(indices));


		// // Method 4
		// // Explore why 2 pointers approach is not suitable for this scenario?
	}
}