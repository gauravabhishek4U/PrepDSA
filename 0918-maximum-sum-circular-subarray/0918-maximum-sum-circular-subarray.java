/*
Approach : Kadane's Algo
TC = O(N)
SC = O(1)
Solved = 1
*/
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        // calculate total sum of the complete array
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        // calculate maximum sum of the complete array
        int bestMaxChoice = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<n; i++){
            bestMaxChoice = Math.max(nums[i], bestMaxChoice + nums[i]);
            maxSum = Math.max(maxSum, bestMaxChoice);
        }

        // calculate minimum sum of the complete array
        int bestMinChoice = nums[0];
        int minSum = nums[0];

        for(int i=1; i<n; i++){
            bestMinChoice = Math.min(nums[i], bestMinChoice + nums[i]);
            minSum = Math.min(minSum, bestMinChoice);
        }

        // if all elements are negative then total sum of the array will be equal to the minimum sum of the array
        // then the maxSum will be the maximum possible sum
        if(totalSum == minSum){
            return maxSum;
        }
        
        // else array has both positive and negative elements
        // so calculate the circular sum of the array
        // and return the maximum of circularSum and maxSum
        int circularSum = totalSum - minSum;
        return Math.max(maxSum, circularSum);
    }
}