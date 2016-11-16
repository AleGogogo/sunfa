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
	 * 分割list,从first到last
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
			// 从左向右找一个比pivot大的数字
			while (low < high && list[low] <= pivot)
				low++;
			// 从右到左找一个比pivot小的数字
			while (high > low && list[high] >= pivot)
				high--;
			// 找到以后交换两个数
			if (high > low) {
				 temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		
		while (high > first && list[high] > pivot)
			high--;
		//如果主元被移动，就返回主元移动后的下标
            if (list[high]<pivot) {
					temp =pivot;
					pivot = list[high];
					list[high] = temp;
					return high;
			}else {
				//没有被移动就返回原始下标
				return first;
			}
		
	}
	public static void main(String[] args) {
		    QuikSort sort = new QuikSort();
		    int[] data = {5,2,9,3,8,4,0,1,6,7};
		    sort.quickSort(data);
	}
}
