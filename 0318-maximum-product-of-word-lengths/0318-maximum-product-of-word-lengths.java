class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int [] arr = new int[n];  
     
        int ans = 0;
        
        for(int i=0;i<n;i++){
           for(char ch:words[i].toCharArray()){
             arr[i]|=(1<<ch-'a');
           }
           for(int j=0;j<i;j++){
              if((arr[i] & arr[j])==0){
                ans = Math.max(ans, words[i].length()*words[j].length());
              }
           }
        }
        
        return ans;
    }
}