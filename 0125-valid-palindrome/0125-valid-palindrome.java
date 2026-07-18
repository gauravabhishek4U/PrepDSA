class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        if(s == null || n == 1){
            return true;
        }

        // Approach 1 : Using in-built method and regex
        // Clean the string: remove non-alphanumeric characters and lowercase it
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if the cleaned string reads the same backwards
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        return cleaned.equals(reversed);

        

        //private final static Pattern NON_ALPHANUMERIC = Pattern.compile("[^a-zA-Z]");
       // private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^a-zA-Z0-9]");

    //    String copy =  s.toLowerCase();

        
       // NON_ALPHANUMERIC.matcher(copy).replaceAll("");

        // int left = 0, right = n-1;

        // while(left <= right){
        //     char leftChar = s.charAt(left);
        //     char rightChar = s.charAt(right);

        //     // if left char is not a character or digit
        //     if(!Character.isLetterOrDigit(leftChar)){
        //         left++;
        //     }

        //     // if right char is not a character or digit
        //     if(!Character.isLetterOrDigit(rightChar)){
        //         right--;
        //     }

        //     // if both are valid characters
        //     if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
        //         return false;
        //     }

        //     left++;
        //     right--;
            
        // }
        // return true;
    }
}