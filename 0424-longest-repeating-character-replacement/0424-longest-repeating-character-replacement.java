/*
Approach : Optimal approach, using sliding window
TC = O(N)
SC = O(N)
Solved : 2
*/
class Solution {
    public int characterReplacement(String s, int k) {

        int ans = 0, maxFreq= 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int low =0, high = 0;

        for(high = 0; high < s.length(); high++){
            char c = s.charAt(high);
            map.put(c, map.getOrDefault(c ,0) +1);
            maxFreq = Math.max(maxFreq, map.get(c));

            // shrinking phase
            
            // maxFreq is the maximum number of occurrence for any of the elements seen so far, eg : 3
            // high-low+1 denotes the size of the window at present, eg : 6
            // (window size - maxFreq) is the size of window with different elements of lesser frequencies
            // so if (window size - maxFreq) is greater than K, it means window with different elements is greater than K
            // so remove those elements from left and decrease its frequency from map
            // and increase the left pointer to point at the next element

            while((high-low+1)-maxFreq > k){
                char left = s.charAt(low);
                map.put(left, map.get(left) -1);
                low++;
            }
            
            ans = Math.max(ans, high-low+1);
        }

        return ans;
    }
}