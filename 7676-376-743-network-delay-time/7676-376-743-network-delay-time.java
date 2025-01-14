class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int [] time: times){
            int u = time[0];
            int v = time[1];
            int signalTime = time[2];
            adjList.get(u).add(new int[]{v, signalTime});
        }

        int [] timeTaken = new int[n+1];
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b)->a[1]-b[1]);
        queue.add(new int[]{k, 0});
        timeTaken[k] = 0;

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int currentNode = current[0];
            int currentTime = current[1];

            if(timeTaken[currentNode] > currentTime){
                timeTaken[currentNode] = currentTime;
            }

            for(int [] adj: adjList.get(currentNode)){
                if(currentTime + adj[1] < timeTaken[adj[0]]){
                    timeTaken[adj[0]] = currentTime + adj[1];
                    queue.add(new int[]{adj[0], currentTime+adj[1]});
                }
            }
        }

        int maxTime = 0;
        for(int i=1;i<=n;i++){
            if(timeTaken[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, timeTaken[i]);
        }

        return maxTime;
    }
}
