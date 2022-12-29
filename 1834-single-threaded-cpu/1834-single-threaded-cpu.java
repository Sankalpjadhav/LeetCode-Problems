class Solution {
    public int[] getOrder(int[][] tasks) {
        HashMap<int [], Integer> map = new HashMap<>();
        int n = tasks.length;

        for(int i=0;i<n;i++){
            map.put(tasks[i], i);
        }

        Arrays.sort(tasks, (a, b)->a[0]-b[0]);

        PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]){
                // when processing time is same, we prefer smallest index
                return map.get(a) - map.get(b);
            }
            else{
                // when processing time is not same, we prefer smallest processing time
                return a[1] - b[1];
            }
        });
        int [] result = new int[n];
        int i = 0;
        int time = tasks[0][0]; // starting time
        int j = 0;
        while(!minHeap.isEmpty() || i<n){
            while(i<n && time>=tasks[i][0]){
                minHeap.add(tasks[i]);
                i++;
            }
            
            if(minHeap.isEmpty()){
                time = tasks[i][0]; // fast forward
            }
            else{
                int [] task = minHeap.poll();
                time += task[1];
                result[j++] = map.get(task);
            }

        }


        return result;
    }
}