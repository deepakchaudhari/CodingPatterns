package com.codingpatterns.tree.dfs;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * <p>A valid BST is defined as follows:
 *
 * <p>The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees.
 *
 * <p>Example 1:
 *
 * <p>Input: root = [2,1,3] Output: true Example 2:
 *
 * <p>Input: root = [5,1,4,null,null,3,6] Output: false Explanation: The root node's value is 5 but
 * its right child's value is 4.
 */


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class ValidBST {

  public static void main(String [] args){


    TreeNode leftnode = new TreeNode(1,null,null);

    TreeNode rightnode = new TreeNode(3,null,null);

    TreeNode node = new TreeNode(2,leftnode,rightnode);

    System.out.println(isValidBST(node));

  }

  public static boolean isValidBST(TreeNode root) {

    return validate(root, null, null);

  }

  private static boolean validate(TreeNode root, Integer max, Integer min){

    if(root ==null){
      return true;
    }

    else if(max!= null && root.val>=max || min!= null && root.val<=min){
      return false;
    }
    else{
      return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }

  }


}
