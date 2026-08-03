/*
//Approach-2 (Using Bottom Up Approach)
// TC = O(n)

class Solution {
   

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] t = new int[n + 1];
        t[n] = 0;

        for(int i= n-1; i >= 0; i--){
            t[i] = stoneValue[i] - t[i+1];

            if(i+1 < n){
                t[i] = Math.max(t[i], stoneValue[i] + stoneValue[i+1] - t[i+2]);
            }

            if(i+2 < n){
                t[i] = Math.max(t[i], stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - t[i+3]);
            }
        }

        int diff = t[0]; // Alice - Bob

        if(diff > 0) return "Alice";
        else if(diff < 0) return "Bob";

        return "Tie";
        
    }
}

*/


//Approach-3 (Convertin Approach-2 above to constant space)
class Solution {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int dp1 = 0; // dp[i+1]
        int dp2 = 0; // dp[i+2]
        int dp3 = 0; // dp[i+3]

        for (int i = n - 1; i >= 0; i--) {

            int curr = stoneValue[i] - dp1;

            if (i + 1 < n)
                curr = Math.max(curr,
                        stoneValue[i] + stoneValue[i + 1] - dp2);

            if (i + 2 < n)
                curr = Math.max(curr,
                        stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp3);

            dp3 = dp2;
            dp2 = dp1;
            dp1 = curr;
        }

        if (dp1 > 0) return "Alice";
        if (dp1 < 0) return "Bob";
        return "Tie";
    }
}