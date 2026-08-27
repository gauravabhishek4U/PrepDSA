class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        int ans = nums[0];

        // Base case : if there is only one element in nums, return it as answer
        if(n == 1){
            return ans;
        }
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) +1);
        }

        for(int i = 0; i<n; i++){
            int count = freq.get(nums[i]);
            if(count > n/2){
                ans = nums[i];
            }
        }
         return ans;
    }
}