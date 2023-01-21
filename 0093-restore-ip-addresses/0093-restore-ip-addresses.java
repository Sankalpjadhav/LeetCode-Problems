class Solution {
    
    void helper(String s, String possibleStr, int index, int count, List<String> ans) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            // ans.add(possibleStr); result was ["255.255.11.135.","255.255.111.35."] so we need to remove last dot
            ans.add(possibleStr.substring(0, possibleStr.length()-1));
            return;
        }
        
        for (int i = 1; i <= 3 && i+index <= s.length(); i++) {
            String num = s.substring(index, index + i);
            if (num.charAt(0) == '0' && i != 1) break;
            else if (Integer.parseInt(num) <= 255) {
                helper(s, possibleStr + num + ".", index + i, count + 1, ans);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        if(s.length() > 12){
            return ans; 
        }
        
        helper(s, "", 0, 0, ans);
        return ans;
    } 
}