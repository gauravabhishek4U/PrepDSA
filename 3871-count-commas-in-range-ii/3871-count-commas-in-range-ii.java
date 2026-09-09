/*
Approach : mathematical observation
TC : O(log10 N)
SC = O(1)
*/
class Solution {
    public long countCommas(long n) {
        if (n <= 999) return 0;

        long totalCommas = 0;
        long start = 1000;

        while (start <= n) {
            totalCommas += n - start + 1;
            start *= 1000;
        }

        return totalCommas;
    }
}