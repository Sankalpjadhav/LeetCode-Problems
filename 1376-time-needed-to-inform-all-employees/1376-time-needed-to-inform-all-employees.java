class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // graph creation
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<manager.length;i++){
            if(manager[i]>=0)
                adj.get(manager[i]).add(i);
        }
		
		//bfs
        Queue<int[]> q = new LinkedList<>();
        int max=0;
        q.add(new int[]{headID,0});
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                int[] temp = q.poll();
                max= Math.max(max,temp[1]);
                if(adj.get(temp[0]).size()==0) continue;
                for(int j:adj.get(temp[0])){
                    q.add(new int[]{j,temp[1]+informTime[temp[0]]});
                }
            }
        }
      return max;
    }
}