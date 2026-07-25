/*
class Solution {
    public int maxProduct(int n) {

// Optimal Approach : TC = O(N) SC = O(1)
    // maintain max and second max digit in the given n
    // calculate their product as it will be the max product       
        int max1 = -1 , max2 = -1;
        while(n != 0){
            int rem = n % 10;
            if(max1 <= rem){
                max2 = max1;
                max1 = rem;
            }
            else if(max2 < rem){
                max2 = rem;
            }
            n /= 10;
        }
        return max1 * max2;        
    }
}
*/

/*
// Brute Force Approach :: TC = O(n^2), SC = O(n)
// Convert the integer into a string. Traverse every pair of digits using two nested loops.
// Convert the characters into integers. Compute their product.
// Store the maximum product.
class Solution {
    public int maxProduct(int n) {
        int max = -1;
        String str = n + "";
        for(int i = 0 ; i < str.length() ; i++){
            for(int j = i + 1 ; j < str.length() ; j++){
                int d1 = str.charAt(i) - '0';
                int d2 = str.charAt(j) - '0';
                max = Math.max(max , d1 * d2);
            }
        }
        return max;
    }
}
*/

// Using Priority Queue. TC = O(n log 2) = O(n), SC = O(1)
// Create a min-heap
// Extract every digit from the number
// Insert each digit into the heap.
// If the heap size becomes greater than 2, remove the smallest element.
// Multiply the remaining two digits.

class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(n != 0){
            int digit = n % 10;
            pq.offer(digit);
            if(pq.size() > 2) pq.poll();
            n /= 10;
        }
        return pq.poll() * pq.poll();
    }
}