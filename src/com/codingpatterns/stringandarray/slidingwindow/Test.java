package com.codingpatterns.stringandarray.slidingwindow;

public class Test {


  // "Flee to me, remote elf!" -> true
// 1) Only [a-zA-Z]
// 2) Case-insensitive a=A

// Given string s, return true/false - is palindrome?

// Example:
// "ab0A" -> true. === A0ba
// "London" -> false

// 00aa0 == 0aa00 ==> true;
// aa == aa => true;
/**
-----
/**




  A tree is unival in x if and only if every node within the tree has the value x.
  A tree is unival if it is unival in x for some x.
  Write a function that determines whether a given tree is unival.


  class TreeNode{

    int value;
    TreeNode left;
    TreeNode right;
  }

  public boolean isTreeUniVal(TreeNode node, int inputValue){


  }

  boolean recurrcusiveTree(TreeNode node,int nodeValue){

    if (node.value != nodeValue)
      return false;

    if(node.value == nodeValue && node.left == null && node.right == null){
      return true;
    }
    Boolean left = true;
    if(node.left != null){
      left = recurrcusiveTree(node.left,node.nodeValue)
    }
    Boolean right = true;
    if(node.right != null){
      right = recurrcusiveTree(node.right,node.nodeValue)
    }

    return left && right;
  }


// TestCases

[3] - 2
    [3, null, 3] - 3 -
    [3, 3, 3] - 3
    [3, 2, 2]
    [3, 4, 3] - 3 == false




**/


}
