class Solution {
    class Pair{
        int node;
        double probability;
        Pair(int _node, double _probability){
            node = _node;
            probability = _probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int [] edge = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        }

        double [] probabilities = new double[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> b.probability > a.probability ? 1 : b.probability < a.probability ? -1 : 0); // Process the node/path which has higher probability to get max probability
        pq.add(new Pair(start_node, 1));
        probabilities[start_node] = 1;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node;
            double currentNodeProb = pair.probability;

            for(Pair adjPair: adj.get(node)){
                if(currentNodeProb * adjPair.probability > probabilities[adjPair.node]){
                    probabilities[adjPair.node] = currentNodeProb * adjPair.probability;
                    pq.add(new Pair(adjPair.node, currentNodeProb * adjPair.probability));
                }
            }
        }

        return probabilities[end_node] <= 0 ? 0 : probabilities[end_node];

    }
}

/*
Even for below solution got TLE:

public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int [] edge = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        }

        double [] probabilities = new double[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> b.probability > a.probability ? 1 : b.probability < a.probability ? -1 : 0); // Process the node/path which has higher probability to get max probability
        pq.add(new Pair(start_node, 1));
        probabilities[start_node] = 1;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node;
            double currentNodeProb = pair.probability;

            if(probabilities[node] > currentNodeProb){
                continue;
            }

            probabilities[node] = currentNodeProb;

            if(node == end_node){
                return currentNodeProb;
            }

            for(Pair adjPair: adj.get(node)){
                pq.add(new Pair(adjPair.node, currentNodeProb * adjPair.probability));
            }
        }

        return 0;

    }


/*
Got TLE: Not using probability array

public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int [] edge = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> b.probability > a.probability ? 1 : b.probability < a.probability ? -1 : 0); // Process the node/path which has higher probability to get max probability
        pq.add(new Pair(start_node, 1));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node;
            double currentNodeProb = pair.probability;

            if(node == end_node){
                return currentNodeProb;
            }

            for(Pair adjPair: adj.get(node)){
                pq.add(new Pair(adjPair.node, currentNodeProb * adjPair.probability));
            }
        }

        return 0;

    }
*/