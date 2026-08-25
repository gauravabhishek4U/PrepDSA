/*
Approach: HashSet
TC = O(N)
SC = O(N)

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        int cur = k;
        while (seen.contains(cur)) {
            cur += k;
        }

        return cur;
    }
}

*/

/*
Approach : Array Search
TC = O(N^2)
SC = O(1)


class Solution {
    public int missingMultiple(int[] nums, int k) {

        // checking for multiples of k
        for (int value = k; ; value += k) {
            boolean found = false;

            // checking for each element present in nums if it equals the multiple of k
            for (int num : nums) {
                if (num == value) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return value;
            }
        }
    }
}

*/

/*
Approach : Boolean Array
TC = O(n)
SC = O(1)
*/
class Solution{
    public int missingMultiple(int[] nums, int k){
        
        boolean[] seen = new boolean[101];

        for(int num:nums){
            seen[num] = true;
        }

        for(int value = k; ; value += k){
            if(value > 100 || !seen[value]){
                return value;
            }
        }
      
    }
}