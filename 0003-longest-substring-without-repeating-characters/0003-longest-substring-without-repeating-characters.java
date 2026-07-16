class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int len = s.length();
        int l=0, r=0;
        Set<Character> set = new HashSet<>();


        for( r=0; r<len; r++){
            // expand sliding window
            // if its not present in set, then add it in set
            // calculate the maximum length
            if(!set.contains(s.charAt(r)))
            {
                set.add(s.charAt(r));
                ans = Math.max(ans, r -l +1);
            }
            else{
                // shrink sliding window from left
                // if its present in set, remove the element from left end
                // increase left pointer
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                l++;
                }
                set.add(s.charAt(r));
            }
        }
        return ans;
    }
}