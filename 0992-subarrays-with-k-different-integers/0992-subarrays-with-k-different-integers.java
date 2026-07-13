class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
        
    }

    public int atMostK(int[] nums, int k){
        int left = 0, right = 0;
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(right = 0; right<n; right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            // shrink the window if map size exceeds k
            while(map.size() > k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            // calculate total no of subarrays
            count += right-left+1;
        }
        return count;
    }
}