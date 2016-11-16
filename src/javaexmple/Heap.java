package javaexmple;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Heap<E extends Comparable> {
	public ArrayList<E> list = new ArrayList<>();

	public Heap() {
		// TODO Auto-generated constructor stub
	}

	public Heap(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}

	public void add(E e) {
		// TODO Auto-generated method stub
		list.add(e);
		int currentIndex = list.size() - 1;

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(parentIndex);
				list.set(parentIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
			} else {
				break;
			}
			currentIndex = parentIndex;
		}
	}

	/**
	 * 堆排序的删除方法是删除根节点，即最大值
	 * 
	 * @return
	 */
	public E remove() {

		int currentIndex = list.size() - 1;
		E removeObject = list.get(0);
		list.set(0, list.get(currentIndex));
		list.remove(currentIndex);
		currentIndex = 0;
		
		while (currentIndex<list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			//find the mix between  two childen
				if (leftChildIndex>=list.size()) break;// the tree is a heap
		        int maxIndex = leftChildIndex;
		        if (rightChildIndex<list.size()) {
					 if (list.get(maxIndex).compareTo(list.get(rightChildIndex))<0) {
						       maxIndex = rightChildIndex;
					}
				}
		        //if current element is smaller than maxIndex element ,swap the two elements
		        if (list.get(currentIndex).compareTo(list.get(maxIndex))<0) {
					   E temp = list.get(maxIndex);
					   list.set(maxIndex, list.get(currentIndex));
					   list.set(currentIndex, temp);
					   currentIndex = maxIndex;
				}else {
					break;   //the tree is a heap
				}
		        		
		}
        
		return removeObject;

	}
	public int  getSize() {
		    return list.size();
	}
	
	public static <E extends Comparable>void heapSort(E[] data) {
		     Heap<E> heap = new Heap<E>();
		     for (int i = 0; i < data.length; i++) {
		    	 	heap.add(data[i]);
			}
		     for (int i = data.length-1; i > 0; i--) {
		    	 
		            //heap删除的每一个元素都是堆里目前的最大值，逆向赋给数组    
		    	 	data[i] =heap.remove();
				}
				    		 
}
	public static void main(String[] args) {
		Integer[] data = {2,3,2,5,6,1,-2,3,14,12};
		heapSort(data);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}