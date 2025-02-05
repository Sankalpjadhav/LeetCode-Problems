class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long l = (long)-1e11;
        long r = (long)1e11;
        long res = 0;
        while ( l<=r ) {
            long mid = (l+r)/2;
            // checking whether we have k at least k elements whose product is less than the current product
            // if yes then we know we have to move left
            if ( check(mid, nums1, nums2, k) ) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    public boolean check ( long mid, int[] nums1, int[] nums2, long k ) {
        long cnt = 0;
        for ( int i=0; i<nums1.length; i++ ) {
            long val = (long) nums1[i];
            // if current element is 0 and we out current product is >= 0 then we can add the whole second array because 0*anything will be 0
            if ( val==0 && mid>=0 ) {
                cnt += nums2.length;
            } else if ( val<0 ) {
                // If we encounter negative value we find the minimum index in the second array such that this element * minIndexElement <= current product
                cnt += findMinIndex(val, mid, nums2);
            } else if ( val>0 ) {
                // if we encounter positive element we find max index in the second array such that this element * maxIndexElement <= current product
                cnt += findMaxIndex(val, mid, nums2);
            }
        }
        // if we have atleast k elements whose product is less than current product
        return cnt>=k;
    }
    public long findMaxIndex( long val, long mid, int[] nums2 ) {
        int l = 0;
        int r = nums2.length - 1;
        // when no element in second array when multiplied by the current element of the first array yields result less that current product we will return res+1 hence -1 + 1 hence 0 coz there are no elements which when multiplied by current element of the first array yield result less than current product.
        long res = -1;
        while ( l<=r ) {
            int m = (l+r)/2;
            if ( val*nums2[m]<=mid ) {
                // if our current product is >= val*current element then we move the window to right side in order to find max index with which when multiplied the element of the first array is still less than current product.
                res = (long)m;
                l = m + 1; 
            } else {
                r = m - 1;
            }
        }
        // so we have found res+1 elements who satisfy our condition. +1 coz res would give index
        return res+1;
    }
    public long findMinIndex( long val, long mid, int[] nums2 ) {
        int l = 0;
        int r = nums2.length - 1;
        // when all elements of second array multiplied by current element of first array yield result > current product then we return 0 coz there are no elements which would yield us result.
        long res = r + 1;
        while ( l<=r ) {
            int m = (l+r)/2;
            if ( val*nums2[m]<=mid ) {
                r = m - 1;
                res = (long)m;
            } else {
                l = m + 1;
            }
        }
        return nums2.length - res;
    }
}

/*
So we want to find out k-th smallest product from the two sorted arrays. Let's first find out the range of our answer. So the minimum value it can go is if we have elements -10^5 in both the arrays so the minimum value is -10^10 and similarly for maximum value it is 10^10. Now we can do a binary search in our range and for every current product we can check whether we have atleast k products that are less than current product. If we do have atleast k products that are less than current product then we move our window left, otherwise to the right.

Ok so now we know what we have to do, lets now see how would we do what we wanna do?

So we iterate over nums1 and count the number of products that are less than current product.
Here three cases arise:

currentElement = 0: 0 * any number in nums2 will be 0. So if current product>=0 then we know that the whole array(nums2) would be included in our count.
currentElement>0: then we find maximum index in nums2 such that currentElement * nums2[maxIndex] is less than equal to current product. Then we can add maxIndex+1 elements into our count as they are less that equal to current product.
currentElement<0: then we do exact reverse of what we did in the previous case. We find minimum element that satisfies currentElement * nums2[minIndex]<= current product.
*/