class LRUCache {
    
    class Node{
        Node prev, next;
        int key, value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    final private int MAX_CAPACITY;
    HashMap<Integer, Node> map;
    Node head, tail;
    
    public LRUCache(int capacity) {
        this.MAX_CAPACITY = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            insert(new Node(key, value));
            return;
        }
        
        if(map.size() == MAX_CAPACITY){
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */