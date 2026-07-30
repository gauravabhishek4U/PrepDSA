class Solution {
    public int minimumPushes(String word) {
        //edge case if word length is less than 8 (2,3,4,5,6,7,8,9)
        int n = word.length();
        if (n<=8){
            return n;
        }

        int[] map = new int[26];
        int ans = 0;

        for(char ch : word.toCharArray()){
            map[ch-'a']++;
        }

        // converting int array map to Integer Array
        Integer[] mapInteger = Arrays.stream(map).boxed().toArray(Integer[] :: new);

        // sorting in descending order based on the frequency of characters in the given string
        Arrays.sort(mapInteger, Comparator.reverseOrder());

        // calculating the total number of pushes required
        for(int i=0; i<26; i++){
            ans += mapInteger[i] * ((i/8)+1);
        }
        return ans;
    }
}