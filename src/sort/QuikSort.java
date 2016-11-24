package sort;

import java.util.Stack;

public class QuikSort {
	/**
	 * �ؼ������㷨��������ѡ��һ����Ϊ��Ԫ��Ԫ�أ��������Ϊ�����֣�
	 * ÿ�λ��ֶ�����Ԫ������ǡ����λ��
	 * ʱ�临�Ӷȣ�O(nlogn)
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
	 * �ָ�list,��first��last
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
			// ����������һ����pivot�������
			while (low <=high && list[low] <= pivot)
				low++;
			// ���ҵ�����һ����pivotС������
			while (high >= low && list[high] >pivot)
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
					list[first] = list[high];
					list[high] = pivot;
					return high;
			}else {
				//û�б��ƶ��ͷ���ԭʼ�±�
				return first;
			}
		
	}
	
/**
 * ��������ȷ����׼ֵ����ȷ���õ�
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
       * ����ǲ�����������
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
