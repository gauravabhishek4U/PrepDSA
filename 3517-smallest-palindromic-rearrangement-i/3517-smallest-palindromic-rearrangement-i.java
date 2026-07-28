//Approach (Split in half , Sort and form palindrome)
//T.C : O(n log n)
//S.C : O(1) (ignoring the space taken for sorting internally)
class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n/2;

        // create the left half of the array
        // Sort the given string from index 0 to index mid
        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, mid); // here mid is not included. It is [0, mid)
    

        // create the right half of the array
        for(int i=0; i < mid; i++){
            chars[n-1-i] = chars[i];
        }

        return new String(chars);       
    }
}