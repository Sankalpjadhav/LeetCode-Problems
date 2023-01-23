class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] trusted = new int[n+1];
        
        for(int [] trustee: trust){
            trusted[trustee[0]]--;
            trusted[trustee[1]]++;
        }
        
        int townJudge = -1;
        // Everybody (except for the town judge) trusts the town judge.
        for(int i=1;i<=n;i++){
            if(trusted[i] == n-1){
                townJudge = i;
            }
        }
        return townJudge;
    }
}