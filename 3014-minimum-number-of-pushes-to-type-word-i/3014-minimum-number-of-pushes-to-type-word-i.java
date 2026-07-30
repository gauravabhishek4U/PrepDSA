// Optimal Approach : Using hashmap
// TC = O(n), SC = O(1)
class Solution {
    public int minimumPushes(String word) {
        
        if (word.length() <= 8) {
            return word.length();
        }

        int result = 0;
        int assignKey = 2;
        
        Map <Integer, Integer> mpp = new HashMap<>();

        for(char ch : word.toCharArray()){
            if(assignKey > 9){
                assignKey = 2;
            }

            mpp.put(assignKey, mpp.getOrDefault(assignKey,0)+1);
            result += mpp.get(assignKey);
            assignKey++;
        }
        return result;
        
    }
}