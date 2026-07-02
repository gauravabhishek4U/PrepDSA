class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int countZero = 0, countOne = 0, countTwo = 0;
 // BRUTE FORCE : Count the no of elements and replace the existing array for the same time 
        for(int i=0; i<n; i++){
            if(nums[i]==0) countZero++;
            if(nums[i]==1) countOne++;
            if(nums[i]==2) countTwo++;
        }

        for(int i=0;i<n;i++){
            while(countZero>0){
                nums[i]=0;
                i++;
                countZero--;
            }
            while(countOne>0){
                nums[i]=1;
                i++;
                countOne--;
            }
            while(countTwo>0){
                nums[i]=2;
                i++;
                countTwo--;
            }
        }
        
    }
}