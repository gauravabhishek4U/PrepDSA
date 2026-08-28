/*
Approach-3 (using frequency array and counting)
T.C : O(n)
S.C : O(26) ~= O(1)
Solved : 3
*/
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();

        // Base case : if both strings are equal., no swapping is needed
        if (s1.equals(s2)) {
            return true;
        }

        int diffs = 0;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs++;
            }

            if (diffs > 2)
                return false;

            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}

