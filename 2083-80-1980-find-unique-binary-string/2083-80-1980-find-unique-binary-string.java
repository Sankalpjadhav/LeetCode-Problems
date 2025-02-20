class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char [] chars = new char[nums[0].length()];

        for(int i=0;i<n;i++){
            chars[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }

        return String.valueOf(chars);
    }
}