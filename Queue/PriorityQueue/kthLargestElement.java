
import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElement {
    public static int findkthLargest1(int[] nums, int k){
        // // Sort array
        // for(int i=0; i<nums.length-1; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j] > nums[i]){
        //             int temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }

        // return nums[k-1];
        // // TC = 0(n^2), SC = 0(1)


        Arrays.sort(nums);
        return nums[nums.length - k];
        // TC = 0(N logN), SC = 0(1)
    }

    public static int findkthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Made a priority queue of k size;
        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
        }

        // Add remaining elements in priority queue
        for(int i=k; i<nums.length; i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        } 

        return pq.peek();

        // Insertion and deletion in min/max heap takes time complexity of 0(logN), but k in this case, 0(logK)
        // TC = 0(N logK), first loop --> 0(K logK), second loop --> 0((N-K) logK), 0(K logK) + 0((N-K) logK) = 0(NlogK)
        // SC = 0(k) beacuse we maintain a heap of k elements
    }

    public static void main(String[] args) {
        // System.out.println("Hello World");

        int[] nums = {3, 2, 1, 5};
        System.out.println(findkthLargest1(nums, 3));
        System.out.println(findkthLargest2(nums, 3));
    }
}
