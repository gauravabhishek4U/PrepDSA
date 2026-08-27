/*
Approach: Greedy + Backtracking
TC: O(N)
SC: O(N)
*/

class Solution {
    String result = "";

    public String lexGreaterPermutation(String s, String target) {
        StringBuilder currStr = new StringBuilder();
        boolean greater = false;

        // creating frequency array to store element count in the given string
        int[] count = new int[26];

        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }

        solve(currStr, target, count, 0, greater);

        return result;
    }


    boolean solve(StringBuilder currStr, String target, int[] count, int i, boolean greater){

        // checking if i has reached to the end of target's length
        if(i == target.length()){

            // if greater flag is true, it means currStr is greater than target
            // in this case, store it in result and return true
            if(greater){
                result = currStr.toString();
                return true;
            }

            // else return false
            return false;
        }

        // checking for every character ch 
        for(char ch = 'a'; ch <= 'z'; ch++){

            // if character ch is not present in frequency array, then continue ( nothing can be done)
            if(count[ch - 'a'] == 0){
                continue;
            }

            if(greater == false && ch < target.charAt(i)){
                continue;
            }

            // if character ch is present in frequency array and it is greater than or equal to the character at index i in target string
            // then add it in the currentString and decrease the count in frequency array
            currStr.append(ch);
            count[ch - 'a'] --;

            // checking if greater flag is true or the character ch is greater than the character at index i in target string
            boolean isCurrStrGreater = greater || ch > target.charAt(i);

            // recursive calling of the solve function for next index
            if(solve(currStr, target, count, i+1, isCurrStrGreater)){
                return true;
            }

            // backtracking the currString in case it is same as the target string
            // if currStr is same as target string then remove the last character
            // increase the count for that character in the frequency array
            currStr.deleteCharAt(currStr.length()-1);
            count[ch - 'a']++;
        }

        // if all the character from 'a' to 'z' are checked for all indexes, and true is not returned, then return false at the end
        return false;
    }
}