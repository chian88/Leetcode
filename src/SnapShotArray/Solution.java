package SnapShotArray;
import java.util.*;

class SnapshotArray {
	TreeMap<Integer, Integer>[] array;
	int snap_id;
	public SnapshotArray(int length) {
		array = new TreeMap[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = new TreeMap<>();
			array[i].put(0, 0);
		}

		snap_id = 0;
	}

	public void set(int index, int val) {
		array[index].put(snap_id, val);
	}

	public int snap() {
		int temp = snap_id;
		snap_id++;
		return temp;
	}

	public int get(int index, int snap_id) {
		int ans = array[index].floorEntry(snap_id).getValue();

		return ans;
	}

	public static void main(String[] args) {
		SnapshotArray arr = new SnapshotArray(4);
		arr.snap();
		arr.snap();
		arr.get(3,1);
		arr.set(2,4);
		arr.snap();
		arr.set(1,4);
	}
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */