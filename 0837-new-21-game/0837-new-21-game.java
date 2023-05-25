class Solution {
    public double new21Game(int N, int k, int maxPts) {
        if(k == 0)
            return 1.0;
        double[] preSum = new double[k+1];
        double currProb = 0.0;
        for(int i = k-1; i >= 0; --i) {
            int tmp = maxPts - k +1 +i;
            double subtractVal = 0.0;
            if(tmp < 0){
                subtractVal = preSum[k+tmp];
                tmp = 0;
            }
            currProb = preSum[i+1]/maxPts + ((double)Math.min(N-k+1, tmp))/maxPts - subtractVal/maxPts;
            preSum[i] = currProb + preSum[i+1];
        }
        return currProb;
    }
}