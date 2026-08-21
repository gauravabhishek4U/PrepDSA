/*
Approach : Prefix and Suffix Sum
TC = O(n), n = nums.length
SC = O(1)
*/

class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int leftSum = 0;

        // calculate the total sum of all elements in nums
        for(int num : nums){
            totalSum += num;
        }

        // calculate prefix and suffix sum for every index and check if they are equal
        for(int i = 0; i < n; i++){

            int rightSum = totalSum - leftSum - nums[i];

            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}