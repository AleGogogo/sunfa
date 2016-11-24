package sort;
/**
 *  ±º‰∏¥‘”∂»£∫O(n2)
 * @author LYW
 *
 */
public class BubbleSort {
		public void sort(int[] list) {
			boolean needNextPass = true;
			for (int i = 1; i < list.length && needNextPass; i++) {
				   needNextPass = false;
				   for(int k = 0;k<list.length-i;k++){
					   if (list[k]>list[k+1]) {
						     int temp = list[i];
						     list[i] = list[i +1];
						     list[i +1] = temp;
						     needNextPass = true;
					}
				   }
				   
			}
			
		}
		
		public static <E extends Comparable<E> > void bubbleSort(E[] list) {
			   boolean needNextPass = true;
			   for (int i = 0; i < list.length-1 && needNextPass; i++) {
				   needNextPass = false;
				   if (list[i].compareTo(list[i+1])>0) {
					   E temp = list[i];
					     list[i] = list[i +1];
					     list[i +1] = temp;
					     needNextPass = true;
				}
			}
			
		}
}
