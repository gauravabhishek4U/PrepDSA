/*
Approach : Sliding Window
TC = O(N)
SC = O(N)
Solved : 3
*/

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = fruits.length;
        int low=0, high =0;

        for(high = 0; high<n; high++){
            map.put(fruits[high], map.getOrDefault(fruits[high], 0)+1);

            // if basket size is greater than 2, remove the fruit from left end
            while(map.size() > 2){

                map.put(fruits[low], map.get(fruits[low]) -1);

                // if freq of that fruit is 0, then remove it from the map (basket)
                if(map.get(fruits[low]) == 0){
                    map.remove(fruits[low]);
                }
                
                low++;
            }
            ans = Math.max(ans, high-low+1);
        }
        return ans;
    }
}