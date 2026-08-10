//Approach-1 (Recursion + Memoization)
//T.C : O(n*sqrt(n))
//S.C : O(n)
/*
class Solution {
    int[] t; //S.C : O(n)

    private boolean solve(int n) {
        if(n == 0) {
            return false;
        }
        if(t[n] != -1) {
            return t[n] == 1 ? true : false; //true if Alice wins, false if Bob wins
        }
        for(int k = 1; k*k <= n; k++) { //O(sqrt(n))
            
            // calling for Bob, after Alice has chosen k^2 stones
            // so for Bob, choice remains (n - k*k) stones
            // false means Bob lost and Alice won

            if(solve(n - (k*k)) == false) { //Call for Bob //False - Bob lost it
                //Alice won the game
                t[n] = 1;
                return true;
            }
        }

        // after every combination of choices, if we come out of for loop
        // it means Alice could never win and lost the game
        t[n] = 0;
        return false;
    }

    public boolean winnerSquareGame(int n) {
        t = new int[n+1];
        Arrays.fill(t, -1);

        // Calling for Alice as Alice makes the first move
        // If its true, Alice won
        // Else Alice lost and Bob won
        return solve(n); 
    }
}
*/


//Approach-2 (Bottom Up)
//T.C : O(n*sqrt(n))
//S.C : O(n)
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] t = new boolean[n+1]; //defaults to all false
        //Base case . n == 0, return false
        t[0] = false; //base case
        for(int i = 1; i < n+1; i++) {
            for(int k = 1; k*k <= i; k++) {
                if(t[i - (k*k)] == false) {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n]; //return solve(n)
    }
}
