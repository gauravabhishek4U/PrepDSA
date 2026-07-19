class Solution {
    public boolean isAnagram(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen){
            return false;
        }
/*
// Approach 1 : Using HashMaps and comapring them
    // TC :: O(N)

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

*/

// Approach 2 : sort strings by converting them into character arrays, then check if they are equal

    // convert to character array
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    // sort the character array
    Arrays.sort(sChars);
    Arrays.sort(tChars);

    // convert back to strings
    String newS = new String(sChars);
    String newT = new String(tChars);

    // check if they are equal
    if(!newS.equals(newT)){
        return false;
    }

    return true;      
    }
}