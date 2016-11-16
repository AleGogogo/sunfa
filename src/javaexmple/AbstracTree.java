package javaexmple;

import java.util.Iterator;

public abstract class AbstracTree<E extends Comparable<E>> 
        implements Tree<E>{
	
@Override
public int getSize() {
	// TODO Auto-generated method stub
	return 0;
}
    public void preorder() {
    	// TODO Auto-generated method stub
    	
    }

    public void inorder() {
    	// TODO Auto-generated method stub
    	
    }

    public void postorder() {
    	// TODO Auto-generated method stub
    	
    }
       public boolean isEmpty() {
    	// TODO Auto-generated method stub
    	return getSize() == 0;
    }
   
    public Iterator iterator() {
    	// TODO Auto-generated method stub
    	return null;
    }
	@Override
    public boolean insert(E e) {
    	// TODO Auto-generated method stub
    	return false;
    }

    public boolean delete(E e) {
    	// TODO Auto-generated method stub
    	return false;
    }

	public boolean search(E e) {
		// TODO Auto-generated method stub
		return false;
	}


}
