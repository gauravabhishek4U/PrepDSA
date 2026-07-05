class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;

// BRUTE FORCE APPROACH : Maintain leftMax and rightMax for each index and calculate the total water trapped between these heights. TC : O(n^2)
       
        // for(int i=0; i<n; i++){
        //     int lMax = 0, rMax = 0;

        //     for(int j=0; j<=i; j++){
        //         lMax = Math.max(lMax, height[j]);
        //     }

        //     for(int j = i; j<n; j++){
        //         rMax = Math.max(rMax, height[j]);
        //     }

        //     total += Math.min(lMax, rMax) - height[i];
        // }

// OPTIMISED APPROACH : not maintaining leftMax and rightMax for each index, reducing the no of passes. TC = O(n)

        int left = 0, right = n-1;
        int leftMax = height[left], rightMax = height[right];

        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left];
            }
            else{
                right --;
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right];
            }
        }

        return total;
    }
}