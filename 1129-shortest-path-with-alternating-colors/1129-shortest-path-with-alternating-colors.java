class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        HashMap<Integer, List<Integer>> redList = new HashMap<>();
        HashMap<Integer, List<Integer>> blueList = new HashMap<>();
        
        for(int i=0;i<n;i++){
            redList.put(i, new ArrayList<>());
            blueList.put(i, new ArrayList<>());
        }
        
        for(int [] edge : redEdges){
            redList.get(edge[0]).add(edge[1]);
        }
        
        for(int [] edge : blueEdges){
            blueList.get(edge[0]).add(edge[1]);
        }
        
        int [] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        // We will be applying BFS Algorithm
        
        int distance = 0;
        HashSet<Pair> seen = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0)); // Here 1 represents blue color
        queue.add(new Pair(0, 1)); // Here 1 represents red color
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                Pair pair = queue.poll();
                seen.add(pair);
                int currentNode = (int) pair.getKey();
                int currentColor = (int) pair.getValue();
                
                if(currentColor == 0){
                    // Blue color
                    ans[currentNode] = Math.min(ans[currentNode], distance);
         
                    for(int child : blueList.get(currentNode)){
                        Pair p = new Pair(child, 1);
                        if(!seen.contains(p)){
                            queue.add(p);
                        }
                    }
                }
                else{
                    // Red color
                    ans[currentNode] = Math.min(ans[currentNode], distance);
         
                    for(int child : redList.get(currentNode)){
                        Pair p = new Pair(child, 0);
                        if(!seen.contains(p)){
                            queue.add(p);
                        }
                    }
                }
            }
            distance++;
        }
        
        for(int i=0;i<n;i++){
            if(ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}