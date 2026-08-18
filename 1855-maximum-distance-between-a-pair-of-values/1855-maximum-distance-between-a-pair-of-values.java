// TC = O(n+m)
// SC = O(1)

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int i = 0, j = 0, ans = 0;

        // condition to keep both arrays in the given bound
        while(i<n && j<m){

            // increment i, we will get smaller integer ahead as it is a non-increasing array
            if(nums1[i] > nums2[j]){
                i++;
            }
            else{
                ans = Math.max(ans, j-i);
                j++;
            }
        }
        return ans;
    }
}