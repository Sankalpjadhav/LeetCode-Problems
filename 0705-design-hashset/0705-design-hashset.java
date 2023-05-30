class MyHashSet {
    
    private HashMap<Integer, Boolean> set;

    public MyHashSet() {
        set = new HashMap<>();
    }
    
    public void add(int key) {
        set.put(key, true);
    }
    
    public void remove(int key) {
        if(set.containsKey(key)){
            set.remove(key);
        }
    }
    
    public boolean contains(int key) {
        return set.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */