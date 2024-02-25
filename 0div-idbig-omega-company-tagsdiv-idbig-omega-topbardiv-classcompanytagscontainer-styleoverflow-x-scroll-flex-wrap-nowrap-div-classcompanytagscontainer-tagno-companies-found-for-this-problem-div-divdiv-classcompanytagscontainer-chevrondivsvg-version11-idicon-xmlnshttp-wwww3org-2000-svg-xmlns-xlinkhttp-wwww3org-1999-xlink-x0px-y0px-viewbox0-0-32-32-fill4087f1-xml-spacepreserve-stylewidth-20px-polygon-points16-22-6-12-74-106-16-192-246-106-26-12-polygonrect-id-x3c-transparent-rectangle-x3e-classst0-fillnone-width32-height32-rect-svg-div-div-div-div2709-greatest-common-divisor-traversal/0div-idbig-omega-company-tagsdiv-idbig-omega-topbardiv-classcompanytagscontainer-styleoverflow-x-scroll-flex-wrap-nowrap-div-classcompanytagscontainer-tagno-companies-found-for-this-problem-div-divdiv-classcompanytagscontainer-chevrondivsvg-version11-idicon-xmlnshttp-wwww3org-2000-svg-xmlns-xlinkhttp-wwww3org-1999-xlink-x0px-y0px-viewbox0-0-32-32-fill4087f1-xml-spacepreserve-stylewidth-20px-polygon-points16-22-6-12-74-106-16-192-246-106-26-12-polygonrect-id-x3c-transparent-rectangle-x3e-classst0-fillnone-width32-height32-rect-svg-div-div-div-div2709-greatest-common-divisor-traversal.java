class Solution {
    
    int[] parent = null;
    int[] rank = null;
    
    public boolean canTraverseAllPairs(int[] nums) {
        
        if( nums.length == 1)  return true;
        
        int max = 0, min = 4;
        
        for( int n : nums ) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        if( min == 1 ) return false;
        
        parent = new int[max+1];
        rank = new int[max+1];
        Arrays.fill(rank, -1);
        
        for( int i = 0; i < parent.length; i++ ) parent[i] = i;
        
        boolean[] usedFactors = new boolean[max+1];
        
        
        for( int n : nums ) factors(n, usedFactors);
        
        int group = -1;
        
        for( int i = 0; i < usedFactors.length; i++ ){
            if( usedFactors[i]  ){
                if( group == -1 ){
                    group = find(i);                    
                }else{
                    if( find(i) != group ) return false;
                }
            }
        }
        
        return true;
    }
    
    private void factors( int num, boolean[] usedFactors ){
        
        int sqrt = (int)Math.sqrt(num)+1;
        
        int first = num;
        usedFactors[first] = true;
        
        for( int i = 2; i < sqrt; i++ ){
            
            if( num%i == 0 ){
                union(first, i);
                union(first, num/i);
                usedFactors[i] = true;
                usedFactors[num/i] = true;
            }
        }
        
    }
    
    private void union( int  x, int y ){
        int parentX = find(x);
        int parentY = find(y);
        
        if( parentX == parentY ) return;
        
        parent[parentY] = parentX;
        
    }
    
    private int find( int x ){
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
}