package com.codingpatterns.stringandarray.twopointer;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList {


  public static void main (String args []){

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    list1.add(1);
    list2.add(2);
    list2.add(3);
    list1.add(4);
    list1.add(5);
    list2.add(6);

    List<Integer> result = mergeList(list1,list2);

    System.out.println(result);

  }

  public static List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {

    int pointer1 = 0;
    int pointer2 = 0;
    List<Integer> restult = new ArrayList<>();

    while (pointer1 < list1.size()-1 && pointer2 < list2.size()-1) {

      if (list1.get(pointer1) < list2.get(pointer2)) {
        restult.add(list1.get(pointer1));
        pointer1++;
      }
      if (list1.get(pointer1) > list2.get(pointer2)) {
        restult.add(list2.get(pointer2));
        pointer2++;
      }
    }

    while (pointer1 < list1.size()) {
      restult.add(list1.get(pointer1));
      pointer1++;
    }
    while (pointer2 < list2.size()) {
      restult.add(list2.get(pointer2));
      pointer2++;
    }
    return restult;
  }




}
