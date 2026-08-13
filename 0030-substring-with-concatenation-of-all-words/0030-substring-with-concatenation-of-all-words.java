/*

Approach : Sliding window the hashMap for maintaining the count and occurences
TC = O(N * k), where k is the length of each word (Since we are running an outer loop k times)
SC = O(N) 

*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordSize = words[0].length();
        int wordCount = words.length;
        int sLen = s.length();

        // Base case when either or both string and words[] is of size 0
        if(wordCount == 0 || sLen == 0){
            return ans;
        }

        HashMap<String, Integer> wordsMap = new HashMap<>();

        // creating the original words map
        for(int i = 0; i < wordCount; i++){
            wordsMap.put(words[i], wordsMap.getOrDefault(words[i],0)+1);
        }


        for(int offset = 0; offset < wordSize; offset++){
            HashMap <String, Integer> currWindowMap = new HashMap<>();

            int start = offset;
            int count = 0;

            for(int end = offset; end + wordSize <= sLen; end += wordSize){
                String currWord = s.substring(end, end + wordSize);

                if(wordsMap.containsKey(currWord)){
                    currWindowMap.put(currWord, currWindowMap.getOrDefault(currWord, 0)+1);
                    count++;

                    while(currWindowMap.get(currWord) > wordsMap.get(currWord)){
                        String startWord = s.substring(start, start + wordSize);
                        currWindowMap.put(startWord, currWindowMap.get(startWord) -1);

                        start += wordSize;
                        count--;
                    }

                    if(count == wordCount){
                        ans.add(start);
                    }
                }
                else{
                    count = 0;
                    start = end + wordSize;
                    currWindowMap.clear();
                }
            }
        }
        return ans;
    }
}