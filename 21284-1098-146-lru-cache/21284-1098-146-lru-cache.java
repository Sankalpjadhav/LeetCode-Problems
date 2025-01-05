class LRUCache {
    class Node{
        int key, value;
        Node prev, next; // Doubly LinkedList
        Node(int _key, int _value){
            key = _key;
            value = _value;
            prev = null; 
            next = null;
        }
    }

    private int maxCapacity;
    private Node head, tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(maxCapacity == map.size()){
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key, node);
        Node headsNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headsNext;
        headsNext.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */