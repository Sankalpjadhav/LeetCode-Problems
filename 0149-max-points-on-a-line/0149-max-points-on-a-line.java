class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        
        HashMap<Double, HashSet<Integer>> map = new HashMap<>();
        
        int maxNumOfPoints = 0;
        int n = points.length;
        for(int i=0;i<n;i++){
            map.clear();
            for(int j=i+1;j<n;j++){
                int [] point1 = points[i];
                int [] point2 = points[j];
                
                Double slope = getSlope(point1, point2);
                
                if(map.containsKey(slope)){
                    HashSet<Integer> set = map.get(slope);
                    set.add(i);
                    set.add(j);
                    map.put(slope, set);
                }
                else{
                    HashSet<Integer> newSet = new HashSet<>();
                    newSet.add(i);
                    newSet.add(j);
                    map.put(slope, newSet);
                }
                
                maxNumOfPoints = Math.max(maxNumOfPoints, map.get(slope).size());
            }
        }
        
        return maxNumOfPoints;
    }
    
    private Double getSlope(int [] point1, int [] point2){
        int X = point1[0] - point2[0];
        int Y = point1[1] - point2[1];
        
        return X == 0 ? Double.MIN_VALUE : (double)Y/(double)X + 0.0;
    }
    
}



/*

public int maxPoints(int[][] points) {
        if(points.length == 1)
            return 1;
        
        HashMap<Double, HashSet<Integer>> countSlopes = new HashMap<Double, HashSet<Integer>>();
        int maxpoints = 0;
        for(int i = 0; i < points.length;i++)
        {
            countSlopes.clear();
            
            for(int j =  i+1; j < points.length; j++)
            {
                double slope = getSlope(points[i],points[j]);
                HashSet<Integer> pointSet = countSlopes.getOrDefault(slope, new HashSet<Integer>());
                pointSet.add(i);
                pointSet.add(j);
                countSlopes.put(slope,pointSet);
                maxpoints = Math.max(maxpoints, pointSet.size());
            }
        }
        
        return maxpoints;
    }
    
	// Y= m*X + C. return m.
    public double getSlope(int[] pointA, int[] pointB)
    {
        int Y = pointA[1]-pointB[1];
        int X = pointA[0]- pointB[0];
        
        return X == 0 ? Double.MIN_VALUE : (double)(Y)/(double)X + 0.0; // +0.0 to get rid of -0.0
    }

*/