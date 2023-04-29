class Solution {
    private int[] parents;
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        
        int m = queries.length;
        
        // storing {u, v, weight, original idx} by increasing weight
        int[][] sortedQueries = new int[m][4];
        for (int i = 0; i < m; i++) {
            sortedQueries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(sortedQueries, (a,b) -> a[2] - b[2]);
        
        
        // sort edgeList by increasing weight 
        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);
        int idx = 0;
        
        boolean[] res = new boolean[m];
        
        for (int i = 0; i < m; i++) {
            int[] q = sortedQueries[i];
            int w = q[2];
            
            // union all edges with weight less than current query
            while (idx < edgeList.length && edgeList[idx][2] < w) {
                int[] e = edgeList[idx++];
                int u = e[0], v = e[1];
                union(u, v);
            }
            
            int uQuery = q[0], vQuery = q[1], id = q[3];
            res[id] = (find(uQuery) == find(vQuery));
        }
        
        return res;
    }
    
    private void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);
        parents[uParent] = vParent;
    }
    
    private int find(int u) {
        while (u != parents[u]) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }
}


/*
Own code gave TLE : 18 / 23

public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int N = queries.length;
        boolean [] result = new boolean[N];
        List<List<int []>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<edgeList.length;i++){
            int u = edgeList[i][0];
            int v = edgeList[i][1];
            int dist = edgeList[i][2];
            
            list.get(u).add(new int[]{v, dist});
            list.get(v).add(new int[]{u, dist});
        }
        
        for(int j=0;j<queries.length;j++){
            int [] query = queries[j];
            result[j] = dfs(query[0], query[1], query[2], new boolean[n], list);
        }
        
        return result;
    }
    
    private boolean dfs(int src, int dst, int limit, boolean [] visited, List<List<int[]>> list){
        visited[src] = true;
        if(src == dst){
            return true;
        }
        
        for(int [] nhbr: list.get(src)){
            int adj = nhbr[0];
            int dist = nhbr[1];
            if(!visited[adj] && dist < limit){
                if(dfs(adj, dst, limit, visited, list)){
                    return true;
                }
            }
        }
        
        return false;
    }

*/
    