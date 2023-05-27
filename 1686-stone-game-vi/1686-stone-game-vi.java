class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        
        int[][] triplets = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            triplets[i] = new int[] {aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        
        Arrays.sort(triplets, (a, b) -> Integer.compare(b[0], a[0]));
        
        int aliceScore = 0;
        int bobScore = 0;
        boolean flag = true;
        
        for (int i = 0; i < n; i++) {
            if (flag == true) {
                aliceScore += triplets[i][1];
                flag = false;
            } else {
                bobScore += triplets[i][2];
                flag = true;
            }
        }
        
        if(aliceScore > bobScore){
            return 1;
        }
        else if(aliceScore < bobScore){
            return -1;
        }
        
        return 0;
    }
}