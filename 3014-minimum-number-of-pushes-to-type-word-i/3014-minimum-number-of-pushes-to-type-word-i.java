// word contains distinct lowercase english letters
// each letter is mapped to only one key
// so for first 8 letters : 1 push,
// second set of 8 letters : 2 push
// third set of 8 letters : 3 push
// last 2 letters : 4 push
// TC : O(1), SC = O(1)
class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;

        if(n<=8)
            ans = n;
        else if(n<=16)
            ans = 8 + (n-8)*2;
        else if( n <= 24)
            ans = 24 + (n-16)*3;
        else 
            ans = 48 + (n-24)*4;
        
        return ans;
    }
}