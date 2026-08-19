/*
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
*/

// Approach : Using HashMap
// TC = O(N)
// SC = O(N)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // iterating the map using only values
        for(Integer value : map.values()){
            if (value > 1){
                return true;
            }
        }

        return false;
        
    }
}