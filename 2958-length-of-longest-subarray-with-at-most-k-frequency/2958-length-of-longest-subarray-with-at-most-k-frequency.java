// Approach : Sliding Window
// TC = O(n)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        int left=0;
        int ans = 0;

        // expansion phase of sliding window
        for(int right = 0; right<n; right++){
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0)+1);

            // shrinking phase of sliding window
            while(mpp.get(nums[right]) > k){
                mpp.put(nums[left], mpp.get(nums[left]) -1);
                left++;
            }

            // calculating ans by maximising the length of satisfactory window
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}