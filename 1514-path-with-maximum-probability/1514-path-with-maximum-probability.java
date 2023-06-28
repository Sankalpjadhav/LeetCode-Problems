class Solution {

    boolean reachedEndAtleastOnce = false;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            list.get(u).add(new Pair(v, prob));
            list.get(v).add(new Pair(u, prob));  
        }
        //System.out.println(list);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> b.prob > a.prob ? 1 : b.prob < a.prob ? -1 : 0);
        double [] probs = new double[n];
        probs[start] = 1;
        pq.add(new Pair(start,1));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node;
            double probability = pair.prob;

            for(Pair p : list.get(node)){
                if(probability * p.prob > probs[p.node]){
                    probs[p.node] = probability * p.prob;
                    pq.add(new Pair(p.node, probs[p.node]));
                }
            }
        }

        return probs[end] == Integer.MIN_VALUE ? 0 : probs[end];
    }

    
}


class Pair{
    int node;
    double prob;

    Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }

    public String toString(){
        return node+"-"+prob;
    }
}