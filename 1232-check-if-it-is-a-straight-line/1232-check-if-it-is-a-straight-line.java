class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 2){
            return true;
        }
        
        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];

        for(int i=2;i<n;i++){
            if (deltaY * (coordinates[i][0] - coordinates[0][0]) != deltaX * (coordinates[i][1] - coordinates[0][1])) {
                return false;
            }
        }
        
        return true;
    }
}