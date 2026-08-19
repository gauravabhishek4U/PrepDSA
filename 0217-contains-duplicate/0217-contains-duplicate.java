// Approach : Using HashSet
// TC = O(N)
// SC = O(N)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> stt = new HashSet<>();
        for(int num : nums){
            stt.add(num);
        }

        return (nums.length == stt.size() ? false : true);
        
    }
}