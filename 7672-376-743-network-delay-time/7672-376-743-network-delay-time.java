class Solution {
    class Pair{
        int node, time;

        Pair(int _node, int _time){
            node = _node;
            time = _time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(i, new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int [] signalTime = new int[n+1];
        Arrays.fill(signalTime, Integer.MAX_VALUE);
        signalTime[k] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        while(!queue.isEmpty()){
            int node = queue.poll();

            System.out.println("node: "+node);

            for(Pair pair: adj.get(node)){
                int nextNode = pair.node;
                int timeRequired = pair.time;
                if(signalTime[nextNode] > signalTime[node] + timeRequired){
                    signalTime[nextNode] = signalTime[node] + timeRequired;
                    queue.add(nextNode);
                }
            }
        }

        int minimumTime = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            minimumTime = Math.max(minimumTime, signalTime[i]);
        }

        return minimumTime == Integer.MAX_VALUE ? -1 : minimumTime;
    }


}