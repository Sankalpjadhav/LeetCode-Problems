class Solution {
    // In contest tried solving using recursion + Memo but it gave TLE bcoz of constraints 1 <= n <= 10^5
    // https://www.youtube.com/watch?v=5UU6j1cRQkw
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> nums = new ArrayList<>();
        int n = nums1.length;
        for(int i=0; i<n; i++){
            nums.add(new int[]{nums1[i], nums2[i]});
        }
        
        Collections.sort(nums, (a,b)->b[1]-a[1]);
        //System.out.println(nums);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long total = 0;
        long best = 0;
        for(int i=0; i<n; i++){
            int [] pair = nums.get(i);
            int x = pair[0];
            int y = pair[1];
            
            minHeap.add(x);
            total += x;
            
            if(minHeap.size() > k){
                int temp = minHeap.poll();
                total -= temp;
            }
            
            if(minHeap.size() == k){
                best = Math.max(best, total*y);
            }
        }
        
        return best;
    }
}