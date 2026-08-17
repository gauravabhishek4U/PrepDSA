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

/*
// Approach 2 : Using iteration and in-Built Methods
// TC = O(N)
// SC = O(N)

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

*/


// Approach 3 : two pointer and in built methods
// TC = O(n)
// SC = O(n)

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;

        // reversing the string using two pointer
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(word);
            }
        }

        return result.toString();
    }
}