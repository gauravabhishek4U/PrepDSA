/*
Approach: HashMap freq count
TC = o(N)
SC = O(1)
Solve = 1
*/
/*
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
*/

/*
Approach : Counting and Switch statement for matching
TC : O(N), N = length of string text
SC = O(1)
*/
class Solution{
    public int maxNumberOfBalloons(String text){

        // creating variables to store count
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for(char ch : text.toCharArray()){
            switch (ch){
                case 'b' :
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
            }
        }

        // the minimum value of these counter will be the possible no of times the word 'balloon' can be instantiated from the input text
        // divide 'l' and 'o' by 2 as it appears twice in word "balloon"

        return Math.min(b, Math.min(a, Math.min(n, Math.min(l/2, o/2))));
    }

}