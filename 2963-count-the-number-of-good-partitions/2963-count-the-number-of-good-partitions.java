//Approach (Using simple 2 Pointer)
//T.C : O(n)
//S.C : O(n)
class Solution {
    int M = 1000000007;

    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;

        // creating a map to store last index of every element
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            map.put(nums[i], i);
        }

        int left = 0;
        int right = Math.max(0, map.get(nums[0]));
        int ans = 1;

        while(left < n){
            if( left > right){
                ans = (int) ((ans * 2L) % M);
            }
            right = Math.max(right, map.get(nums[left]));
            left++;
        }
        return ans;
    }
}