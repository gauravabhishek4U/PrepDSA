/*
Approach: Math's Observation
TC : O(1)
SC = O(1)
Solved : 1
*/
class Solution {
    public int countCommas(int n) {
        int ans = 0;
        if(n<=999){
            return ans;
        }
        if(n >= 1000 && n<= 100000){
            int diff = n - 1000;
            ans = diff + 1;
        }
        return ans;
    }
}