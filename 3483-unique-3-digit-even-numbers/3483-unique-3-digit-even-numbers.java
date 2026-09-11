/*
Approach : Set and Number formation
TC : O(N^3)
SC : O(N)
Solved : 1
*/
class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<>();

        for(int h = 0; h < n; h++){

            // 0 cannot be the starting digit (at hundredth place) for a three-digit number
            if(digits[h] == 0) continue;

            for(int t = 0; t < n ; t++){

                // digits at hundred and tenth place cannot be same
                if(t == h) continue;

                for(int u = 0; u < n; u++){

                    // digits at unit place cannot be same as digit at hundred or tenth place
                    if(u == h || u == t) continue;

                    // if unit place digit is not even then skip it
                    if(digits[u] % 2 != 0) continue;

                    // form the final number
                    int num = digits[h] * 100 + digits[t] * 10 + digits[u];

                    // add it into the set for unique filteration 
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}