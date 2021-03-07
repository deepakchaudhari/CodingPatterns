package com.codingpatterns.stringandarray;

public class LongestCommonPrefix {

  public static void main (String[] args){

    String []  strs = {"flower","flow","flight"};

    System.out.println(longestCommonPrefix(strs));

    String []strs2 = {"dog","racecar","car"};

    System.out.println(longestCommonPrefix(strs2));


  }


  public static String longestCommonPrefix(String[] strs) {

    if (strs.length == 0) return "";

    String longestCommonPrefix = "";

    int index =0;

    for(char c : strs[0].toCharArray()){
      for(int i=1; i<strs.length;i++){
        if(index>=strs[i].length() || strs[i].charAt(index)!=c ){
          return longestCommonPrefix;
        }
      }
      longestCommonPrefix+=(c);
      index++;
    }

    return longestCommonPrefix;

  }

}
