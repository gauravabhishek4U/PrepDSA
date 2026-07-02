class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

// using TWO POINTER approach : OPTIMAL SOLUTION

    //     for(int i=0; i< n-2; i++){

    //         // handling duplicate value for i
    //         if(i>0 && nums[i] == nums[i-1]) continue;

    //         int left = i+1, right = n-1;

    //         while(left < right){

    //             int sum = nums[i] + nums[left] + nums[right];

    //             if( sum == 0){
    //                 result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    
    //                 // handling duplicate value for left
    //                 while(left<right && nums[left] == nums[left+1]) {
    //                     left++;
    //                 }

    //                 // handling duplicate value for right
    //                 while(left < right && nums[right] == nums[right-1]){
    //                     right--;
    //                 }

    //                 left++;
    //                 right--;

    //             }
    //             else if(sum > 0){
    //                 right --;
    //             }
    //             else{
    //                 left++;
    //             }
    //         }
    //     }
    //     return result; 
    // }

// Using two pointer with binary search : TC : O(N^2)
    
    Set<List<Integer>> set = new HashSet<>();

    for(int i = 0; i < n-2; i++){
        for(int j = i+1; j < n; j++){
            int target = -(nums[i] + nums[j]);

            if(Arrays.binarySearch(nums, j+1, n, target) >= 0){
                set.add(Arrays.asList(nums[i],nums[j],target));
            }
        }
    }

    return new ArrayList<>(set);
}
}