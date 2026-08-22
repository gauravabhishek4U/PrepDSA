/*
Approach : Prefix sum
TC = O(N)
SC = O(N)
*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum=0;

        // for storing like fist value is reminder zero so we can keep track   or sum%k==0 
        map.put(0,1);  

        for(int i=0; i<nums.length; i++){
            prefixSum+=nums[i];

            // handle negative value of (prefixSum - k)
            // int searchValue=  (( prefixSum%k )+k )  %k ;
            int searchValue = Math.floorMod(prefixSum, k);

            // searching if it exists in hashmap
            if(map.containsKey(searchValue)){
                count = count+ map.get(searchValue);
            }
            // adding the value of (prefixSum % k)
            map.put(searchValue,map.getOrDefault(searchValue,0)+1);
        }

        return count;
    }
}