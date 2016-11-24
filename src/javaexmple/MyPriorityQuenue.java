package javaexmple;

import sort.Heap;

/**
 * 使用堆来实现优先队列，其中根节点是队列中具有最高优先级的对象。
 * @author LYW
 *
 */
public class MyPriorityQuenue <E extends Comparable>{
	static class Patient implements Comparable{
		private int priority;
		private String name;
		
		public Patient(String name,int prority) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.priority = prority;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "name is ( "+name+" ) "+"prority is ( "+ priority +" )";
		}
   

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
		return this.priority - ((Patient)o).priority;
		}

		
	}
	
	private Heap<E> heap = new Heap<E>();

	public  void enqueue(E o) {
		  heap.add(o);
	}
	
	public E  dequeue() {
		  return heap.remove();
	}
	
	public int getSize() {
		return heap.getSize();
	}
	
	public static void main(String[] args) {
		Patient patient1 = new Patient("John",2);
		Patient patient2 = new Patient("Mary",5);
		Patient patient3 = new Patient("Tim",1);
		Patient patient4 = new Patient("Jim",7);
		Patient patient5 = new Patient("Tom",4);
		
		MyPriorityQuenue  priorityQuenue = new MyPriorityQuenue();
		priorityQuenue.enqueue(patient1);
		priorityQuenue.enqueue(patient2);
		priorityQuenue.enqueue(patient3);
		priorityQuenue.enqueue(patient4);
		priorityQuenue.enqueue(patient5);
		
		while (priorityQuenue.getSize()>0) {
			System.out.print(priorityQuenue.dequeue() + " ");
		}
	}
	

}
