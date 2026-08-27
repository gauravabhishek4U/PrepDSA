/*
Approach : Sliding Window + HashMap
TC = O(N), where N = length of string s
SC = O(N)
Solved: 1
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        List<Integer> ans = new ArrayList<>();

        if(sLen < pLen){
            return ans;
        }

        // create hashmaps to store frequency of characters for both strings
        HashMap <Character, Integer> sMap = new HashMap<>();
        HashMap <Character, Integer> pMap = new HashMap<>();

        // create first window
        for(int i = 0; i < pLen; i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) +1);
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) +1);
        }

        // check first window (index 0) if they are equal
        if(sMap.equals(pMap)){
            ans.add(0);
        }

        int left = 0, right = pLen;

        while(right < sLen){
            char rightChar = s.charAt(right);

            // expansion phase of sliding window
            // add the character present at right index into the map
            sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) +1);

            // shrinking phase of sliding window
            // if size of window is greater than pLen, then shrink the window
            while(right - left +1 > pLen){
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) -1);
                if(sMap.get(leftChar) == 0){
                    sMap.remove(leftChar);
                }
                left++;
            }

            // if map for new window is equal to pMap, then add the left index to answer list
            if(sMap.equals(pMap)){
                ans.add(left);
            }
            right++;
        }
        
        return ans;
    }
}