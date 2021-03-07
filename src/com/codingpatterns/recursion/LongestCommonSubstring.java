package com.codingpatterns.recursion;
import java.io.*;
import java.util.*;

public class LongestCommonSubstring {



/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user2, user1) => ["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history
*/

// [/start, ]

    public static void main(String[] argv) {
      String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
      String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
      String[] user2 = {"a", "/one", "/two"};
      String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
      String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
      String[] user5 = {"a"};
      String[] user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};

      System.out.println(findLCSLength(user0, user1)); // => ["/pink", "/register", "/orange"]
      System.out.println(findLCSLength(user0, user2)); // => [] (empty)
      System.out.println(findLCSLength(user2, user1)); // => ["a"]
      System.out.println(findLCSLength(user5, user2)); // => ["a"]
      System.out.println(findLCSLength(user3, user4)); // => ["/plum", "/blue", "/tan", "/red"]
      System.out.println(findLCSLength(user4, user3)); // => ["/plum", "/blue", "/tan", "/red"]
      System.out.println(findLCSLength(user3, user6)); // => ["/tan", "/red", "/amber"]**/

    }


  public static List<String> findLCSLength(String[] s1, String[] s2) {
    return findLCSLengthRecursive(s1, s2, 0, 0, new ArrayList<>());
  }

  private static List<String> findLCSLengthRecursive(String[] s1, String[] s2, int i1, int i2, List<String> list) {
    if(i1 == s1.length || i2 == s2.length)
      return list;

    if(s1[i1].equals(s2[i2])){
      list.add(s1[i1]);
      findLCSLengthRecursive(s1, s2, i1+1, i2+1, list);
    }


    List<String> c1 = findLCSLengthRecursive(s1, s2, i1, i2+1, new ArrayList<>());
    List<String> c2 = findLCSLengthRecursive(s1, s2, i1+1, i2, new ArrayList<>());

    List<String> tempList = new ArrayList<>();

    if(c1.size() > c2.size()){
      tempList.addAll(c1);
    }else{
      tempList.addAll(c2);
    }

    if(tempList.size() > list.size()){
      return tempList;
    }else {
      return list;
    }

  }

    public static List<String> findContiguousHistory(String[] firstList, String[] secondList){

      int longestHistory = 0;

      List<String> result = new ArrayList<>();

      for(String s: firstList){ // /pink /register /orange

        for(String s1: secondList){ // /pink  /register /orange
          int currentCount = 0;
          if(s.equals(s1)){
            currentCount = currentCount+1;
            result.add(s1);
            longestHistory = Math.max(longestHistory, currentCount);
            if(longestHistory> currentCount){
              result.clear();
              result.add(s1);
            }
          }

        }


      }


      /**while(firstListSize <= firstList.length || secondListSize <= secondList.length){

       int currentCount = 0;

       if(firstList[firstListSize].equals(secondList[secondListSize])) {

       currentCount = currentCount+1;
       }

       longestHistory = Max(longestHistory, currentCount);
       rest

       }**/

      return result;

    }

  }



