class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [] result = new int[m];
        int [] nextGreaterElement = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i=n-1;i>=0;i--){ 
            indexMap.put(nums2[i], i);
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreaterElement[i] = -1;
            }
            else{
                nextGreaterElement[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        for(int j=0;j<m;j++){
            result[j] = nextGreaterElement[indexMap.get(nums1[j])];
        }
        
        return result;
    }
}