/*
Approach: Greedy
TC : O(N)
SC = O(1)
Solved : 1
*/
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIdx = 0, maxIdx = 0;

        // identifying the index for minimum and maximum element
        for(int i = 0; i< n; i++){
            if(nums[i] < nums[minIdx]) minIdx = i;
            if(nums[i] > nums[maxIdx]) maxIdx = i;
        }


        // deletion can be done in three ways:
        // 1. from left end
        // 2. from right end
        // 3. one from each side
        // from left end (front) : we remove the elements from the left, so total of (rightIndex+1) deletion is required
        // from right end (back) : we remove the elements from the right, so total of (n-leftIndex) deletion is required
        // one from each end : one will deleted from left, so (left+1) and one from right (n-right)
        // -> so total deletion : (left+1) + (n-right)
        // final no of deletion will be the minimum of all three ways of deletion : Math.min(bothEnd, Math.min(left, right))


        // finding the first element to be removed from left
        int leftIdx = Math.min(minIdx, maxIdx);

        // finding the first element to be removed from right
        int rightIdx = Math.max(minIdx, maxIdx);

        // no of deletion from left end
        int left = rightIdx + 1;

        // no of deletion from right end
        int right = n - leftIdx;

        // no of deletion (one) from each end
        int bothEnd = (leftIdx + 1) + (n - rightIdx);

        return Math.min(bothEnd, Math.min(left, right));
        
    }
}