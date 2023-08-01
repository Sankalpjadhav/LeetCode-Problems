class Solution {
    
    public void combinations(int start, ArrayList<Integer> tempList, List<List<Integer>> result, int n, int k){
        if(k==0){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int i=start;i<=n;i++){
            tempList.add(i);
            combinations(i+1, tempList, result, n, k-1);
            tempList.remove(tempList.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(1,new ArrayList<Integer>(), result, n, k);
        return result;
    }
}