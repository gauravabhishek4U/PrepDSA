class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        List<Integer> ans = new ArrayList<>();

        if(sLen < pLen){
            return ans;
        }

        // initialise Frequency Arrays for both strings
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // create first window
        for(int i = 0; i < pLen; i++){
            sFreq[s.charAt(i) - 'a']++;
            pFreq[p.charAt(i) - 'a']++;
        }

        // check first window if they are equal
        if(Arrays.equals(sFreq, pFreq)){
            ans.add(0);
        }

        // create second and further sliding windows
        for(int i = pLen; i < sLen; i++){
            sFreq[s.charAt(i) - 'a'] ++; // adding the element at right
            sFreq[s.charAt(i - pLen) - 'a'] --; // removing the element at left

            // compare if this array of window elements exists in pFreq
            if(Arrays.equals(pFreq, sFreq)){
                ans.add(i-pLen+1);
            }
        }
        
        return ans;
    }
}