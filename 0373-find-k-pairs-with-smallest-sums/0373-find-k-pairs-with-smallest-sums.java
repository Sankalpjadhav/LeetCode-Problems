class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> (a[0]+a[1]) - (b[0]+b[1]));
        
        for(int i=0;i<n1 && i<k;i++){
            int [] pair = {nums1[i], nums2[0], 0};
            minHeap.add(pair);
        }
        
        for(int i=0;i<k && !minHeap.isEmpty();i++){
            int [] pair = minHeap.poll();
            result.add(new ArrayList<>(Arrays.asList(pair[0], pair[1])));
            int num2CurrentIndex = pair[2];
            if(num2CurrentIndex < n2-1){
                minHeap.add(new int[]{pair[0], nums2[num2CurrentIndex+1], num2CurrentIndex+1});
            }
        }
        
        return result;
    }
}