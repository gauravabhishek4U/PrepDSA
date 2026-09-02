/*
Approach : Mathematical Observation (Even-Odd parity)
TC = O(N)
SC = O(1)
Solved = 1
*/
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        int min = Integer.MAX_VALUE;
        boolean oddFlag = false;

        for(int num : nums1){
            if(num % 2 == 1){
                oddFlag = true;
            }
            min = Math.min(min, num);
        }

        // check if minimum element is a odd number
        // if yes, then all even elements can be converted to a odd number in num2
        if(min % 2 == 1){
            return true;
        }
        
        /*
        check if all elements in nums2 can be even number
        -> if all elements in nums1 is even, then its possible
        -> if there is atleast one odd element in nums1, then its not possible
        */

        if(oddFlag){
            return false;
        }

        // when all nums1 elements are even
        return true;
        
    }
}