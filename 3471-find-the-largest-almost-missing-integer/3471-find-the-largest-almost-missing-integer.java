class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int maxValue = -1;

        if(n == k){
            for(int i = 0; i<n; i++){
                maxValue = Math.max(maxValue, nums[i]);
            }
            return maxValue;
        }
        Map <Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int l=0; l <= n-k; l++){
            for(int r=l; r <= l+k-1; r++){
                map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            }
        }
        map.entrySet().stream().filter(entry -> entry.getValue() == 1).forEach(entry -> ans.add(entry.getKey()));
        
        if(ans.isEmpty()){
            return maxValue;
        }
        else{
            for(int i : ans){
                maxValue = Math.max(maxValue, i);
            }
        }

        return maxValue;
    }
}