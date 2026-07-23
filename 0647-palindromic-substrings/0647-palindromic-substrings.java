/*

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

// BRUTE FORCE APPROACH :: Iterate through each substring and check if its palindrome
// TC :: O(N^2) for iterating and N/2 for isPalindrome fnc..so O(N^3)/2 i.e., N cube divided by 2
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isPalindrome(s, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
*/


// OPTIMAL APPROACH :: TC = O(N) AND for expand fnc its N/2, 
// so final TC :: O(N^2)

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0; i<n; i++){
            count += expand(s, i, i); // for odd length string
            count += expand(s, i, i+1); // for even length string
       
        }
        return count;
    }

    private int expand(String s, int left, int right){
        int count = 0;

        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }

}