class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        
        int [] count = new int[1];
        int result = 0;
        for(int bomb=0; bomb<n; bomb++){
            count[0] = 0;
            dfs(bomb, count, bombs, new boolean[n]);
            result = Math.max(result, count[0]);
        }

        return result;
    }

    private void dfs(int bomb, int [] count, int [][] bombs, boolean [] visited){
        count[0]+=1;
        visited[bomb] = true;

        for(int adjBomb = 0; adjBomb<bombs.length; adjBomb++){
            if(!visited[adjBomb] && canDetonate(bombs[bomb], bombs[adjBomb])){
                visited[adjBomb] = true;
                dfs(adjBomb, count, bombs, visited);
            }
        }
    }

    private boolean canDetonate(int [] a, int [] b){
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        long r = a[2]; // we will be finding distance wrt to a to b

        return (dx*dx + dy*dy) <= (r*r);
    }
}