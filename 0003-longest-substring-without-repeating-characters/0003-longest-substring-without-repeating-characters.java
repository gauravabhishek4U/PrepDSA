/*
Approach: sliding window and hashMap
TC = O(N)
SC = O(N)
Solved = 2
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        // edge case
        if(n==1) return n;

        int left=0, right=0;
        HashMap <Character, Integer> map = new HashMap<>();
        int ans = 0;

        while(right < n){

            // expand the window by adding element from the right
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            // shrink the window
            // if ch exists in map, then remove characters from left end
            // remove it from map and increase left pointer
            while(map.get(ch)>1){
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar)-1);
                left++;
            }

            // calculate the longest substring length and increment right pointer
            ans = Math.max(ans, right-left+1);
            right++;
            
        }
        return ans;
    }
}