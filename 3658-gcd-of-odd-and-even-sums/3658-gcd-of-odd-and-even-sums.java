class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumEven = n*(n+1);
        int sumOdd = n*n;

        int result = sumEven - sumOdd;
        return result;
        
    }
}