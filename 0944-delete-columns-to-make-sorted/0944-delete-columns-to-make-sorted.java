class Solution {
    public int minDeletionSize(String[] strs) {
        int numberOfColsToBeDeleted = 0;
        
        for(int i=0;i<strs[0].length();i++){
            char ch = '@';
            boolean flag = false;
            for(String str : strs){
                if(ch > str.charAt(i)){
                    numberOfColsToBeDeleted++;
                    flag = true;
                }
                ch = str.charAt(i);
                if(flag){
                    break;
                }
            }
        }
        
        return numberOfColsToBeDeleted;
    }
}