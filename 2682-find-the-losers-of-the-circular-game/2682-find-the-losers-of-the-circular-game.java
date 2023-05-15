class Solution {
    public int[] circularGameLosers(int n, int k) {
        if(n == 1 && k == 1){
            return new int[]{};
        }
        boolean [] received = new boolean[n];
        
        int i = 0;
        int num = 0;
        while(!received[i]){
            num++;
            received[i] = true;
            int next = (num*k) % (n);
            i = (i + next) % n;
        }
        
        int [] losers = new int[n - num];
        int j = 0;
        for(int l=0;l<n;l++){
            if(!received[l]){
                losers[j++] = l+1;
            }
        }
        
        return losers;
        
    }
}