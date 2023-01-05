class Solution {
    public int findMinArrowShots(int[][] points) {
        // Constraint given -2^31 <= xstart < xend <= 2^31 - 1
        
        int balloons = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        
        int numberOfArrows = 1;
        int arrowPosition = points[0][1];       
        
        for(int i=0;i<balloons;i++){
            if(arrowPosition >= points[i][0]){
                // this arrow position will burst the balloon
                continue;
            }
            // current arrow position will not burst the balloon
            numberOfArrows++; // So we increment number of arrows required
            arrowPosition = points[i][1];
        }
        
        return numberOfArrows;
    }
}

/*
This below code will not work for [[-2147483646,-2147483645],[2147483646,2147483647]] because of comparator we have used a[1]-b[1]
    public int findMinArrowShots(int[][] points) {
        // Constraint given -2^31 <= xstart < xend <= 2^31 - 1
        
        int balloons = points.length;
        Arrays.sort(points, (a, b) -> a[1]-b[1]);
        
        int numberOfArrows = 1;
        int arrowPosition = points[0][1];       
        
        for(int i=0;i<balloons;i++){
            if(arrowPosition >= points[i][0]){
                // this arrow position will burst the balloon
                continue;
            }
            // current arrow position will not burst the balloon
            numberOfArrows++; // So we increment number of arrows required
            arrowPosition = points[i][1];
        }
        
        return numberOfArrows;
    }


*/