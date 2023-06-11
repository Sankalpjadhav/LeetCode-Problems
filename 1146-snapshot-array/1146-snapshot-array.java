class SnapshotArray {
    HashMap<Integer, Integer>[] snapshots;
	int snapID;

    public SnapshotArray(int length) {
        snapshots = new HashMap[length];
        for(int i = 0; i < length; i++)
            snapshots[i] = new HashMap<>();
        snapID = 0;
    }
    
    public void set(int index, int val) {
        snapshots[index].put(snapID, val);
    }
    
    public int snap() {
        snapID++;
        return snapID - 1;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id >= 0){
            if(snapshots[index].containsKey(snap_id))
                return snapshots[index].get(snap_id);
            else
                snap_id--;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */