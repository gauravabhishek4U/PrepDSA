/*

// BRUTE FORCE : Using nested for loops
// TC : O(N^2), SC = O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i = 0; i< n; i++){
            for(int j = i+1; j<n; j++){
                int prod = (nums[i]-1) * (nums[j]-1);
                ans = Math.max(ans, prod);
            }
        }
        return ans;
    }
}
*/


/*
// Approach : Using Sorting
// Sort the array in ascending order and calculate the product of last two elements 
// TC = O(log n), SC = O(1)

class Solution{
    public int maxProduct(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n-1]-1)*(nums[n-2]-1);
    }
}

*/

// Using Priority Queue. TC = O(n log 2) = O(n), SC = O(1)
// Create a min-heap
// Insert each element into the heap.
// If the heap size becomes greater than 2, remove the smallest element.
// Multiply the remaining two digits by subtracting 1 from them.
class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            if(pq.size()>2){
                pq.poll();
            }
        }
        return (pq.poll()-1) * (pq.poll()-1);
    }
}