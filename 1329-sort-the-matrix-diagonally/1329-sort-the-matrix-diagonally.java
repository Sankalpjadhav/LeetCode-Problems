class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(i-j)){
                    map.get(i-j).add(mat[i][j]);
                }
                else{
                    map.put(i-j, new PriorityQueue<>());
                    map.get(i-j).add(mat[i][j]);
                }
            }
        }
        
        System.out.println(map);
        
        int i = m-1, j = 0;
        int k = 0, l = 0;
        while(i>=0 && j < n){
            k = i; // 2
            l = j; // 0
            
            while(k < m && l < n){
                mat[k][l] = map.get(k-l).poll();
                k++;
                l++;
            }
            
            if(k == m && i > 0){
                i--;
                continue;
            }
            if(l == n || i == 0){
                j++;
            }
        }
        
        return mat;
    }
}