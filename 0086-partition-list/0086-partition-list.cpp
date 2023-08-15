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
    ListNode* partition(ListNode* head, int x) {
        ListNode* beforeX = new ListNode(-1);
        ListNode* beforePtr = beforeX;
        ListNode* afterX = new ListNode(-1);
        ListNode* afterPtr = afterX;
        
        while(head != nullptr){
            if(head->val < x){
                beforePtr->next = head;
                beforePtr = beforePtr->next;
                head = head->next;
            }
            else{
                afterPtr->next = head;
                afterPtr = afterPtr->next;
                head = head->next;
            }
        }
        
        beforePtr->next = afterX->next;
        afterPtr->next = nullptr;
        return beforeX->next;
    }
};