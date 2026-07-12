class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || k == 1) // edge case
        return nums;

        int[] ans = new int[n-k+1];

        // to store the indices
        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for(int i = 0; i<n; i++){

            // remove the indices that are outside the current window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            // remove all smaller elements from the back of deque
            // they can never be the maximum element
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }

            // add the current index at the back of the deque
            dq.offerLast(i);

            // window is complete and the index of the maximum element of the window is stored at the front of the deque
            if(i >= k-1){
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}