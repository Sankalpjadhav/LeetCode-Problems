class Solution {
    public int partitionString(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        int ans = 1;
        for(char ch: s.toCharArray()){
            if(map.containsKey(ch)){
                map.clear();
                ans++;
            }
            map.put(ch, true);
        }
        
        return ans;
    }
}