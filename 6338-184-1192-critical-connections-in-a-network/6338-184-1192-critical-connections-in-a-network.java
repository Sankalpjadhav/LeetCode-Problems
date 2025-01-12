class Solution {
    private int timer;

    private void dfs(int server, int parentServer, List<List<Integer>> adj, int [] timeOfConnection,
    int [] lowestTimeConnection, boolean [] visited, List<List<Integer>> result){
        visited[server] = true;
        timeOfConnection[server] = timer;
        lowestTimeConnection[server] = timer;
        timer++;

        for(int adjServer: adj.get(server)){
            if(!visited[adjServer]){
                dfs(adjServer, server, adj, timeOfConnection, lowestTimeConnection, visited, result);
                lowestTimeConnection[server] = Math.min(lowestTimeConnection[server], lowestTimeConnection[adjServer]);
                if(lowestTimeConnection[adjServer] > timeOfConnection[server]){
                    result.add(Arrays.asList(server, adjServer));
                }
            }
            else if(adjServer != parentServer){
                lowestTimeConnection[server] = Math.min(lowestTimeConnection[server], lowestTimeConnection[adjServer]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(i, new ArrayList<>());
        }

        for(List<Integer> connection: connections){
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        int [] timeOfConnection = new int[n];
        int [] lowestTimeConnection = new int[n];
        boolean [] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        timer = 1;
        dfs(0, -1, adj, timeOfConnection, lowestTimeConnection, visited, result);

        return result;
    }
}