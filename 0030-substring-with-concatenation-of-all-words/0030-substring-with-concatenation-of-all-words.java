/*
Approach : Sliding window the hashMap for maintaining the count and occurences
TC = O(N * k), where k is the length of each word (Since we are running an outer loop k times)
SC = O(N) 
Solve : 2
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordSize = words[0].length(); // it is the length of each word in words array
        int wordCount = words.length; // it is the length of entire words array
        int sLen = s.length(); // it is the length of string s

        // Base case : when either words[] array or string 's' OR both are of size 0
        if(wordCount == 0 || sLen == 0){
            return ans;
        }

        // create hashMap to store elements of words[] array
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for(int i = 0; i < wordCount; i++){
            wordsMap.put(words[i], wordsMap.getOrDefault(words[i],0)+1);
        }


        // iterate from 0 to size of element in words[] array e.g., 0 to 2
        for(int i = 0; i < wordSize; i++){
            HashMap <String, Integer> currWindowMap = new HashMap<>();

            int left = i;
            int count = 0; // counter to keep check of how many elements of words[] array have been found

            // expansion phase of sliding window
            // here, we have to consider each word of size worsdSize as single element
            // that's why right pointer is increasing by right + wordSize

            for(int right = i; right + wordSize <= sLen; right += wordSize){
                String currWord = s.substring(right, right + wordSize);

                // if this new current word exists in words[] array
                // then it must be present as element in map created for storing elements of words[] array
                // therefore, if currWord exists in hashmap wordsMap
                // then add it in currentWordMap for further verification
    
                if(wordsMap.containsKey(currWord)){
                    currWindowMap.put(currWord, currWindowMap.getOrDefault(currWord, 0)+1);
                    count++;

                    // shrinking phase of sliding window
                    // until the frequency of current word in currentWindowMap is greater than the frequency of current word in actual words map (wordsMap)
                    // remove the word formed with the substring created in that sliding window from currentWindowMap
                    // increment the left pointer by left + wordSize
                    // and decrease the count which stores the no of words found in the given input string  

                    while(currWindowMap.get(currWord) > wordsMap.get(currWord)){
                        String wordFromLeft = s.substring(left, left + wordSize);
                        currWindowMap.put(wordFromLeft, currWindowMap.get(wordFromLeft) -1);

                        left += wordSize;
                        count--;
                    }

                    if(count == wordCount){
                        ans.add(left);
                    }
                }

                // if this new current word does NOT exist in words[] array
                // then just move ahead the left pointer to the starting index of new candidate word which is left = right + wordSize
                // and clear the map, so that it only contains details of new word 
                else{
                    count = 0;
                    left = right + wordSize;
                    currWindowMap.clear();
                }
            }
        }
        return ans;
    }
}