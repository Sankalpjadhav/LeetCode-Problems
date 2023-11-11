class pair{
    int node;
    int dist;
    pair(int node1,int dist1){
        node=node1;
        dist=dist1;
    }
}
class Graph {
    List<List<pair>> adj;
    int n1;
    public Graph(int n, int[][] edges) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int p[]:edges){
            adj.get(p[0]).add(new pair(p[1],p[2]));
        }
        n1=n;
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new pair(edge[1],edge[2]));
    }
    
    public int shortestPath(int src, int dest) {
        int distn[]=new int[n1];
        Arrays.fill(distn,(int)1e9);
        distn[src]=0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,0));
        while(!q.isEmpty()){
            pair it=q.poll();
            int node=it.node;
            int dis=it.dist;
            for(pair x:adj.get(node)){
                if(x.dist+dis<distn[x.node]){
                    distn[x.node]=x.dist+dis;
                    q.add(new pair(x.node,distn[x.node]));
                }
            }
        }
        return distn[dest]==(int)1e9?-1:distn[dest];
    }
    
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */