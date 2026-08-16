class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;

        while(right < n){
            // unique element is found
            // increment left to make place for the unique element
            // swap element at left with the unique element
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
}