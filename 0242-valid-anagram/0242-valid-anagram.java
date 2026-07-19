class Solution {
    public boolean isAnagram(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen){
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        // insert element in map for string s
        for(int i = 0; i < sLen; i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        }

        // insert element in map for string t
        for(int i = 0; i < tLen; i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }

        // compare if both maps are equal (identical keys with identical values, same size)
        if(!tMap.equals(sMap)){
            return false;
        }
        return true;
        
    }
}