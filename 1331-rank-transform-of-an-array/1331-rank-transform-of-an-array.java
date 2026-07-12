class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> rank = new HashMap<>();

        int initialRank = 1;

        for(int element : sortedArr){
            if(!rank.containsKey(element)){
                rank.put(element, initialRank);
                initialRank++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = rank.get(arr[i]);
        }
        return arr;
        
    }
}