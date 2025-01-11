class Solution {

    class UnionFind{
        // int [] rank; Here we won't be requiring rank array since it doesn't have restrictions to connect point A to point B instead we can connect vice versa.
        int [] parent;

        UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int findParent(int node){
            if(node == parent[node]) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void union(int pointA, int pointB){
            int parentA = findParent(pointA);
            int parentB = findParent(pointB);

            parent[parentA] = parentB;
        }
    }

    private int findDistance(int [] point1, int [] point2){
        return Math.abs(point1[0]-point2[0]) + Math.abs(point1[1]-point2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        // Here I will be using Kruskal's Algorithm which is used to find minimum cost to connect all the nodes.
        // Here instead of sorting the data structure with their min distance, we will use min Heap to do the same.
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->x[0]-y[0]);
        int n = points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                pq.add(new int[]{findDistance(points[i], points[j]), i, j});
            }
        }

        UnionFind uf = new UnionFind(n);
        int minCost = 0;
        while(!pq.isEmpty()){
            int [] point = pq.poll();
            int cost = point[0];
            int u = point[1];
            int v = point[2];
            if(uf.findParent(u)!=uf.findParent(v)){
                minCost+=cost;
                uf.union(u,v);
            }
        }

        return minCost;

    }
}