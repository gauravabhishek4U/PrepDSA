/*
Approach : Prefix Sum with hashMap
TC = O(N)
SC = O(N)
*/
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int cntOne=0,cntZero=0;
        int ans=0;
        Map<Integer,Integer>map=new HashMap<>();

        // counting no of zeros and ones and finding the difference to check if it has appeared before that index i
        for(int i=0; i<n; i++){
           if(nums[i]==0){
            cntZero++;
           }
           else{
            cntOne++;
           }

           int diff = cntZero-cntOne;

           if(diff==0){
               ans=Math.max(ans,i+1);
           }

           if(map.containsKey(diff)){
               int idx= map.get(diff);
               int len=i-idx;
               ans=Math.max(len,ans);
           }else{
               map.put(diff,i);
           }
        }
        return ans;
    }
}