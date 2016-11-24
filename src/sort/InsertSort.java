package sort;

public class InsertSort {

	/**
	 * 插入排序：在已经排好序的子序列中插入一个新元素
	 * 时间复杂度：O(N2);
	 */
	 public void insertSort(int[] list) {
		 
		 for (int i = 1; i < list.length; i++) {
			  int currentElement = list[i];//存入待插入的元素
			  int k;  // 要进行比较的数组的末位
			  for ( k = i-1; k >=0 && list[k]>currentElement; k --) {
				   list[k+1] = list[k];
			}
			  list[k +1] = currentElement ;
		}
	}
}
