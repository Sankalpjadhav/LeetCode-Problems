class Solution {
    private int minimumUnfairness = (int) 1e9;
    
    public int distributeCookies(int[] cookies, int k) {
        int [] childrens = new int[k];
        helper(0, childrens, cookies, k);
        return minimumUnfairness;
    }
    
    private void helper(int index, int [] childrens, int [] cookies, int k){
        if(index == cookies.length){
            int max = -1;
            for(int num: childrens){
                max = Math.max(max, num);
            }
            minimumUnfairness = Math.min(minimumUnfairness, max);
            return;
        }
        
        for(int i=0;i<k;i++){
            childrens[i] += cookies[index];
            helper(index+1, childrens, cookies, k);
            childrens[i] -= cookies[index];
        }
        
    }
}