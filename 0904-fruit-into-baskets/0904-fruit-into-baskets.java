class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = fruits.length;
        int low=0, high =0;

        // SLIDING WINDOW CREATION AND EXPANSION STEP
        // store each element from high end in the map
        // if already exist, get the frequency and increment by 1
        // else initialise it with 0 and then increase the counter
        
        for(high = 0; high<n; high++){
            map.put(fruits[high], map.getOrDefault(fruits[high], 0)+1);

            
            // SLIDING WINDOW SHRINKING PHASE
            //if map size exceeds 2, then remove the element from the left end
            // by getting the counter and decrementing it by 1
            // finally move the left counter to next element
            while(map.size() > 2){
                map.put(fruits[low], map.get(fruits[low]) -1);
                if(map.get(fruits[low]) == 0){
                    map.remove(fruits[low]);
                }
                low++;
            }
            // calculating answer by maximising the length between two ends
            ans = Math.max(ans, high-low+1);
        }
        return ans;
    }
}
