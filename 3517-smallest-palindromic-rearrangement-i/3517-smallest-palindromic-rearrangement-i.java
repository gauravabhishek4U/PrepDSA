/*

// Better Approach (Split in half , Sort and form palindrome)
//T.C : O(n log n)
//S.C : O(1) (ignoring the space taken for sorting internally)
class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n/2;

        // create the left half of the array
        // Sort the given string from index 0 to index mid
        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, mid); // here mid is not included. It is [0, mid)
    

        // create the right half of the array
        for(int i=0; i < mid; i++){
            chars[n-1-i] = chars[i];
        }

        return new String(chars);       
    }
}

*/

// Optimal Approach : create Frequency array, we only need characters that belong to first half of the palindrome
// By traversing the frequency array from 'a' to 'z', we automatically construct the smallest possible first half in lexographical order.
// TC = O(N), SC = O(N)

/*
class Solution{
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // count the frequency of the each character
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = '\0';

        // Build left half and final middle character
        for(int i=0; i<26; i++){
            for(int j=0; j<freq[i]/2; j++){
                left.append((char)('a'+i));
            }

            // store the odd frequency character (if any)
            if(freq[i]%2 == 1){
                middle = (char)('a'+i);
            }
        }

        // Build the right half, which is the reverse of the left half
        StringBuilder right = new StringBuilder(left).reverse();

        // constructing the final answer
        if(middle != '\0'){
            return left.toString() + middle + right.toString();
        }

        return left.toString() + right.toString();
    }
}

*/

// Another solution for same frequency array approach

class Solution{
    public String smallestPalindrome(String s){
        int n = s.length();

        // if n is odd then midChar will be the char in the original string at index n/2 
        // else midChar will be an empty string.. like an imaginary line between two characters
        String midChar = (n & 1) == 1 ? s.charAt(n/2) + "" : "";

        StringBuilder leftHalf = new StringBuilder();
        int[] freq = new int[26];

        // creating frequency array till mid of the given string
        for(int i=0; i<n/2; i++){
            freq[s.charAt(i) - 'a']++;
        } 

        // building left half of the answer
        for(int i=0; i<26; i++){
            leftHalf.append(((char)(i+'a')+"").repeat(freq[i]));
        }

        // constructing final answer
        return leftHalf.toString() + midChar + leftHalf.reverse().toString();
    }
}