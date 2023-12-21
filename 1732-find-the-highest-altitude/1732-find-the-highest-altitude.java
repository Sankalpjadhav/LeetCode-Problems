class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int n = gain.length;
        int netGain = 0;
        for(int i=0;i<n;i++){
            netGain += gain[i];
            highestAltitude = Math.max(highestAltitude, netGain);
        }
        
        return highestAltitude;
    }
}