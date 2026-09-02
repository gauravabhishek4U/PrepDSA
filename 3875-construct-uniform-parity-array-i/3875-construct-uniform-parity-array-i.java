/*
Approach : Odd-Even Parity
TC : O(1)
SC : O(1)

If all numbers are even → already valid.
If all numbers are odd → already valid.
If both odd and even exist → subtract an opposite-parity number to change the parity.
So it is always possible.
The answer is Always true.

*/

class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}