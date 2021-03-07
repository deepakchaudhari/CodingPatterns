package com.codingpatterns.tree.dfs;

public class BinaryTree {
/**
  // Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
/*
binary tree max path sum
========================

a path can start from any node and end at any node, a path should consists of at least one node.

    1
  2   3

 anw = 6

    -1
 -2   -3

 anw = -1

     1
  -1    -1
      2     3
               -1
 anw = 4

      4
  -1    -1
      2     3
               -1
 anw = 6


    1

        -3     2


        ==> -3 (-3 + 1)

        3 =  1 + 2

        ===> Pointer = 1
      2

  static class Node {
    int val;
    Node left;
    Node right;
  }

  int globalMax;

  int maxPathSum(Node root) {

    globalMax = root.val;

    helper(root);

    return globalMax;
  }

  int helper(Node node) { // 1. figure out and return the local max path sum that is usable by parent, those
    //    paths we consider need to end at "node", i.e., excluding the v-shaped path
    // 2. update the global max sum which needs to consider the v-shaped path

    if (root == null) return 0;

    int left = helper(node.left);
    int right = helper(node.right);

    int sumUsableByParent = Math.max(Math.max(left + node.val, right + node.val), node.val);  // 3 paths
    globalMax = Math.max(globalMax, Math.max(sumUsableByParent, left + right + node.val));  // 4 paths

    return sumUsableByParent;

  }

**/

}
