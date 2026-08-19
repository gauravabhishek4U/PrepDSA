// Approach : Two pointer and string comparison
// TC = O(N), N is the length of haystack
// SC = O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();

        // Corner case : if length of needle is greater than the length of haystack then NO occurrence will be found.
        // so return -1
        if(nLen > hLen){
            return -1;
        }

        int left = 0, right = 0;

        while(left <= hLen - nLen){
            right = left + nLen;

            String temp = haystack.substring(left, right);

            // checking if string temp is equal to string needle
            if(temp.equals(needle)){
                return left;
            }
            left++;
        }
       return -1; 
    }
}