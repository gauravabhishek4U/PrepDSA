//Approach-1 (Recur+Memo) O(n^2) - Standard Optimal Game Strategy Concept
//T.C : O(n^2)
//S.C : O(n^2)
class Solution {

    int[][] t = new int[501][501];

    public boolean stoneGame(int[] piles) {
        int sum = 0;
        int n = piles.length;
        
        for (int[] row : t)
            Arrays.fill(row, -1);

        for(int pile : piles){
            sum += pile;
        }

        int aliceScore = solve(piles, 0, n-1);

        // If Alice's score is more than half of the total sum, then Alice has more no of stones than Bob
        return aliceScore > sum/2;
    }

    private int solve(int[] piles, int i, int j){
        if(i>j){
            return 0;
        }

        if (t[i][j] != -1){
            return t[i][j];
        }

        /*
            That's how optimal game strategy works. Expect your opponent to be playing optimally
            -When it's your turn, do your best
            -When it's your opponent's turn, expect the worst (that's why min() is taken below)
        */

        // if alice chooses i first, then Bob can choose either next i, or first j
        // so next options for Alice will be either i+2 to j OR i+1 to j-1 respectively
        int choose_i = piles[i] + Math.min(solve(piles, i+2, j), solve(piles, i+1, j-1));

        // if Alice chooses j first, then Bob can choose either first i or next j
        // so next option for Alice will be either i+1 to j-1 OR i to j-2 respectively
        int choose_j = piles[j] + Math.min(solve(piles, i+1, j-1), solve(piles, i, j-2));

        return t[i][j] = Math.max(choose_i, choose_j);

    }
}