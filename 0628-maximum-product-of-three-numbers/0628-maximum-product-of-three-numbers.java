
/*
// Optimal Approach : One Pass - Track 3 maximum and 2 minimum number
// TC : O(N), SC : O(1)

class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = -1000, max2 = -1000, max3 = -1000;
        int min1 = 0, min2 = 0;

        for(int ele : nums){

            if(max1 <= ele){
                max3 = max2;
                max2 = max1;
                max1 = ele;
            }
            else if(max2 <= ele){
                max3 = max2;
                max2 = ele;
            }
            else if(max3 <= ele){
                max3 = ele;
            }

            if(min1 >= ele){
                min2 = min1;
                min1 = ele;
            }
            else if(min2 >= ele){
                min2 = ele;
            }
        }

        return Math.max(
            max1 * max2 * max3,
            min1 * min2 * max1
        );
    }
}

*/

// Approach : Sorting
// Sorting the array in ascending order will give us 2 minimum elements at first two index
// and 3 maximum element at the last three index of the array
// Maximum product could only be either min1 * min2 * max1 or max1 * max2 * max3
// TC = O(n log n), SC = O(log n)

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        // product of two minimums and one greatest maximum
        int product1 = nums[0] * nums[1] * nums[n-1];

        // product of three maximums 
        int product2 = nums[n-1] * nums[n-2] * nums[n-3];

        return Math.max(product1 , product2);

    }
}