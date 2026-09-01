/*
Approach : Two Pointer
TC = O(N)
SC = O(N)
Solved : 2
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int left = 0, right = n-1, k = n-1;

        while(k >= 0){

            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];

            // if left num square is greater than put it at Kth index of answer array
            // increase the left pointer
            if(leftNum > rightNum){
                ans[k] = leftNum;
                left++; 
            }

            // if right num square is greater than put it at Kth index of answer array
            // decrease the right pointer
            else{
                ans[k] = rightNum;
                right--;
            }

            // decrease the Kth pointer to insert element in answer array
            k--;
        }
        return ans;
    }
}