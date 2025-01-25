class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int n = candidates.length;

        findCombinations(0, n, candidates, target, combination, result);
        return result;
    }

    private void findCombinations(int index, int n, int [] candidates, int target, List<Integer> combination, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i=index;i<n;i++){
            if(index!=i && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] > target) break;
            combination.add(candidates[i]);
            findCombinations(i+1, n, candidates, target-candidates[i], combination, result);
            combination.remove(combination.size()-1);
        }
    }
}