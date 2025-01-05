class Solution {
    // Most optimal single pass solution
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        
        Stack<Integer> container = new Stack<>();

        for(int i=0;i<=n;i++){
            while(!container.isEmpty() && (i == n || heights[i] <= heights[container.peek()])){
                int findAreaForHeight = heights[container.pop()];
                int width;
                if(container.isEmpty()) width = i;
                else {
                    width = i - container.peek() - 1;
                }
                maxArea = Math.max(maxArea, findAreaForHeight*width);
            }
            container.push(i);
        }

        return maxArea;
    }
}


/*
Brute force: TLE since its time complexity is O(N^2)
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        
        for(int i=0;i<n;i++){
            int leftBoundary = 0;
            for(int j=i-1;j>=0;j--){
                if(heights[j] < heights[i]){
                    leftBoundary = j+1;
                    break;
                }
            }

            int rightBoundary = n-1;
            for(int k=i+1;k<n;k++){
                if(heights[i] > heights[k]){
                    rightBoundary = k-1;
                    break;
                }
            }
            int width = rightBoundary - leftBoundary + 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

Optimal Solution 1 : Time complexity: O(5N), Space complexity: O(3N): Usually stop here only in the Interview.
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        
        int [] prevSmallerHeight = new int[n];
        int [] nextSmallerHeight = new int[n];

        Stack<Integer> containerIndex = new Stack<>();

        // Calculate prev smaller height
        for(int i=0;i<n;i++){
            while(!containerIndex.isEmpty() && heights[containerIndex.peek()] >= heights[i]){
                containerIndex.pop();
            }
            if(containerIndex.isEmpty()){
                prevSmallerHeight[i] = 0;
            }
            else{
                prevSmallerHeight[i] = containerIndex.peek()+1;
            }
            containerIndex.push(i);
        }

        while(!containerIndex.isEmpty()) containerIndex.pop();

        // Calculate next smaller height
        for(int i=n-1;i>=0;i--){
            while(!containerIndex.isEmpty() && heights[containerIndex.peek()] >= heights[i]){
                containerIndex.pop();
            }
            if(containerIndex.isEmpty()){
                nextSmallerHeight[i] = n-1;
            }
            else{
                nextSmallerHeight[i] = containerIndex.peek()-1;
            }
            containerIndex.push(i);
        }

        for(int i=0;i<n;i++){
            int width = nextSmallerHeight[i] - prevSmallerHeight[i] + 1;
            maxArea = Math.max(maxArea, heights[i]*width);
        }

        return maxArea;
    }
*/