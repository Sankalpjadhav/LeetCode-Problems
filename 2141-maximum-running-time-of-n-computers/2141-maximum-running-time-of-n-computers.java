class Solution {
    public long maxRunTime(int n, int[] bat) {
        long totalTime = 0L;
        for(int min : bat){
            totalTime += min;
        }
        
        long lower = 0L, upper = totalTime/n;
        long res = 0;
        while(lower<=upper){
            long mid = lower + (upper-lower)/2;
            
            if(check(n, mid, bat)){
                res = mid;
                lower = mid+1;
            }else{
                upper = mid-1;
            }
        }
        return res;
    }
    public boolean check(int n, long time, int[] bat){
        long target = n*time; // total mintues to run 'n' computers, each for 'time' minutes.
        long runTime = 0;
        for(int min : bat){
            runTime += Math.min(min, time); // each battry cannot contrinute to more than 1 computer.
            if(runTime>=target) return true;
        }
        return runTime>=target;
    }
}

/*
Observations
If the computers cannot run simultaneously for a minutes, then definitely they cannot run simultaneously for b > a minutes.
During a simultaneous run of a minutes, each battery, no matter how long it can run, can "contribute" a maximum of a minutes to the total running time.

Solution
Based on Observation #1, perform a Binary Search on the maximum number of minutes for the simultaneous run attainable.
The lower and upper bound for the Binary Search are 0 (cannot run at all) and sum(batteries[i]) / n (the computers' total running time cannot exceed total battery amounts)
During each search, check whether all batteries "contribute" enough for the total running time required for this simultaneous run, based on Observation #2.
The running time would be O(n lg m) where m = sum(batteries[i]) and n = batteries.length are the total sum of all batteries, and number of batteries.
*/