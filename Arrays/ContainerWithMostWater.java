public class ContainerWithMostWater {

	public static int solution1(int[] height){
		// Brute Force Approach

		int maxArea = Integer.MIN_VALUE;

		for(int i=0; i<height.length-1; i++){
			for(int j=i+1; j<height.length; j++){
				int ht = Math.min(height[i], height[j]);
				int wd = j-i;
				// int area = ht*wd;
				maxArea = Math.max(maxArea, wd*ht);
			}
		}
		return maxArea;
		// TC = 0(n^2), SC = 0(1)
	}

	public static int solution2(int[] height){
		// Optimal Approach using 2 pointers

		int maxArea = Integer.MIN_VALUE;
		int lp = 0, rp = height.length-1;

		while (lp < rp) {
			int ht = Math.min(height[lp], height[rp]);
			int wd = rp - lp;

			maxArea = Math.max(maxArea, ht * wd);

			if(height[lp] < height[rp])
				lp++;
			else
				rp--;
		}
		
		return maxArea;
		// TC = 0(n), SC = 0(1)

	}


	public static int solution3(int[] height){
		// Optimal Approach using 2 pointers

		int maxArea = Integer.MIN_VALUE;
		int lp = 0, rp = height.length-1;

		while (lp < rp) {
			int ht = Math.min(height[lp], height[rp]);
			int wd = rp - lp;

			maxArea = Math.max(maxArea, ht * wd);

			while (lp < rp && height[lp] <= ht) {
				lp++;
			}
			while (lp < rp && height[rp] <= ht) {
				rp--;
			}
		}
		
		return maxArea;
		// TC = 0(n), SC = 0(1)

	}

	public static void main(String[] args) {
		// System.out.println("Hello Container");

		// int height[] = {1,8,6,2,5};
		// int height[] = {1,8,6,2,5,4,8,3,7};
		int height[] = {1,1};

		System.out.println(solution1(height));
		System.out.println(solution2(height));
		System.out.println(solution3(height));
	}
}
