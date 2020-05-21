import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SnapshotArray {
	class Values {
		int value;
		int version;

		public Values(int version, int value) {
			this.version = version;
			this.value = value;
		}
	}

	int snapid = 0;
	Map<Integer, List<Values>> map = null;

	public SnapshotArray(int length) {
		map = new HashMap<>();

		for (int i = 0; i < length; i++) {
			List<Values> li = new LinkedList<>();
			Values val = new Values(0, 0);
			li.add(val);
			map.put(i, li);
		}
	}

	public void set(int index, int val) {
		List<Values> values = map.get(index);
		if (values.get(values.size() - 1).version == this.snapid) {
			Values v = values.get(this.snapid-1);
			v.value = val;
		} else {
			Values v = new Values(snapid, val);
			values.add(v);
		}
	}

	public int snap() {
		snapid++;
		return snapid - 1;
	}

	public int get(int index, int snap_id) {
		List<Values> list = map.get(index);
		int low = 0, high = list.size();
		while (low < high) {
			int mid = (low + high) / 2;
			if (list.get(mid).version <= snap_id) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		high--;
		if (high >= 0) {
			return list.get(high).value;
		} else {
			return 0;
		}
	}
}