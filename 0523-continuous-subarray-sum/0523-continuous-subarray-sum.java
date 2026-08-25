class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map <Integer, Integer> map = new HashMap<>();
        int sum = 0;

        // to handle the case where subarray starts from index 0
        map.put(0, -1);

        for(int i = 0; i<n; i++){
            sum += nums[i];
            int rem = sum % k;

            if(map.containsKey(rem)){
                // to check if the size of subarray is greater than 1
                if( i - map.get(rem) > 1){
                    return true;
                }
            }
            else{
                map.put(rem, i);
            }
        }
        return false;
    }
}