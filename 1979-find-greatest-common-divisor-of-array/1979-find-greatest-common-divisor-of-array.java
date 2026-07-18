class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        return gcd(max, min);
    }

    private int gcd(int max, int min){
        if (min == 0){
            return max;
        }
        
        return gcd(min, max % min);
    }
}