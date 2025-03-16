class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;

        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }
                else{
                    result +=leftMax - height[left];
                    
                }
                left++;
            }
            else{
                if(height[right] > rightMax){
                    rightMax = height[right];
                }
                else{
                    result +=rightMax - height[right];
                    
                }
                right--;
            }
        }

        return result;
    }
}

/*
Better approach: O(N + N + N)

public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int [] leftHeight = new int[n];
        int [] rightHeight = new int[n];

        // Calculate left maximum
        for(int i=0;i<n;i++){
            if(i == 0){
                leftHeight[i] = height[i];
            }
            else{
                leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
            }
        }

        // Calculate right maximum
        for(int i=n-1;i>=0;i--){
            if(i == n-1){
                rightHeight[i] = height[i];
            }
            else{
                rightHeight[i] = Math.max(rightHeight[i+1], height[i]);
            }
        }

        for(int i=0;i<n;i++){
            result += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return result;
    }


Brute force approach: O(n^2)

public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        for(int i=1;i<n-1;i++){
            
            int leftHeight = height[i];
            for(int j=0;j<i;j++){
                leftHeight = Math.max(leftHeight, height[j]);
            }

            int rightHeight = height[i];
            for(int k=i+1;k<n;k++){
                rightHeight = Math.max(rightHeight, height[k]);
            }

            result += Math.min(leftHeight, rightHeight) - height[i];
        }

        return result;
    }
*/