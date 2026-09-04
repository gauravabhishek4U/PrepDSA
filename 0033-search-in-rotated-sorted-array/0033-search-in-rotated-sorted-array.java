/*
Approach : Binary Search
TC = O(N log N)
SC = O(1)
Solved : 1
*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(nums[mid]==target)
                return mid;
            
            //if left part is sorted
            if(nums[low]<=nums[mid])
            {
                
             // it lies on the left part  
                if(nums[low]<=target && target<=nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            
            //if right part is sorted
            if(nums[mid]<=nums[high])
            {
                
                //it lies in the right part
                if(nums[mid]<=target && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        
        
        
        return -1;
    }
}