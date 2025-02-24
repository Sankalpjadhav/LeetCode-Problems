class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int [] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        HashMap<Integer, Integer> timeTakenByBob = new HashMap<>();
        boolean [] visited = new boolean[n];
        calculateTimeTakenByBob(bob, 0, 0, adjList, timeTakenByBob, visited);

        visited = new boolean[n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // node, time, income
        int maxAmount = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int [] node = queue.poll();
            int currentNode = node[0];
            int currentTime = node[1];
            int currentIncome = node[2];

            visited[currentNode] = true;

            if(timeTakenByBob.get(currentNode) == null){
                // This means bob has not visited
                currentIncome += amount[currentNode];
            }
            else{
                // Bob has visited this node
                if(timeTakenByBob.get(currentNode) > currentTime){
                    // Alice is first to visit this node
                    currentIncome += amount[currentNode];
                }
                else if(timeTakenByBob.get(currentNode) == currentTime){
                    // Both visit this current node at the same time
                    currentIncome += amount[currentNode] / 2;
                }
                else{
                    // timeTakenByBob.get(currentNode) < currentTime
                    // Bob has already opened the gate so no income is required for Alice
                }
            }

            if(currentNode != 0 && adjList.get(currentNode).size() == 1){
                // This means currentNode is not 0 and it has only one parent which further means that it is leaf node
                maxAmount = Math.max(maxAmount, currentIncome);
            }

            for(int adjNode: adjList.get(currentNode)){
                if(!visited[adjNode]){
                    queue.add(new int[]{adjNode, currentTime+1, currentIncome});
                }
            }
        }

        return maxAmount;
    }

    private boolean calculateTimeTakenByBob(int src, int dest, int time, List<List<Integer>> adjList, HashMap<Integer, Integer> timeTakenByBob, boolean [] visited){
        visited[src] = true;
        timeTakenByBob.put(src, time);
        if(src == dest){
            return true;
        }

        for(int adjNode: adjList.get(src)){
            if(!visited[adjNode] && calculateTimeTakenByBob(adjNode, dest, time+1, adjList, timeTakenByBob, visited)){
                return true;
            }
        }

        timeTakenByBob.remove(src);
        return false;
    }
}