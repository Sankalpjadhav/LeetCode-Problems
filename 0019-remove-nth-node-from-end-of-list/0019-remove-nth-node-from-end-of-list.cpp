/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int length = getLength(head);
        ListNode* dummy = new ListNode(-1);
        ListNode* ptr = dummy;
        ptr->next = head;
        int k = length - n;
        
        while(k-- > 0){
            ptr = ptr->next;
        }
        
        ptr->next = ptr->next->next;
        
        return dummy->next;
    }
    
private:
    int getLength(ListNode* head){
        int length = 0;
        ListNode* ptr = head;
        
        while(ptr != nullptr){
            length++;
            ptr = ptr->next;
        }
        
        return length;
    }
};