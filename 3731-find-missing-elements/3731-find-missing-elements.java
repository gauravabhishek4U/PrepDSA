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



