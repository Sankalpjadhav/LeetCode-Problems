class Solution {
    
    int [] smallest = new int[26];
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        for(int i=0; i<26; i++){
            smallest[i] = i;
        }
        
        for (int i=0; i<s1.length(); i++){
            Union(s1.charAt(i)-'a', s2.charAt(i)-'a');    
        } 
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<baseStr.length(); i++){
            ans.append((char)(findParent(baseStr.charAt(i) -'a')+'a'));
        } 

        return ans.toString();
    }
    
    
    
    private int findParent(int x){
        if(smallest[x] == x){
            return x;
        }
        return smallest[x] = findParent(smallest[x]);
    }
    
    private void Union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        
        if (x != y){ 
            smallest[Math.max(x, y)] = Math.min(x, y);
        }
    }
    

}