//Approach-3 (Greedy Pick using map and arraylist)
//T.C : O(N), N = reservedSeats.length
//S.C : O(N), for storing reserved seats
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>(); //row -> bitmask of booked seats

        // store row wise reservedSeats
        for(int[] seat : reservedSeats) { //O(10^4)
            mp.putIfAbsent(seat[0], new ArrayList<>());
            mp.get(seat[0]).add(seat[1]);
        }

        // Row without any reservation can have 2 families i.e., group A and group C
        int result = (n - mp.size()) * 2;

        // check only rows having reservations
        for(int row : mp.keySet()){
            boolean A = true;
            boolean B = true;
            boolean C = true;
            
            for(int seat : mp.get(row)){

                if(seat >= 2 && seat <= 5)
                    A = false;
                if(seat >= 4 && seat <= 7)
                    B = false;
                if(seat >= 6 && seat <= 9)
                    C = false;
            }

            if(A && C) result += 2;

            else if( A || B || C) result += 1; 
        }

        return result;
    }
}