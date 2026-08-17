/*
// Approach 1 : Using in-Built Methods
// TC = O(n)

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");

        String result = "";
        for(int i = words.length -1; i>=0; i--){
            result += words[i];
            if(i>0){
                result += " ";
            }
        }
        return result;
    }
}

*/

// Approach 2 : Using iteration and in-Built Methods
class Solution {
    public String reverseWords(String s) {

        // splitting the string into words and storing in word array
        String[] words = s.split("\\s+");
        StringBuilder ans = new StringBuilder();

        // iterating over the words array in reverse order
        for(int i = words.length -1; i>=0; i--){

            // adding each word into result string
            ans.append(words[i]);

            // adding spaces between words
            if(i != 0){
                ans.append(" ");
            }
        }

        // returning the final ans string by trimming any whitespaces
        return ans.toString().trim();
    }
}