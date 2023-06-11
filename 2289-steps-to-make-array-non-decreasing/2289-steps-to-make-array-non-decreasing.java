class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int answer = 0;

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(nums[n - 1], 0));

        for(int i = n - 2; i >= 0; i--) {
            int count = 0;
            while(!stack.isEmpty() && nums[i] > stack.peek().getKey()) {
                count = Math.max(count + 1, stack.peek().getValue());
                stack.pop();
            }
            answer = Math.max(answer, count);
            stack.push(new Pair(nums[i], count));
        }
        return answer;
    }
}