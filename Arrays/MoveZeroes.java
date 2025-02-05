public class MoveZeroes {
    public static void moveZeroes1(int[] nums){
        int[] nums2 = new int[nums.length];

        int start = 0; int end = nums.length - 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                nums2[end--] = nums[i];
            }else{
                nums2[start++] = nums[i];
            }
        }

        nums = nums2;

        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // TC = 0(N), SC = 0(N)
    }

    public static void moveZeroes2(int[] nums){
        int insertPosition = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[insertPosition++] = nums[i];
            }
        }

        while(insertPosition < nums.length){
            nums[insertPosition++] = 0;
        }

        for(int i=0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // TC = 0(n), SC = 0(1)


        // System.out.println(nums.length);
        // // int arr_length = nums.length;
        // int count_zeroes = 0;
        // int move_back = -1;

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] == 0){
        //         count_zeroes++;
        //         if(move_back == -1){
        //             move_back = i;
        //         }
        //     }else{
        //         if(move_back != -1){
        //             nums[move_back] = nums[i];
        //             move_back++;
        //         }
        //     }
        // }

        // for(int i=nums.length-1; i >= nums.length - count_zeroes; i--){
        //     nums[i] = 0;
        // }

        // for(int i=0; i < nums.length; i++){
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello");

        // int[] nums = {0, 1, 0, 3, 12};
        // int[] nums = {0};
        // int[] nums = {0, 1, 0};
        int[] nums = {0, 1, 5, 0, 12, 0, 9};

        // moveZeroes1(nums);
        moveZeroes2(nums);
    }
}
