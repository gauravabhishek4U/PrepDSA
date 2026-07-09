class Solution {
    public int captureForts(int[] forts) {
        int max = 0; // tracks the maximum number of captured forts
        int prev = -1; // tracks the index of the last seen non-zero fort

// TC : O(N) , SC : O(1)
   

// Iterate through each index i in forts
    // If forts[i] is not 0 it means we found an army (1) or an empty position (-1)
    // If prev is not -1 and forts[prev] + forts[i] == 0 the two endpoints are opposites (one is 1 and the other is -1) meaning we have a valid capture range
    // Calculate dist as i - prev - 1 the number of enemy forts (0) between the two endpoints
    // Update max if dist is greater than the current max
    // Update prev to i to mark the current position as the last seen non-zero fort
    // Return max as the result


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