class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        long maxSum = 0, currSum = 0;
   //     Map <Integer, Integer> mpp = new HashMap<>();
        Set<Integer> set = new HashSet<>();

// USING MAP
        // for(right = 0; right < n; right++){
        //     // add the current element in the window sum
        //     currSum += nums[right];
        //     mpp.put(nums[right], mpp.getOrDefault(nums[right],0)+1);

        //     // if size of window exceeds K
        //     //shrink the window by removing one element from left
        //     // calculate the new sum and increase the left pointer
        //     if(right - left + 1 > k ){
        //         mpp.put(nums[left], mpp.get(nums[left])-1);
        //         if(mpp.get(nums[left]) == 0){
        //             mpp.remove(nums[left]);
        //         }
        //         currSum -= nums[left];
        //         left++;
        //     }

        //     // if window size is valid (equals to K)
        //     if(right-left+1 == k && mpp.size()==k){
        //         maxSum = Math.max(maxSum,currSum);
        //     }
        // }

        while(right<n){
            // add it to current window sum
            currSum += nums[right];

            // if set already contains the element or size exceeds the given K
            // then decrease the sum and remove it from set
            while((set.contains(nums[right]) || set.size() >=k)) {
                currSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            // else if element doesn't exist in set
            // then add the element to the set
            set.add(nums[right]);

            if(set.size() == k){
                maxSum = Math.max(maxSum,currSum);
            }

            right++;

        }

        return maxSum;
        
    }
}