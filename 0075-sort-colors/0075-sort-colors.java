class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
 // BRUTE FORCE : Count the no of elements and replace the existing array for the same time 
    //     int countZero = 0, countOne = 0, countTwo = 0;
    //     for(int i=0; i<n; i++){
    //         if(nums[i]==0) countZero++;
    //         if(nums[i]==1) countOne++;
    //         if(nums[i]==2) countTwo++;
    //     }

    //     for(int i=0;i<n;i++){
    //         while(countZero>0){
    //             nums[i]=0;
    //             i++;
    //             countZero--;
    //         }
    //         while(countOne>0){
    //             nums[i]=1;
    //             i++;
    //             countOne--;
    //         }
    //         while(countTwo>0){
    //             nums[i]=2;
    //             i++;
    //             countTwo--;
    //         }
    //     }
        
    // }

// OPTIMAL SOLN : DUTCH NATIONAL FLAG ALGORITHM
    int low = 0, mid = 0, high = n-1;

    while(mid <= high){
        if(nums[mid] == 0){
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;

            low++;
            mid++;
        }
        else if(nums[mid] == 1){
            mid++;
        }
        else{
            int temp = nums[high];
            nums[high] = nums[mid];
            nums[mid] = temp;

            high--;
        }
    }
}
}