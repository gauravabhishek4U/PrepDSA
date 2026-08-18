class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int maxValue = -1;

        // EDGE CASE : if window size and size of nums are equal, then simply return the maximum element
        if(n == k){
            for(int i = 0; i<n; i++){
                maxValue = Math.max(maxValue, nums[i]);
            }
            return maxValue;
        }

        Map <Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // create a hashmap to store the total frequency of each element across all possible windows
        for(int l=0; l <= n-k; l++){
            for(int r=l; r <= l+k-1; r++){
                map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            }
        }

        // filter out the elements with frequency == 1 and store them in list of answer
        map.entrySet().stream().filter(entry -> entry.getValue() == 1).forEach(entry -> ans.add(entry.getKey()));
        
        // if ans list is empty, return -1
        if(ans.isEmpty()){
            return maxValue;
        }

        // else find the maximum value from the ans list
        else{
            for(int i : ans){
                maxValue = Math.max(maxValue, i);
            }
        }

        return maxValue;
    }
}