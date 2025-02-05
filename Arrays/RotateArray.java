import java.util.Arrays;

public class RotateArray {

	public static void solution1(int[] nums, int k){

		for(int i=0; i<k; i++){
			int end = nums[nums.length - 1];
			for(int j=nums.length-2; j>=0; j--){
				nums[j+1] = nums[j];
			}
			nums[0] = end;
		}
		System.out.println(Arrays.toString(nums));

		// TC = 0(n^k), where k is the number of rotations, and n is the length of nums
		// SC = 0(1)

	}

	public static void solution2(int[] nums, int k){
		int nums2[] = new int[nums.length];

		for(int i=0; i<nums.length; i++){
            nums2[(i+k)%nums.length] = nums[i];
		}

		// nums = nums2;
		// System.out.println(Arrays.toString(nums));
		
		// // Copying elements from nums2 to nums
		for(int i=0; i<nums.length; i++){
			nums[i] = nums2[i];
		}
		System.out.println(Arrays.toString(nums));

		// TC = 0(n), SC = 0(n)
	}

	public static void solution3(int[] nums, int k){

		k = k % nums.length; //In case, k is larger than nums.length

		reverseArray(nums, 0, nums.length-1);
		reverseArray(nums, 0, k-1);
		reverseArray(nums, k, nums.length-1);
		
		System.out.println(Arrays.toString(nums));

		// TC = 0(n), SC = 0(1)
	}

	public static void reverseArray(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

			start++;
			end--;
		}
	}


	public static void main(String[] args) {
		System.out.println("Rotate Array");

		// int nums[] = {1,2,3,4,5,6,7};
		// int k = 3;

		int nums[] = {-1,-100,3,99};
		int k = 2;

		// solution1(nums, k);
		// solution2(nums, k);
		solution3(nums, k);
	}
}
