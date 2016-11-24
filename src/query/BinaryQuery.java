package query;

public class BinaryQuery {

	/**
	 * �������������������� ���裺�ؼ��������м�ֵ�Ƚϴ�С�� 
	 * �������������С���������ǰ��ν��бȽϣ��������ں�� �ν��бȽϣ�����������ҳɹ�
	 * ʱ�临�Ӷȣ���logn��
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
