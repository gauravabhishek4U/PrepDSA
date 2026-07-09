class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0 , right=0, zeros=0;
        int maxCount = 0, n = nums.length;

// Approach 1 (Better Soln): counting no of zeros by managing a zero counter
// TC : more than O(N) but lesser than O(N^2) : it is O(2N)
// here right pointer waits until left pointer is moving 
        // for(right = 0; right < n; right++){
        //     if(nums[right] == 0){
        //         zeros++;
        //     }
        //     while(zeros>k){
        //         if(nums[left] == 0){
        //             zeros--;
        //         }
        //         left++;
        //     }
        //     maxCount = Math.max(maxCount, right-left+1);
        // }
        // return maxCount;

// Approach 2nd : Optimal Soln : left and right pointer moves together
// TC : O(N)

        for(right = 0; right<n; right++){
            if(nums[right]==0){
                zeros++;
            }

            if(zeros>k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
        }
        return n -left;

    }
}