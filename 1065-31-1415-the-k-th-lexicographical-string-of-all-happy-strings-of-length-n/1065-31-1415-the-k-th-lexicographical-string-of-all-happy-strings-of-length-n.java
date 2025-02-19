class Solution {
    public String getHappyString(int n, int k) {
        int [] count = {0};
        String [] result = {""};
        helper(0, '\0', "", result, n, k, count);
        return result[0] == "" ? "" : result[0];
    }

    private boolean helper(int level, char prevChar, String str, String [] result, int n, int k, int [] count){
        if(level == n){
            count[0]++;
            if(count[0] == k){
                result[0] = str;
                return true;
            }
            return false;
        }

        for(char ch='a';ch<='c';ch++){
            if(ch != prevChar && helper(level+1, ch, str+ch, result, n, k, count)){
                return true;
            }
        }

        return false;
    }
}