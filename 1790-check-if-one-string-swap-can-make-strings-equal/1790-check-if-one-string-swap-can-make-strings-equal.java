/*
Approach-2 (using counting only. No map required)
T.C : O(n)
S.C : O(1)
Solved : 2
*/
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();

        if (s1.equals(s2)) {
            return true;
        }

        int diffs = 0;

        int firstIdx = 0;
        int secondIdx = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs++;

                if (diffs > 2) {
                    return false;
                } else if (diffs == 1) {
                    firstIdx = i;
                } else {
                    secondIdx = i;
                }
            }
        }

        // checking if characters at two different indexes are same in s1 and s2
        return s1.charAt(firstIdx) == s2.charAt(secondIdx) && s1.charAt(secondIdx) == s2.charAt(firstIdx);
    }
}