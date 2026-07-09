class Solution {
    public int captureForts(int[] forts) {
        int max = 0;
        int prev = -1;

        for (int i = 0; i < forts.length; i++) {

            if (forts[i] != 0) {
                if (prev != -1 && forts[prev] + forts[i] == 0) {
                    int dist = i - prev - 1;
                    max = max < dist ? dist : max;
                }
                prev = i;
            }
        }

        return max;
    }
}