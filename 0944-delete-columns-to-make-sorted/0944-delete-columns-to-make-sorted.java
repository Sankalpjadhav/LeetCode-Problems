class Solution {
    public int minDeletionSize(String[] strs) {
        int numberOfColsToBeDeleted = 0;
        
        for(int i=0;i<strs[0].length();i++){
            char ch = '@'; // ASCII code of @ is smaller than ASCII code of lowercase english letters 
            boolean flag = false;
            for(String str : strs){
                if(ch > str.charAt(i)){ 
                /*
                Compare the ASCII value, if previous character ASCII value is greater than current ASCII value 
                that means they are not sorted lexicographically
                */
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