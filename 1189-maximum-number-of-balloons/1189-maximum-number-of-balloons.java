/*
Approach: HashMap freq count
TC = o(N)
SC = O(1)
*/
class Solution {
    public int maxNumberOfBalloons(String text) {
        
        HashMap <Character, Integer> map = new HashMap<>();

        String word = "balon";

        for(char ch : word.toCharArray()){
            map.put(ch, 0);
        } 

        for(char ch : text.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
        }

        int minValue = Integer.MAX_VALUE;
        int freqL = 0, freqO = 0;

        for(var entry : map.entrySet()){
            minValue = Math.min(minValue, entry.getValue());

            if(entry.getKey() == 'l'){
                freqL = entry.getValue();
            }

            if(entry.getKey() == 'o'){
                freqO = entry.getValue();
            }
        }

        // checking the frequency for character L and O
        if(freqL < 1 || freqO < 1){
            return 0;
        } 

        return Math.min(minValue, Math.min(freqL/2, freqO/2));
    }
}