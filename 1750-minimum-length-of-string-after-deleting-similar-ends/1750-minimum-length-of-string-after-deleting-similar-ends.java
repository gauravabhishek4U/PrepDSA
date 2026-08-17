// Approach : Two Pointers
// TC = O(n)
// SC = O(1)

class Solution {
    public int minimumLength(String s) {

        int n = s.length();

        int left = 0, right  = n-1;

        while(left < right && s.charAt(left) == s.charAt(right)){
            char ch = s.charAt(left);

            // extend the length of prefix from left end if same character is present
            while(left < right && s.charAt(left) == ch){
                left++;
            }

            // extend the length of suffix from right end if same character is present
            while(right >= left && s.charAt(right) == ch){
                right--;
            }
        }

        // calculate the final remaining length
        return right-left+1;
    }
}