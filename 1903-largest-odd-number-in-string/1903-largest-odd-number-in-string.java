class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        
        // traversing from last index to find the maximum possible substring with odd value
            for(int i=n-1; i >= 0; i--){
                // if the digit is odd, return the substring from start to index i + 1
                if(num.charAt(i) % 2 != 0){
                    return num.substring(0, i+1);
                }
            }
        
        return "";
    }
}