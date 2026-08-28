/*
Approach : Kadane's Algorithm
TC = O(N)
SC = O(1)
Solved = 2
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int bestChoice = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<n; i++){
            // pair with the existing choice
            int choice1 = bestChoice + nums[i];

            // be a choice alone
            int choice2 = nums[i];

            bestChoice = Math.max(choice1, choice2);

            maxSum = Math.max(maxSum, bestChoice);   
        }
        return maxSum;
    }
}