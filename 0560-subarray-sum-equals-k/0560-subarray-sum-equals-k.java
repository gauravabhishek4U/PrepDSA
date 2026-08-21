/*
Approach : Prefix Sum
TC = O(N)
SC = O(N)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, count = 0;

        Map <Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        for(int i = 0; i < n; i++){
            sum += nums[i];
            int restSum = sum - k;

            if(freq.containsKey(restSum)){
                count += freq.get(restSum);
            }

            freq.put(sum, freq.getOrDefault(sum,0)+1);
        }

        return count;
    }
}