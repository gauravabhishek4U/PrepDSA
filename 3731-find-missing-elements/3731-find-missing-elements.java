/*
// Approach 1 : Sorting
// TC = O(n log n), SC = O(1)
class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        int currEle = nums[0];

        for(int i=0; i<n; currEle++, i++){
            if(currEle < nums[i]){
                ans.add(currEle);
                i--;
            }
        }
        return ans;
    }
}

*/

// Optimal Approach : Binary Array
// TC = O(n + R), where R = max-min+1
// SC = O(1)

// while traversing the array, we find minimum and maximum values
// finally iterate from min to max and check if the number is marked or not
// if not marked, then add it to the final answer list.

class Solution{
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        boolean[] contains = new boolean[101];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int element : nums){
            min = Math.min(min, element);
            max = Math.max(max, element);
            contains[element] = true;
        }

        for(int i=min; i<=max; i++){
            if(!contains[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}

