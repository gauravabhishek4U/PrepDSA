
//Approach-1 (Using simple resurion + memoization)
// TC = O(n)

class Solution {
    int n;
    // initializing DP array
    int[] t;

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        t = new int[n];
        Arrays.fill(t, Integer.MIN_VALUE);

        int diff = solve(stoneValue, 0); // Alice - Bob

        if(diff > 0) return "Alice";
        else if(diff < 0) return "Bob";
        else return "Tie";
        
    }

    private int solve(int[] stoneValue, int i){

        if(i == n)
            return 0;
        
        if(t[i] != Integer.MIN_VALUE)
            {return t[i];}
        
        t[i] = stoneValue[i] - solve(stoneValue, i+1);
        
        if(i+1 < n)
            t[i] = Math.max(t[i], stoneValue[i] + stoneValue[i+1] - solve(stoneValue, i+2));
        
        if(i+2 < n)
            t[i] = Math.max(t[i], stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - solve(stoneValue, i+3));
        
        return t[i];

    }
}

