class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        if(s == null || n == 1){
            return true;
        }

       /*
        // Approach 1 : Using in-built methods and regex
        // Clean the string: remove non-alphanumeric characters and lowercase it
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if the cleaned string reads the same backwards
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        return cleaned.equals(reversed);
        */

        
        // Best Optimal Soln : Using two pointers
        // change string to lowercase and remove everthing except a-z and 0-9
         s = s.toLowerCase().replaceAll("[^a-z0-9]","");
         int left = 0, right = s.length()-1;

        while(left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(leftChar != rightChar){
                return false;
            }

            left++;
            right--;
            
        }
        return true;
    }
}