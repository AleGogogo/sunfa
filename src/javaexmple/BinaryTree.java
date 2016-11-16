package javaexmple;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class BinaryTree<E extends Comparable<E>> extends AbstracTree<E> {

	protected int size = 0;
	protected TreeNode<E> root = null;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public BinaryTree(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}

	@Override
	public boolean search(E e) {
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;

	}

	@Override
	public void inorder() {
		// TODO Auto-generated method stub
		inorder(root);
	}

	protected void inorder(TreeNode<E> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.element + " ");
		inorder(root.right);
	}

	@Override
	public void postorder() {
		// TODO Auto-generated method stub
		postorder(root);
	}

	protected void postorder(TreeNode<E> root2) {
		if (root2 == null)
			return;
		postorder(root2.left);
		postorder(root2.right);
		System.out.println(root2.element + " ");
	}

	@Override
	public void preorder() {
		// TODO Auto-generated method stub
		preorder(root);
	}

	protected void preorder(TreeNode<E> root2) {
		if (root2 == null)
			return;
		System.out.println(root2.element + " ");
		preorder(root2.left);
		preorder(root2.right);
	}

	@Override
	public boolean delete(E e) {
		// 第一步，先找到要删除的元素
		TreeNode<E> current = root;
		TreeNode<E> parent = null;

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else {
				// 找到就退出
				break;
			}
			// 如果没有找到就返回false
			if (current == null) {
				return false;
			}
			// case1: 如果要删除的元素木有左子树
			// 连接parent 和当前节点的右孩子
			if (current.left == null) {
				// 如果删除的节点是root
				if (parent == null) {
					root = current.right;
				} else {
					if (e.compareTo(parent.element) < 0) {
						parent.left = current.right;
					} else {
                        parent.right = current.right;
					}
				}
			}else {
				//case2: if current node has right child 
				  TreeNode<E> parentOfRight = current;
				  TreeNode<E> rightMost=   current.left;
				  //找到当前节点最大的孩子
				 while (rightMost.right != null) {
					   parentOfRight = rightMost;
					   rightMost = rightMost.right;   
				}
				 //用这个最大的孩子和当前节点替换
				current.element = rightMost.element;
				if (parentOfRight.left == rightMost) {
					  parentOfRight.right = rightMost.left;
				}else {
					//if parentOgRight == current 则直接连接
					parentOfRight.left = rightMost.left;
				}
				
			}
			
			
		}
		return false;
	}

	@Override
	public boolean insert(E e) {
		// 如果是一棵空树
		if (root == null) {
			root = createTreeNode(e);
		} else {
			// locat the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {

				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					// 找到相同的元素就返回，插入失败
					return false;
				}
			}
			// 找到要插入的位置啦！
			if (e.compareTo(parent.element) < 0) {
				parent.left = createTreeNode(e);
			} else {
				parent.right = createTreeNode(e);
			}
		}
		size++;
		return true;
	}

	public TreeNode<E> createTreeNode(E e) {

		return new TreeNode(e);

	}

	static class TreeNode<E extends Comparable<E>> {
		E element;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E e) {
			// TODO Auto-generated constructor stub
			element = e;
		}

	}

	public int getSize() {
		return size;
	}

	public TreeNode getRoot() {
		return root;
	}

	/**
	 * Returns the root from the root leading to the specified element
	 * 
	 * @param e
	 * @return
	 */
	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
		TreeNode<E> current = root;
		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;

		}
		return list;

	}
}
