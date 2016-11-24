package sort;

import java.util.Stack;

public class QuikSort {
	/**
	 * 关键：该算法在数组中选择一个称为主元的元素，将数组分为两部分；
	 * 每次划分都将主元放在了恰当的位置
	 * 时间复杂度：O(nlogn)
	 * @param list
	 */

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	private static void quickSort(int[] list, int first, int last) {
		// TODO Auto-generated method stub
		if (first < last) {
			  paritionMedianOfTree(list, first, last);
			int privotIndex = partition(list, first, last);
//			int privotIndex = partition2(list, first, last);System.out.println(privotIndex);
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

		int pivot = list[first];
		int low = first + 1;
		int high = last;
		int temp = 0;
		while (high > low) {
			// 从左向右找一个比pivot大的数字
			while (low <=high && list[low] <= pivot)
				low++;
			// 从右到左找一个比pivot小的数字
			while (high >= low && list[high] >pivot)
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
					list[first] = list[high];
					list[high] = pivot;
					return high;
			}else {
				//没有被移动就返回原始下标
				return first;
			}
		
	}
	
/**
 * 三个数中确定基准值，将确定好的
 * @param attr
 * @param low
 * @param high
 */
      public  static void paritionMedianOfTree(int[] attr,int low,int high) {
    	  int mid = low + (high -low +1)/2;
    	  int cas = 0;
               if (attr[mid]>attr[high]) {
				  cas = attr[mid];
				    attr[mid] = attr[high];
				    attr[high] = cas ;
			}
            
               if (attr[low]>attr[high]) {
            	   cas  = attr[low];
				    attr[low] = attr[high];
				    attr[high] = cas ;
			}
               if (attr[mid] >attr[low]){
            	   	cas  = attr[mid];
				    attr[mid] = attr[low];
				    attr[low] = cas ; 
			}    	
	
}
      /**
       * 检查是不是升序排列
       * @param list
       * @return
       */
      public static boolean ordered(int[] list) {
    	for (int i = 0; i < list.length-1; i++) {
			     if (list[i]>list[i+1]) {
					   return false;
				}
		}
    	return true;
    	       
			
		}
		

	public static void main(String[] args) {
		    int[] data = {2,3,2,5,6,1,-2,3,14,12};
		   quickSort(data);
		   boolean result = ordered(data);
		   System.out.println(result);
	}
}
