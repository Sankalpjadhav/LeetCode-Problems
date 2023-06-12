class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int num=nums[i];
            while(i<nums.length-1 && nums[i]+1==nums[i+1]){
                i++;
            }
            if(num==nums[i]){
                result.add(num+"");
            }
            else{
                result.add(num+"->"+nums[i]);
            }
            i=i+1;
        }
        return result;
    }
}