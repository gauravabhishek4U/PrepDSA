class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;


        // Using two pointers method
        // Approach : Whenever characters match, we move inward. At the first mismatch, we have the option to skip either the left or the right character to try forming a palindrome.
        // TC :: O(N^2)/2 i.e., N sqaured divided by 2
        // SC :: O(1)
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // If s[left] != s[right], check if skipping left (s[left+1..right]) or right (s[left..right-1]) results in a palindrome using a helper function.

                // If either skip works or no mismatches occur, return true; otherwise, return false.


                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }  

    // TC = O(N/2)
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}