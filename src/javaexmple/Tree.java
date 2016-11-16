package javaexmple;

public interface Tree<E extends Comparable<E>>{
	//return true if element is in the tree
	
      public boolean search(E e) ;
      /*
       * insert element e into the binary search tree
       * return ture if successfully 
       */
	  public boolean insert(E e) ;
      public boolean delete(E e) ;
  
      public void inorder() ;
      public void postorder() ;
      public void preorder() ;
       
      public int  getSize() ;
      public boolean isEmpty();
      public java.util.Iterator iterator();

		

      


}
