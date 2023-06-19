class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = Integer.MIN_VALUE;
        int trip = 0;
        
        for(int i=0;i<gain.length;i++){
            trip += gain[i];
            highestAltitude = Math.max(highestAltitude, trip);
        }
        
        return highestAltitude < 0 ? 0 : highestAltitude;
    }
}