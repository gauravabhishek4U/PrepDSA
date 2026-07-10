class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int i= 0, j=0, res=0;

        Map<Integer, Integer> mpp = new HashMap<>();

        for(j=0;j<n;j++){
            mpp.put(fruits[j], mpp.getOrDefault(fruits[j], 0) +1);

            while(mpp.size() > 2){
                mpp.put(fruits[i], mpp.get(fruits[i]) -1);
                if(mpp.get(fruits[i]) == 0 ){
                    mpp.remove(fruits[i]);
    
                }
                i++;
            }
            res = Math.max(res, j-i+1);

        }

        return res;
    }
}