class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int k = set.size();
        
        return atmostK(nums, k) - atmostK(nums, k-1);
    }

    public int atmostK(int[] nums, int k){
            int left = 0, right = 0, count=0;
        Map <Integer, Integer> map = new HashMap<>();

        for(right = 0; right <nums.length; right++){
            map.put(nums[right],map.getOrDefault(nums[right], 0)+1);
            while(map.size() >k ){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right-left+1;

        }
        return count;
        }

}