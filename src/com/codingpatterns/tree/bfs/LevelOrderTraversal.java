package com.codingpatterns.tree.bfs;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;



public class LevelOrderTraversal {

  public static void main(String [] args){
    TreeNode lefttreeNode = new TreeNode(2,null,null);
    TreeNode treeNode = new TreeNode(1,lefttreeNode,null);

    System.out.println(levelOrder(treeNode));


  }


    public static List<List<Integer>> levelOrder(TreeNode root) {

      List<List<Integer>> result = new ArrayList<>();

      if(root==null) return result;


      Queue<TreeNode> queue = new LinkedList<>();

      queue.add(root);

      while(!queue.isEmpty()){
        int len = queue.size();
        List<Integer> tempResult = new ArrayList<>();

        for(int i=0; i<len; i++){

          TreeNode node = queue.remove();
        if (node != null) {
          tempResult.add(node.val);

          if (node.left != null) queue.add(node.left);
          if (node.left != null) queue.add(node.right);
          }

        }

        result.add(tempResult);

      }

      return result;

    }


}
/**
 * Definition for a binary tree node.
 * */

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
