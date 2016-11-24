package sort;

public class SortTest {
          public static void main(String[] args) {
        	  int[] list = {2,9,5,4,8,1,6};
        	  InsertSort in = new InsertSort();
        	  in.insertSort(list);
        	  for(int i = 0;i<list.length;i++){
 		    	 System.out.println(list[i]);
 		     }
		}
         
}
