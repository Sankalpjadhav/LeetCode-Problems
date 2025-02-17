class Solution {
    public int numTilePossibilities(String tiles) {
     int n = tiles.length();
        HashSet<String> set = new HashSet<>();
        int [] visited = new int[n];
        helper(0, tiles, set, n, "", visited);
        System.out.println(set);
        return set.size();
    }

    private void helper(int index, String tiles, HashSet<String> set, int n, String currentString, int [] visited){
        if(currentString.length() != 0){
            set.add(currentString);
        }
        

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                helper(i, tiles, set, n, currentString+tiles.charAt(i), visited);
                visited[i] = 0;
            }
        }

    }
}