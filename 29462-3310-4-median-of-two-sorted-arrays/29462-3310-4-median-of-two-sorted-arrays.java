class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(n < m){
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalElements = m + n;

        int low = 0;
        int high = m;

        while(low <= high){
            int cut1 = (low + high)/2;
            int cut2 = (totalElements+1)/2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            if(left1 <= right2 && left2 <= right1){
                if(totalElements % 2 == 0){
                    return (double)(Math.max(left1, left2) + Math.min(right1, right2))/2;
                }
                else{
                    return (double)Math.max(left1, left2);
                }
            }
            else if(left1 >= right2){
                high = cut1-1;
            }
            else{
                low = cut1+1;
            }
        }

        return 0.0;

    }

}

/*
Better approach with no space 
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int totalElements = m + n;
        int count = totalElements / 2;

        int i = 0, j = 0;
        int currentElement = 0, prevElement = 0;

        for (int k = 0; k <= count; k++) {
            prevElement = currentElement;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                currentElement = nums1[i];
                i++;
            } else {
                currentElement = nums2[j];
                j++;
            }
        }

        if (totalElements % 2 == 0) {
            return (double)(prevElement + currentElement) / 2;
        } else {
            return (double)currentElement;
        }

    }

Brute force: TC: O(m+n), SC: O(m+n)

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> elements = new ArrayList<>();

        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(index1 < m && index2 < n){
            if(nums1[index1] <= nums2[index2]){
                elements.add(nums1[index1]);
                index1++;
            }
            else{
                elements.add(nums2[index2]);
                index2++;
            }
        }

        while(index1 < m){
            elements.add(nums1[index1]);
            index1++;
        }

        while(index2 < n){
            elements.add(nums2[index2]);
            index2++;
        }

        double result = 0.0;
        if(m == 0 && n == 0) return result;
        if((m+n) % 2 == 0){
            int index = (m+n)/2;
            result = (double)(elements.get(index) + elements.get(index-1))/2; 
        }
        else{
            result = (double)elements.get((m+n)/2);
        }

        return result;
    }
*/