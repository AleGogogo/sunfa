package sort;

public class InsertSort {

	/**
	 * �����������Ѿ��ź�����������в���һ����Ԫ��
	 * ʱ�临�Ӷȣ�O(N2);
	 */
	 public void insertSort(int[] list) {
		 
		 for (int i = 1; i < list.length; i++) {
			  int currentElement = list[i];//����������Ԫ��
			  int k;  // Ҫ���бȽϵ������ĩλ
			  for ( k = i-1; k >=0 && list[k]>currentElement; k --) {
				   list[k+1] = list[k];
			}
			  list[k +1] = currentElement ;
		}
	}
}
