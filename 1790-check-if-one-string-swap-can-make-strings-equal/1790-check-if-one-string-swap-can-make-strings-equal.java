/*
Approach : Brute force 
TC : O(N)
SC = O(1)
*/
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();

        // Base case : If both the strings are equal, return true
        if(s1.equals(s2)){
            return true;
        }

        List<Integer> indices = new ArrayList<>();

        // marking down the indices that mismatches and need to be swapped
        for(int i = 0; i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                indices.add(i);
            }
        }

        // max no of swap will be one only if two indexes are there to be swapped
        if(indices.size() == 2){
            char[] strArr = s2.toCharArray();
            char temp = strArr[indices.get(0)];
            strArr[indices.get(0)] = strArr[indices.get(1)];
            strArr[indices.get(1)] = temp;

            String newStr = new String(strArr);

            if(s1.equals(newStr)){
                return true;
            }
            
        }
       
        return false;

    }
}