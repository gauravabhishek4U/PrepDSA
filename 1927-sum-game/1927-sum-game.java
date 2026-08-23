/*
Approach : Greedy
TC = O(N)
SC = O(1)
*/
class Solution {
    public boolean sumGame(String num) {

        int n = num.length();

        int leftSum = 0, rightSum = 0;
        int qnLeft = 0, qnRight = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                if(i < n/2){
                    qnLeft++;
                }
                else{
                    qnRight++;
                }
            
            }
            // ch is a number
            else {
                if(i < n/2){
                    leftSum += ch - '0';
                }
                else{
                    rightSum += ch - '0';
                }
            }
        }

        int qnTotal = qnLeft + qnRight;

        // checking no of qstn marks is even or odd 
        if (qnTotal % 2 == 1) { // if it odd, Alice wins
            return true;
        }

        int left = (2 * leftSum) + (9 * qnLeft);
        int right = (2 * rightSum) + (9 * qnRight);

        if (left == right){
            return false; // BOB wins
        }

        // Otherwise Alice wins
        return true;
    }
}