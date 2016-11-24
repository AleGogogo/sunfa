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
	 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
	 * ���������ǰ���������������Ľ���ж������ظ������֡�
	 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
	 * 
	 * �𰸿�����
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

	        
	    
	
	//�Ƚ�����Ч���ж�
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
	   * ��ʵ��һ�����������һ�ö������Ƿ�Ϊ���������(BST)��
	   *�������ĸ����ָ��TreeNode* root���뷵��һ��bool����������Ƿ�Ϊ�����������
	   */
	  	private ArrayList<Integer>  list = new ArrayList<>();
	  	public boolean checkBST(TreeNode root) {
	  		//�ؼ������������Ȼ��Ƚ� parent �� current �Ĵ�С
	  		if (root == null) {
				return true;
			}
	  			Stack<TreeNode> stack = new Stack<TreeNode>();
	  			TreeNode pNode = root;
	  			boolean isFirst = true;
	  			int pre = 0; // �洢��ǰ�ڵ��ǰһ���ڵ�ֵ
	  			//��ѭ��������
	  			while ((pNode !=null)|| (!stack.isEmpty())) {
	  				//Сѭ��������
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
	  	 * ����һ��Ԫ�ظ�����ͬ�Ұ��������е��������У����дһ���㷨��
	  	 * ����һ�ø߶���С�Ķ����������
         *����һ����������int[] vals,�뷵�ش����Ķ���������ĸ߶ȡ�
	  	 * @param vals
	  	 * @return
	  	 */
	  	public int buildMinimalBST(int[] vals) {
	  		//����һ����N���ڵ�߶�Ϊh����ȫ������
	  		//h =[log2 n] +1;
//	  		int size = vals.length;       
//	        return (int)(Math.log(size)/Math.log(2))+1;
	  	//˼·��
	  	//ȡ������м�Ԫ����Ϊ�������������ַ�Ϊ�����֣��ֿ��Եݹ���á�
	  	//�ٽ���ǵ����鱻�ָ��ֻ��2������1��ʱ����ô������ô����߶���Ͷ�Ϊ��
	  	//��ĳ��ȣ�������ȡ�������ĸ߶Ⱥ��������ĸ߶����ֵ���ټ��ϸ��ĸ߶ȣ���
	  	//����͸߶ȣ���ʵ�;��ǹ���ƽ�������
	  		if (vals.length <= 2) {
				 return vals.length;
			}
	  		
	  		int left = buildMinimalBST(Arrays.copyOfRange(vals, 0, vals.length/2));
	  		int right = buildMinimalBST(Arrays.copyOfRange(vals, vals.length/2+1, vals.length));
	  		return left>=right? (left+1):(right+1);

	  	}
	  	
	  	/**
	  	 * ʵ��һ�����������������Ƿ�ƽ�⣬ƽ��Ķ������£��������е�����һ����㣬
	  	 * �����������ĸ߶Ȳ����1��
        *����ָ����������ָ��TreeNode* root���뷵��һ��bool������������Ƿ�ƽ�⡣
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
	  	
	  	

	  	
