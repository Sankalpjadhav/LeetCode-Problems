class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lowestTime = 1;
        long highestTime = (long)1e14;
        
        while(lowestTime < highestTime){
            long possibleTime = lowestTime + (highestTime - lowestTime)/2;
            if(minimumTimeTaken(time, possibleTime) >= totalTrips){
                highestTime = possibleTime;
            }
            else{
                lowestTime = possibleTime+1;
            }
        }
        
        return lowestTime;
    }
    
    private long minimumTimeTaken(int [] times, long possibleTime){
        long totalTrips = 0;
        for(int time: times){
            long t = time;
            totalTrips += (possibleTime/t);
        }
        return totalTrips;
    }
}

/*
Also If you want to practice more such "Answer on Binary Search" then you can check below questions , also if you find such more add it to comments will update.

Easy
https://leetcode.com/problems/arranging-coins/

Medium
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
https://leetcode.com/problems/find-the-duplicate-number/
https://leetcode.com/problems/minimum-size-subarray-sum/
https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
https://leetcode.com/problems/koko-eating-bananas/ [google]
https://leetcode.com/problems/path-with-minimum-effort/
https://leetcode.com/problems/most-beautiful-item-for-each-query/
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
https://leetcode.com/problems/heaters/
https://leetcode.com/problems/minimum-absolute-sum-difference/
https://leetcode.com/problems/frequency-of-the-most-frequent-element/

Hard
https://leetcode.com/problems/swim-in-rising-water/
https://leetcode.com/problems/split-array-largest-sum/ [ good question can be done using DP but BS is amazing][Google]
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
https://leetcode.com/problems/nth-magical-number/
https://leetcode.com/problems/find-k-th-smallest-pair-distance/
https://leetcode.com/problems/maximum-running-time-of-n-computers/
*/