class Solution {
    public int bulbSwitch(int n) {
        double sq = Math.sqrt(n); // Lets assume n = 10, then sqrt(10) = 3.16
        return (int) Math.floor(sq); // This will tell you there are 3 number of perfect square present from 1 to 10 
    }
}
// https://www.youtube.com/watch?v=9XQxIvdqIt0