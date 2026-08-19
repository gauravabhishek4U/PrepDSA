// Approach : Greedy pick using Map
// TC = O(N), N = reservedSeats.length
// SC = O(N), for storing reservedSeats in HashMap

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] reservedSeat : reservedSeats){
            int row = reservedSeat[0];
            int seat = reservedSeat[1];

            map.computeIfAbsent(row, value -> new HashSet<>()).add(seat);
        }

        int result = (n - map.size()) * 2;

        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            Set<Integer> bookedSeats = entry.getValue();

            boolean grpA = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4) && !bookedSeats.contains(5);

            boolean grpB = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6) && !bookedSeats.contains(7);

            boolean grpC = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8) && !bookedSeats.contains(9);

            if(grpA && grpC)
                result += 2;
            else if(grpA || grpB || grpC)
                result += 1;
        }
        return result;
    }
}