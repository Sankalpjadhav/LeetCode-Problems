class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        if(edges == null || n == 0) return -1;
        if(node1 == node2) return node1;
        
        boolean [] visitedBy1 = new boolean[n];
        boolean [] visitedBy2 = new boolean[n];
       
        int [] dist1 = new int[n];
        Arrays.fill(dist1, -1); // Initially marking dist of other nodes from node1 as -1 which means they are not visited by any distance
        
        dfs(edges, node1, dist1, visitedBy1, 0);
        
        int [] dist2 = new int[n];
        Arrays.fill(dist2, -1); // Initially marking dist of other nodes from node2 as -1 which means they are not visited by any distance
        
        dfs(edges, node2, dist2, visitedBy2, 0);
        
        int result = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(dist1[i]!=-1 && dist2[i]!=-1){
                if(minDist > Math.max(dist1[i], dist2[i])){
                    result = i;
                    minDist = Math.max(dist1[i], dist2[i]);
                }
            }
        }
        
        return result;
    }
    
    
    private void dfs(int nums[], int node, int dist[], boolean visited[], int currDist){
        if(node!=-1 && !visited[node]){
            visited[node]=true;
            dist[node]=currDist;
            dfs(nums,nums[node],dist,visited,currDist+1);
        }
    }
}