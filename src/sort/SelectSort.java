package sort;

public class SelectSort {
		/**
		 * ѡ���������ҳ���������С������Ȼ�����������е���ǰ��
		 * �������ظ���������
		 * ʱ�临�Ӷȣ�O(n2)
		 * ��i�����������n-i
		 * �ƶ��������ʼ�����й�
		 */
	public void selectSort(int[] list) {
		    
			for (int i = 0; i < list.length; i++) {
			       int currentMin =  list[i];//�ݴ���Сֵ
			       int currentMinIndex = i;//�ݴ���Сֵ���±�
			       for (int j = i+1; j < list.length; j++) {
			    	   	if(currentMin >list[j]){
			    	   		 currentMin = list[j];
			    	   		 currentMinIndex = j;
			    	   	}
			       }
			    	   	//ѭ��һ���ҵ��˴˴ε�list[i]ʱ����Сֵ
			    	   	//�����������ǣ����currentMinIndex != i;
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
