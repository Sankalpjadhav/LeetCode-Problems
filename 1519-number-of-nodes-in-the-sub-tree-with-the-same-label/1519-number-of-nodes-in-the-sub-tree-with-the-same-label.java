class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        int [] ans = new int[n];
        
        dfs(0, -1, list, labels, ans);
        
        return ans;
    }
    
    private int[] dfs(int node, int parent, List<List<Integer>> list, String labels, int [] ans){
        int [] count = new int[26];
        char nodeChar = labels.charAt(node);
        for(int adjNode: list.get(node)){
            if(adjNode == parent) continue;
            int [] childCountArray = dfs(adjNode, node, list, labels, ans);
            for(int i=0; i<26; i++){
                count[i] += childCountArray[i];
            }
        }
        count[nodeChar - 'a']++;
        ans[node] += count[nodeChar - 'a'];
        
        return count;
    }
}