class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        if(n==2){
            return nums;
        }

        ArrayList <Integer> l1 = new ArrayList<>();
        ArrayList <Integer> l2 = new ArrayList<>();

        l1.add(nums[0]);
        l2.add(nums[1]);

        for(int i = 2; i < n; i++){

            if(l1.getLast() > l2.getLast()){
                l1.add(nums[i]);
            }
            else{
                l2.add(nums[i]);
            }
        }

        l1.addAll(l2);
        return l1.stream().mapToInt(Integer::intValue).toArray();    
    }
}