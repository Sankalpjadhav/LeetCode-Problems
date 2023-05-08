class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, result, new ArrayList<>());
        return result;
    }
    
    private void helper(int num, int k, int n, List<List<Integer>> result, List<Integer> list){
        if(k == 0){
            if(n == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(num > 9){
            return;
        }
        
        // Include
        list.add(num);
        helper(num+1, k-1, n-num, result, list);
        list.remove(list.size()-1);
        
        // Do not include
        helper(num+1, k, n, result, list);
    }
        
}