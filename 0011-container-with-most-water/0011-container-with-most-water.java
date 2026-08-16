// Approach : Two Pointer
// TC = O(N)
// SC = O(1)

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1, maxArea = 0;

        while(left < right){
            // calculating the minimum height between left and right
            int ht = Math.min(height[left], height[right]);
            int width = right - left;
            int area = ht * width;
            maxArea = Math.max(maxArea, area);

            // remove the smaller height to look for a greater height, so maxArea can be maximised
            if(height[left] >= height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
}