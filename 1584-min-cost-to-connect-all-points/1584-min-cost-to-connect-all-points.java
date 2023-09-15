class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pq.add(new int[]{findDistance(points, i, j),i, j});
            }
        }
        
        UnionFind uf = new UnionFind(n);
        int minCost = 0;
        while(!pq.isEmpty()){
            int [] path = pq.poll();
            int cost = path[0];
            int u = path[1];
            int v = path[2];
            if(uf.findParent(u)!=uf.findParent(v)){
                // Does not belong to same component
                minCost+=cost;
                uf.union(u,v);
            }
        }
        
        return minCost;
    }
    
    public int findDistance(int [][] points, int x, int y){
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
    
    class UnionFind{
        int [] parent;
        UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        
        int findParent(int u){
            if(u==parent[u]){
                return u;
            }
            
            return findParent(parent[u]);
        }
        
        void union(int u, int v){
            parent[findParent(u)] = parent[findParent(v)];
        }
    }
}