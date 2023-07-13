class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int [] prerequisite: prerequisites){
            int nodeX = prerequisite[0];
            int nodeY = prerequisite[1];
            adjList.get(nodeX).add(nodeY);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        boolean [] visited = new boolean[numCourses];
        boolean [] dfsVisited = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(!dfs(i, adjList, stack, visited, dfsVisited)){
                    return false;
                }
            }
        }
        
        if(stack.size() == numCourses){
            return true;
        }
        
        return false;
    }
    
    private boolean dfs(int node, List<List<Integer>> adjList, Stack<Integer> stack, boolean [] visited, boolean [] dfsVisited){
        visited[node] = true;
        dfsVisited[node] = true;
        for(int adjNode: adjList.get(node)){
            if(!visited[adjNode]){
                if(!dfs(adjNode, adjList, stack, visited, dfsVisited)){
                    return false;
                }
            }
            else if(dfsVisited[adjNode]){
                return false;
            }
        }
        dfsVisited[node] = false;
        stack.push(node);
        return true;
    }
}