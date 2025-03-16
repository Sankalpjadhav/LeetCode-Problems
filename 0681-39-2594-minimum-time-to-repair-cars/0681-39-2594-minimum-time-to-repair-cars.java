class Solution {

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        Arrays.sort(ranks);

        long low = 1; // Minimum possible time
        long high = ranks[0] * (long)cars * (long)cars; // Maximum possible time
        long result = high;

        while(low <= high){
            long mid = low + (high - low)/2;
            if(canPossibleToRepairAllCarsAtThisTime(mid, ranks, cars)){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canPossibleToRepairAllCarsAtThisTime(long time, int [] ranks, int cars){
        long totalCars = 0;

        for(int rank: ranks){
            totalCars += (long) Math.sqrt((time/rank));
            if(totalCars >= cars){
                return true;
            }
        }

        return false;
    }
}

/*
Brute force:

private long assignCars(int mechanicIndex, int carsLeft, int[] ranks, long maxTimeSoFar) {
        if (mechanicIndex == ranks.length) {
            // Base case: All mechanics are used; no cars should be left
            return carsLeft == 0 ? maxTimeSoFar : Long.MAX_VALUE;
        }

        long minTime = Long.MAX_VALUE;

        // Try assigning from 1 to carsLeft to the current mechanic
        for (int carsAssigned = 1; carsAssigned <= carsLeft; carsAssigned++) {
            long timeForCurrentMechanic = (long) ranks[mechanicIndex] * (long) carsAssigned * (long) carsAssigned;
            long newMaxTime = Math.max(maxTimeSoFar, timeForCurrentMechanic);

            // Recur to assign remaining cars to the next mechanic
            minTime = Math.min(minTime, assignCars(mechanicIndex + 1, carsLeft - carsAssigned, ranks, newMaxTime));
        }

        return minTime;
    }

    public long repairCars(int[] ranks, int cars) {
        return assignCars(0, cars, ranks, 0);
    }
*/