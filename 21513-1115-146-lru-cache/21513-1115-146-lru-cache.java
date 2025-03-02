class LRUCache {

    class Node{
        int key, value;
        Node prev, next;
        Node(int _key, int _value){
            key = _key;
            value = _value;
            prev = null;
            next = null;
        }
    }

    private int maxCapacity;
    private Node head, tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        int value = map.get(key).value;
        remove(map.get(key));
        insert(key, value);
        return value;
    }

    private void remove(Node node){
        int key = node.key;
        int value = node.value;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private void insert(int key, int value){
        Node node = new Node(key, value);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
        map.put(key, node);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            insert(key, value);
        }
        else{
            if(map.size() == maxCapacity){
                remove(tail.prev);
            }
            insert(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */