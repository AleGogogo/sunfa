package chengxuyuanmianshisuanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;



public class TreeQestion {
	
	  class TreeNode {
		      int val;
		     TreeNode left;
		    TreeNode right;
		     TreeNode(int x) { val = x; }
		 }

	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
	 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 * 
	 * 答案看不懂
	 */
	  public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		          boolean isVailable = false;
		          isVailable = isVailable(pre)&&isVailable(in);
		          if (!isVailable) {
					  return null;
				}
		          if(pre.length == 0||in.length == 0){
		              return null;
		          }
		          TreeNode root = new TreeNode(pre[0]);
		          for(int i = 0; i < in.length; i++){
		              if(pre[0] == in[i]){
		                  root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
		                  root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
		              }
		          }
		          return root;
		      }

	        
	    
	
	//先进行有效性判断
	  private boolean isVailable(int[] in) {
		// TODO Auto-generated method stub
		  StringBuffer sBuffer = new StringBuffer();
		              for (int i = 0; i < in.length; i++) {
		            	     String str = Integer.toString(in[i]);
		            	  if (sBuffer.indexOf(str) ==-1) {
							   sBuffer.append(str);
						}else {
							return false;
						}
		              }
						   
						     return true;
							}
					



	/**
	   * 请实现一个函数，检查一棵二叉树是否为二叉查找树(BST)。
	   *给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
	   */
	  	private ArrayList<Integer>  list = new ArrayList<>();
	  	public boolean checkBST(TreeNode root) {
	  		//关键就是中序遍历然后比较 parent 和 current 的大小
	  		if (root == null) {
				return true;
			}
	  			Stack<TreeNode> stack = new Stack<TreeNode>();
	  			TreeNode pNode = root;
	  			boolean isFirst = true;
	  			int pre = 0; // 存储当前节点的前一个节点值
	  			//大循环右子树
	  			while ((pNode !=null)|| (!stack.isEmpty())) {
	  				//小循环左子树
					   while (pNode != null) {
						   stack.push(pNode);
						   pNode = pNode.left;
					}
					   pNode= stack.pop();
					   if (isFirst) {
						   isFirst = false;
						   pre = pNode.val;
					}else if (pNode.val<pre) {
						     return false;
					}else {
						pre = pNode.val;
					}
						pNode = pNode.right;
					}
	  			return true;
				}
	  	
	  	/**
	  	 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，
	  	 * 创建一棵高度最小的二叉查找树。
         *给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
	  	 * @param vals
	  	 * @return
	  	 */
	  	public int buildMinimalBST(int[] vals) {
	  		//对于一棵有N个节点高度为h的完全二叉树
	  		//h =[log2 n] +1;
//	  		int size = vals.length;       
//	        return (int)(Math.log(size)/Math.log(2))+1;
	  	//思路：
	  	//取数组的中间元素作为根，这样数组又分为两部分，又可以递归调用。
	  	//临界点是当数组被分割的只有2个或者1个时，那么无论怎么构造高度最低都为数
	  	//组的长度，我们再取左子树的高度和右子树的高度最大值，再加上根的高度，就
	  	//是最低高度，其实就就是构造平衡二叉树
	  		if (vals.length <= 2) {
				 return vals.length;
			}
	  		
	  		int left = buildMinimalBST(Arrays.copyOfRange(vals, 0, vals.length/2));
	  		int right = buildMinimalBST(Arrays.copyOfRange(vals, vals.length/2+1, vals.length));
	  		return left>=right? (left+1):(right+1);

	  	}
	  	
	  	/**
	  	 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，
	  	 * 其两颗子树的高度差不超过1。
        *给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
	  	 */
	  	public boolean isBalance(TreeNode root) {
	        if(root==null){
	            return true;
	        }else{
	            int left = getDeep(root.left);
	            int right = getDeep(root.right);
	            if(Math.abs(left-right)<=1){
	                return isBalance(root.left)&&isBalance(root.right);
	            }else{
	                return false;
	            }
	        }      
	    }
	      
	    public int getDeep(TreeNode root){
	        if(root!=null){
	            int left = getDeep(root.left);
	            int right = getDeep(root.right);
	            return left>right?left+1:right+1;
	        }else{
	            return 0;
	        }
	    }
}
	  	
	  	

	  	
