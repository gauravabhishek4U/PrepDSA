class Solution {

    private boolean isConcatenated(String word, Set<String> st, Map<String, Boolean> map){
        if(map.containsKey(word)){
            return map.get(word);
        }

        int len = word.length();

        // breaking each word into prefix and suffix combinations
        for(int i=0; i<len; i++){
            String prefix = word.substring(0, i+1);
            String suffix = word.substring(i+1, len);

            // checking for both possibilities
            // either both prefix and suffix exists in set
            // or prefix exists and suffix is further concatenated but exists in the set
            if((st.contains(prefix) && st.contains(suffix)) || (st.contains(prefix) && isConcatenated(suffix, st, map))){
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        Set <String> st = new HashSet<>();

        // Creating Map for memoization
        Map <String, Boolean> map = new HashMap<>();

        // adding every word from words array in the set
        for(String str : words){
            st.add(str);
        }

        List <String> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            String word = words[i];

            if(isConcatenated(word, st, map)){
                result.add(word);
            }
        }
        return result;
    }
}