/*
Approach 1: Count Matching using Frequency Array
TC = O(N), N is the length of input String s
SC = O(1)
Solved : 1


class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        // Base case  = if length of target is greater than length of String s, return 0
        if(s.length() < target.length()){
            return 0;
        }

        int minVal = Integer.MAX_VALUE;

        // creating frequency array to store count
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        
       
        for(char ch : s.toCharArray()){
            sFreq[ch - 'a']++;
        }

        for(char ch : target.toCharArray()){
            tFreq[ch - 'a']++;
        }
        

        // checking if characters of string s exists in the target string
        for(int i = 0; i < 26; i++){

            // if it exists, then calculate how many instances of target string can be formed.
            // the minimum value of all the candidate frequencies will be the possible final number of instances that can be created.

            if(tFreq[i] > 0){   
                minVal = Math.min(minVal, sFreq[i] / tFreq[i]);
            }
        }
        return minVal;
    }
}

*/

/*
Approach 2: Using hashMaps
TC = O(N), N is the length of input String s
SC = O(N)
Solved : 1
*/
class Solution {
    public int rearrangeCharacters(String s, String target) {

        // hashmap to store frequency of characters in string s
        HashMap <Character, Integer> sMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);
        }

        // hashmap to store frequency of characters in string target
        HashMap <Character, Integer> tMap = new HashMap<>();
        for(char ch : target.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }

        int maxCopies = Integer.MAX_VALUE;

        // calculating the number of available and required frequency for each character in target
        for(char ch : tMap.keySet()){
            int available = sMap.getOrDefault(ch,0);
            int required = tMap.get(ch);

            maxCopies = Math.min(maxCopies, available / required);
        }

        return maxCopies;
    }
}