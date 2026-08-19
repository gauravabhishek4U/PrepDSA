class Solution {
    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();
/*
        Map <Character, Integer> nMap = new HashMap<>();
        Map <Character, Integer> hMap = new HashMap<>();

        // creating hashMap for needle, storing characters with their frequency 
        for(int i = 0; i < nLen; i++){
            char ch = needle.charAt(i);
            nMap.put(ch, nMap.getOrDefault(ch, 0)+1);
        }

        // initializing left and right for two pointers
        int left = 0, right = 0;

        while(right < hLen){
            char ch = haystack.charAt(right);

            // creating hashMap for haystack, storing characters with their frequency
            hMap.put(ch, hMap.getOrDefault(ch, 0)+1);

            // if size of both maps is equal, then we may get a potential answer
            if(hMap.size() == nMap.size()){

                // checking if both maps are equal, then return the starting index which is left index
                if(hMap.equals(nMap)){
                    return left;
                }

                // if maps are not equal, then increment left to right, clear the map and increment right by 1
                else{
                    left = right;
                    right++;
                    hMap.clear();
                }
            }
            right++;
        }
        return -1;

        */
        int left = 0;
        for(left = 0; left <= hLen - nLen; left++){
            for(int right = left; right <= left + nLen; right++){
                String temp = haystack.substring(left, right);

                if(temp.equals(needle)){
                    return left;
                }
            }
        }
        return -1;
    }
}