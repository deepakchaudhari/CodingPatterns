package com.codingpatterns.tree.dfs;

public class RangeSumOfBST {


  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    } else {
      return rangeHelper(root, low, high);
    }
  }

  public int rangeHelper(TreeNode currNode, int low, int high){
    if (currNode == null) {
      return 0;
    }
    if (currNode.val > high){
      return rangeHelper(currNode.left, low, high);
    } else if (currNode.val < low) {
      return rangeHelper(currNode.right, low, high);
    } else {
      return currNode.val + rangeHelper(currNode.right, low, high) + rangeHelper(currNode.left, low, high);
    }
  }

}
