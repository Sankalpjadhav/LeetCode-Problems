class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new int[]{nums1[i], nums2[i]});
        }
        
        Collections.sort(list, (a,b)->b[1]-a[1]);
        
        long score = 0;
        long total = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        
        for(int i=0;i<n;i++){
            int [] pair = list.get(i);
            int x = pair[0];
            int y = pair[1];
            
            minHeap.add(x);
            total += x;
            
            if(minHeap.size() > k){
                total -= minHeap.poll();
            }
            
            if(minHeap.size() == k){
                score = Math.max(score, total * y);
            }
        }
        
        return score;
    }
}