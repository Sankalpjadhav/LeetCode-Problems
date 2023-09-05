/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/**
https://www.youtube.com/watch?v=Py6tPf74Kyc
*/
class Solution {
    //Optimized Space solution i.e without hashmap
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        
        Node iter = head;
        Node front = head;
        while(iter!=null){
            front = iter.next;
            Node copyNode = new Node(iter.val);
            iter.next = copyNode;
            copyNode.next = front;
            iter = front;
        }
        // Random pointers
        iter = head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random = iter.random.next;
            }
            iter=iter.next.next;
        }
        // Seperate the original list and deep copy list
        iter = head;
        Node copyHead = new Node(-1);
        Node ptr = copyHead;
        while(iter!=null){
            ptr.next = iter.next;
            ptr = ptr.next;
            iter.next = ptr.next;
            iter = iter.next;
        }
        return copyHead.next;
    }
    
    
    /* NAIVE APPROACH
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        HashMap<Node,Node> map=new HashMap<>();
        Node current=head;
        while(current!=null){
            map.put(current,new Node(current.val));
            current=current.next;
        } 
        
        {
          7:7',
          13:13',
          11:11',
          10:10',
          1:1'
        }

        current=head;// At the end of while we have current pointing to the null, so make it point back to head
        while(current!=null ){ // Assign all the next and random pointers
            map.get(current).next= current.next!=null ? map.get(current.next): null;
            map.get(current).random=current.random!=null ? map.get(current.random): null;
            current=current.next;
        }
        return map.get(head); // We know first key:val pair is the head just return the val 
        
    }
*/
}