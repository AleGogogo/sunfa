package query;

public class BinaryQuery {

	/**
	 * 条件：数组是排序数组 步骤：关键字先于中间值比较大小： 
	 * 分三种情况，若小于则继续在前半段进行比较，若大于在后半 段进行比较，若等于则查找成功
	 * 时间复杂度：（logn）
	 */
	public int query(int key, int[] data) {
		int low = 0;
		int hight = data.length - 1;
		int mid = (low + hight) / 2;
		while (low <= hight) {
			if (key < data[mid]) {
				hight = mid - 1;
			} else if (key > data[mid]) {
				low = mid + 1;
			} else if (key == data[mid]) {
				return mid;
			}

		}
		return -1;
	}
}
