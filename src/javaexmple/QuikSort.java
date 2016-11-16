package javaexmple;

public class QuikSort {

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	private static void quickSort(int[] list, int first, int last) {
		// TODO Auto-generated method stub
		if (first > last) {
			int privotIndex = partition(list, first, last);
			System.out.println(privotIndex);
			quickSort(list, first, privotIndex - 1);
			quickSort(list, privotIndex + 1, last);
		}
	}

	/**
	 * �ָ�list,��first��last
	 * 
	 * @param list
	 * @param first
	 * @param last
	 * @return
	 */
	private static int partition(int[] list, int first, int last) {
		// TODO Auto-generated method stub
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		int temp = 0;
		while (high > low) {
			// ����������һ����pivot�������
			while (low < high && list[low] <= pivot)
				low++;
			// ���ҵ�����һ����pivotС������
			while (high > low && list[high] >= pivot)
				high--;
			// �ҵ��Ժ󽻻�������
			if (high > low) {
				 temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		
		while (high > first && list[high] > pivot)
			high--;
		//�����Ԫ���ƶ����ͷ�����Ԫ�ƶ�����±�
            if (list[high]<pivot) {
					temp =pivot;
					pivot = list[high];
					list[high] = temp;
					return high;
			}else {
				//û�б��ƶ��ͷ���ԭʼ�±�
				return first;
			}
		
	}
	public static void main(String[] args) {
		    QuikSort sort = new QuikSort();
		    int[] data = {5,2,9,3,8,4,0,1,6,7};
		    sort.quickSort(data);
	}
}
