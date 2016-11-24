package sort;

public class SelectSort {
		/**
		 * 选择排序：先找出数列中最小的数，然后将它放在数列的最前面
		 * 接下来重复上述步骤
		 * 时间复杂度：O(n2)
		 * 第i趟排序次数是n-i
		 * 移动次序与初始排列有关
		 */
	public void selectSort(int[] list) {
		    
			for (int i = 0; i < list.length; i++) {
			       int currentMin =  list[i];//暂存最小值
			       int currentMinIndex = i;//暂存最小值的下标
			       for (int j = i+1; j < list.length; j++) {
			    	   	if(currentMin >list[j]){
			    	   		 currentMin = list[j];
			    	   		 currentMinIndex = j;
			    	   	}
			       }
			    	   	//循环一次找到了此次当list[i]时的最小值
			    	   	//交换，条件是：如果currentMinIndex != i;
			    	   	if (currentMinIndex != i) {
			    	   			list[currentMinIndex] = list[i];
			    	   			list[i] =currentMin;
						}
				}
			
		
	}
	
	public static void main(String[] args) {
		     int[] list = {2,9,5,4,8,1,6};
		     SelectSort s = new SelectSort();
		     s.selectSort(list);
		     for(int i = 0;i<list.length;i++){
		    	 System.out.println(list[i]);
		     }
	}
}
