// Approach : two pointer and string comparison
// TC = O(N), where N is the length of string haystack
// SC =  O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();

        int left = 0, right = 0;
        for(left = 0; left <= hLen - nLen; left++){
            for(right = left; right <= left + nLen; right++){
                String temp = haystack.substring(left, right);

                // // checking if both strings are equal, then return the starting index which is left index
                if(temp.equals(needle)){
                    return left;
                }
            }
        }
        return -1;
    }
}