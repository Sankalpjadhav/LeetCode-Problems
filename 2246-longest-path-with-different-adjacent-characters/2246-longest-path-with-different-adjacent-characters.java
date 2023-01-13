class Solution {
    private int longPath = 1;
    
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> list = new ArrayList<>();
        int n = parent.length;
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=1;i<n;i++){
            list.get(i).add(parent[i]);
            list.get(parent[i]).add(i);
        }
        
        int [] dist = new int[n];

        dfs(0, -1, list, s, dist);
        
        return longPath;        
    }
    
    public void dfs(int node, int parent, List<List<Integer>> list, String s, int [] dist){
        
        dist[node] = 1;  
        
        for(int adjNode : list.get(node)){
            
            if(adjNode == parent){
                continue;
            }
            
            dfs(adjNode, node, list, s, dist);
            
            if(s.charAt(adjNode) != s.charAt(node)){
                
                longPath = Math.max(longPath, dist[node] + dist[adjNode]);
                
                dist[node] = Math.max(dist[node], dist[adjNode] +1);            
            }            
            
        }
        
    }
}

/*

Below approach: 14 / 141 test cases passed.
private int longPath = 0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> list = new ArrayList<>();
        int n = parent.length;
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=1;i<n;i++){
            list.get(i).add(parent[i]);
            list.get(parent[i]).add(i);
        }
        
        dfs(0, -1, list, s);
        
        return longPath;
    }
    
    private int dfs(int node, int parent, List<List<Integer>> list, String s){
        
        int path = 0;
        for(int adjNode: list.get(node)){
            if(adjNode == parent){
                continue;
            }        
            int childPath = dfs(adjNode, node, list, s);
            if(s.charAt(node) != s.charAt(adjNode)){
                path += childPath;
            }
        }
        
        longPath = Math.max(longPath, path+1);
        
        return path + 1;
    }

*/