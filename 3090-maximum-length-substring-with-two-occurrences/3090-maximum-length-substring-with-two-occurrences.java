class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        if(n == 2){
            ans=2;
            return ans;
        }

        int left = 0;
        HashMap <Character, Integer> mpp = new HashMap<>();

        for(int right = 0; right < n; right++){
            char rightChar = s.charAt(right);
            mpp.put(rightChar, mpp.getOrDefault(rightChar, 0)+1);
            
            while(mpp.get(rightChar) > 2){
                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar)-1);
                left++;
            }

            ans = Math.max(ans, right-left+1);

        }
        return ans;
        
    }
}