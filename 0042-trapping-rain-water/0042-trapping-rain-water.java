/*
Optimised Approach : Using two pointers and not maintaining leftMax and rightMax for each index, reducing the no of passes via two pointer
TC = O(N)
SC = O(1) 
*/
class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int totalHeight = 0;

        // initializing two pointers left and right for traversal
        int left = 0, right = n-1;

        // initializing variables to store the max height from both ends (leftEnd & rightEnd)
        int leftMax = height[left], rightMax = height[right];

        // traversing until left and right pointers do not meet or cross each other
        while(left < right){

            // if rightEnd height is greater than leftEnd height,
            // then find a bigger height on the left side which can store more water
            // add the new leftEnd max height in total height
            // decrease the leftSide height which is considered twice
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalHeight += leftMax - height[left];
            }

            // if leftEnd height is greater than rightEnd height,
            // then find a bigger height on the right side which can store more water
            // add the new rightEnd max height in total height
            // and decrease the rightSide height which is considered twice
            else{
                right --;
                rightMax = Math.max(rightMax, height[right]);
                totalHeight += rightMax - height[right];
            }
        }

        return totalHeight;
    }
}