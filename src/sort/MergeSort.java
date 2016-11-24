package sort;

public class MergeSort {
	
/**
 * ���ģ��������Ϊ���룬��ÿ���ֵݹ��Ӧ�ù鲢�����������ֶ�����ú󣬶����ǽ��й鲢
 * ʱ�临�Ӷȣ�O(n*log n)
 * @param list
 */
	public static void mergesort(int[] list) {
		// �ݹ�������ֱ���ֳ�һ��Ԫ��Ϊֹ
		if (list.length > 1) {
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergesort(firstHalf);

			int sencondHalfLength = list.length - list.length / 2;
			int[] sencondHalf = new int[sencondHalfLength];
			System.arraycopy(list, list.length / 2, sencondHalf, 0, sencondHalfLength);
			mergesort(sencondHalf);

			int[] temp = merge(firstHalf, sencondHalf);
			System.arraycopy(temp, 0, list, 0, temp.length);
		}
	}
private static int count = 0;
	public static int[] merge(int[] list1, int[] list2) {
		int[] temp = new int[list1.length + list2.length];
		int currentIndex1 = 0;// list1 de cursor
		int currentIndex2 = 0;// list2 de
		int currentIndex3 = 0;// temp de
        count++;
		while (currentIndex1 < list1.length && currentIndex2 < list2.length) {
			if (list1[currentIndex1] < list2[currentIndex2]) {
				temp[currentIndex3++] = list1[currentIndex1++];
			} else {
				temp[currentIndex3++] = list2[currentIndex2++];
			}
		}
		while (currentIndex1 < list1.length) {
			temp[currentIndex3++] = list1[currentIndex1++];
		}
		while (currentIndex2 < list2.length) {
			temp[currentIndex3++] = list2[currentIndex2++];
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]+" ("+count +")");
		}
	
	}
		return temp;
	}

	
	/**
	 * �鲢����ķ��ͷ���
	 * @param args
	 */
	 public static <E extends Comparable<E>> void mergeSort(E[] list) {
//	         if (list.length >1) {
//				  E[] firstHalf = new  E[list.length/2];
//				  System.arraycopy(list, 0, firstHalf, 0, list.length/2);
//				  mergeSort(firstHalf);
//			   
//	         }
	}
	 
	 
	public static void main(String[] args) {
		int[] a = { 2, 3,  1, 6, 5, -2, 3, 14, 12 };
		mergesort(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
	}

}
