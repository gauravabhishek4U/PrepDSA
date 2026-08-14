// Approach : Sliding Window and HashMap
// TC : O(n), SC = O(n)
class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        // Base case when string s is just of size 2
        if(n == 2){
            ans=2;
            return ans;
        }

        int left = 0;
        HashMap <Character, Integer> mpp = new HashMap<>();

        // Expansion phase of sliding window and adding elements to map
        for(int right = 0; right < n; right++){
            char rightChar = s.charAt(right);
            mpp.put(rightChar, mpp.getOrDefault(rightChar, 0)+1);
            
            // shrinking phase of sliding window
            while(mpp.get(rightChar) > 2){
                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar)-1);
                left++;
            }

            // calculating the maximum possible answer
            ans = Math.max(ans, right-left+1);

        }
        return ans;    
    }
}