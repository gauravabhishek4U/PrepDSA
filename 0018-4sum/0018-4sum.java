class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // edge case
        if(n<4 || nums == null){
            return ans;
        }

        Arrays.sort(nums);
        
        for(int a = 0; a < n-3; a++){
            // handling duplicate value for a
            if(a > 0 && nums[a] == nums[a-1]) continue;

            for(int b = a+1; b< n-2; b++){
                //handling duplicate value for b
                if(b > a+1 && nums[b] == nums[b-1]) continue;

                int c = b+1, d = n-1;
                while(c < d){
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[a], nums[b],nums[c],nums[d]));

                        // handling duplicate values for c
                        while(c < d && nums[c] == nums[c+1]){
                            c++;
                        }

                        // handling duplicate value for d
                        while(c < d && nums[d] == nums[d-1]){
                            d--;
                        }

                        c++;
                        d--;
                    }

                    else if(sum < target ){
                        c++;
                    }
                    else{
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}