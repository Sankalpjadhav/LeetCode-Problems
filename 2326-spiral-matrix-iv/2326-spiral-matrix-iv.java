/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] matrix = new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(matrix[i], -1);
        }
        
        int left = 0, right = n-1, top = 0, bottom = m-1;
        int direction = 0;
        ListNode ptr = head;
        
        while(ptr!=null && left <= right && top <= bottom){
            if(direction == 0){
                for(int i=left;i<=right;i++){
                    matrix[top][i] = ptr.val;
                    ptr = ptr.next;
                    if(ptr == null){
                        break;
                    }
                }
                top++;
                direction = 1;
            }
            else if(direction == 1){
                for(int i=top;i<=bottom;i++){
                    matrix[i][right] = ptr.val;
                    ptr = ptr.next;
                    if(ptr == null){
                        break;
                    }
                }
                right--;
                direction = 2;
            }
            else if(direction == 2){
                for(int i=right;i>=left;i--){
                    matrix[bottom][i] = ptr.val;
                    ptr = ptr.next;
                    if(ptr == null){
                        break;
                    }
                }
                bottom--;
                direction = 3;
            }
            else if(direction == 3){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left] = ptr.val;
                    ptr = ptr.next;
                    if(ptr == null){
                        break;
                    }
                }
                left++;
                direction = 0;
            }
        }
        
        return matrix;
    }
}