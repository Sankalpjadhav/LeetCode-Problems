class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        int n = path.length();
        
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(x,y));
        
        for(int i=0;i<n;i++){
            char ch = path.charAt(i);
            if(ch == 'N'){
                x = x - 1; 
            }
            else if(ch == 'E'){
                y = y + 1;
            }
            else if(ch == 'S'){
                x = x + 1;
            }
            else if(ch == 'W'){
                y = y - 1;
            }
            if(set.contains(new Pair(x,y))){
                return true;
            }
            else{
                set.add(new Pair(x,y));
            }
        }
        
        return false;
    }
}