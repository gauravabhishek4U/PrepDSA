/*
Approach: Recursion + Memoization
T.C : O(m*n)
S.C : O(m*n)
solved : 1
*/

class Solution {
    int[][] dp = new int[1001][1001];
    int solve(String s, String t, int m, int n) {

        // if we have reached till the end of string t
        if(n == 0)
            return dp[m][n] = 1;

        // if we have reached till the end of string s
        if(m == 0)
            return dp[m][n] = 0;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        /*
        if character at s and t matches, then check for two conditions:
        -> if next character of s matches with the next character of t
        -> if nect character of s matches with the same character of t
        */
       if(s.charAt(m-1) == t.charAt(n-1))
            return dp[m][n] = solve(s, t, m-1, n) + solve(s, t, m-1, n-1);

        // if the present character of s and t does not match
        else
            return dp[m][n] = solve(s, t, m-1, n);
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // if length of s is smaller than length of t, then there will be no subsequence
        if(m < n)
            return 0;

        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(s, t, m, n);
    }
}

