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
	   * ��ʵ��һ�����������һ�ö������Ƿ�Ϊ�����������
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
	  		

	  	}
	  	
	
	  	
