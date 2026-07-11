class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;

// BRUTE FORCE : For each fruit and each basket, check if the fruit can be stored in that basket, if YES, then mark the basket as '0', which means its unavailable for further use and cannot store fruits anymore.
        for(int fruit : fruits){
            int flag = 1;
            for(int i = 0; i < baskets.length; i++){
                if(fruit <= baskets[i]){
                    baskets[i] = 0;
                    flag = 0;
                    break;
                }
            }
            count += flag;
        }
        return count;
    }
}