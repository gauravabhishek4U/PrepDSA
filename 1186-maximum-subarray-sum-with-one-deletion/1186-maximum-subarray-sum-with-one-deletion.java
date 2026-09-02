/*
Approach : Kadane's Algo
TC = O(N)
SC = O(1)
*/

class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;

        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;
        int result = arr[0];

        for(int i=1; i<n; i++){
            int prevNoDel = noDel;
            int prevOneDel = oneDel;

            /*
            if no deletion happens, there are two options:
            1. the new element can pair up with the best existing result so far
            2. the new element can form a new result alone
            so the new result will be the maximum of these two possibilites
            */
            noDel = Math.max(prevNoDel + arr[i], arr[i]);

            int var;

            /*
            if prevOneDel is MIN VALUE, then it means no deletion has been done so far
            in this case, var (new value of preOneDel) should be the element at that index
            */
            if(prevOneDel == Integer.MIN_VALUE){
                var = arr[i];
            }

            /*
            else if prevOneDel is NOT MIN VALUE, then it means ALREADY one deletion has been done so far, therefore no futher deletion is possible
            in this case, prevOneDel should be prevOneDel + the element at that index
            */
            else{
                var = prevOneDel + arr[i];  
            }

            // and final oneDel will be the maximum of var (new prevOneDel) and prevNoDel
            oneDel = Math.max(var, prevNoDel);

            // final result will be the maximum of previous result, oneDel, and noDel
            result = Math.max(result, Math.max(oneDel, noDel));

        }
        return result;
    }
}