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
            // if map size is less than less than the original size of the string
            // then it means the string has duplicate characters

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