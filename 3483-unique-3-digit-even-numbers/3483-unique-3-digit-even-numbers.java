/*
Approach 1 : Set and Number formation
TC : O(N^3)
SC : O(M) — M = number of distinct valid numbers in the set
Solved : 1

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

*/

/*
Approach 2 : Using frequency array
TC : O(N)
SC : O(1)
*/

class Solution{
    public int totalNumbers(int[] digits){

        int[] freq = new int[10];

        // creating frequency array
        for(int d : digits){
            freq[d]++;
        }

        int count = 0;

        // digit selection for hundredth place
        for(int h = 1; h <= 9; h++){
            if(freq[h] == 0) continue;
            freq[h]--;

            // digit selection for tenth place
            for(int t = 0; t <= 9; t++){
                if(freq[t] == 0) continue;
                freq[t]--;
                
                // digit selection for unit place (should be even, so only 0,2,4,6,8 is allowed)
                for(int u = 0; u <= 8; u += 2){
                    if(freq[u] > 0){
                        count++;
                    }
                }
                // restore back the frequency for tenth place for next evaluation
                freq[t]++;
            }

            // restore back the frequency for hundredth place for next evaluation
            freq[h]++;
        }
        return count;
    }
}