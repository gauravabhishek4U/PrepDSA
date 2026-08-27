/*
Approach 1 : using hashmap
TC = O(N)
SC = O(N), for storing entire N elements of nums in hashMap
Solved : 1
*/

/*
class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        int ans = nums[0];

        // Base case : if there is only one element in nums, return it as answer
        if(n == 1){
            return ans;
        }
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) +1);
        }

        for(int i = 0; i<n; i++){
            int count = freq.get(nums[i]);
            if(count > n/2){
                ans = nums[i];
            }
        }
         return ans;
    }
}
*/

/*
Approach 2 : Moore Voting Algorithm, using two variables
TC: O(N)
SC = O(1)
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, result = 0;

        for(int num : nums){
            if(count == 0){
                result = num;
            }

            if(num != result){
                count--;
            }
            else{
                count++;
            }
        }
        return result;
    }
}