class Solution {
    public String minWindow(String s, String t) {
        
        Map <Character, Integer> tMap = new HashMap<>();

        // creating tMap
        for(char ch : t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }

        int left = 0, count = t.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> sMap = new HashMap<>();

        // expansion phase by RIGHT pointer 
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            // creating sMap
            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);

            // if right character exists in tMap and its frequency is greater or equal than frequency in sMap, then decrease the count
            if(tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)){
                count--;
            }

            // comparing the minimum length and framing the answer substring 
            while(count == 0){
                if(right - left +1 < minLen){
                    minLen = right-left+1;
                    ans = s.substring(left, right+1);
                }

                // shrinking phase by LEFT pointer
                char leftChar = s.charAt(left);

                // removing/decrementing the frequency of left character from sMap
                sMap.put(leftChar, sMap.get(leftChar)-1);

                // if it exists in tMap and frequency in sMap is lesser than tMap, then increase the count
                if(tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)){
                    count++;
                }
                left++;
            }
        }
        return ans;
    }
}