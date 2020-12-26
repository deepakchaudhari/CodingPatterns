package com.codingpatterns.searchingsorting;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


/**
 * Problem statement # Given an array, find all the duplicates that exist in that array.
 *
 * Input # An integer array
 *
 * Output # The output is an ArrayList containing the duplicates if they exist and an empty
 * ArrayList if they don’t.
 *
 * Sample input # int arr[] = {1, 3, 4, 3, 5, 4, 100, 100};
 *
 * Sample output # ArrayList <Integer> output = {3, 4, 100};
 */
public class FindAllDuplicates {

  public static void main(String args[]){

    int arr[] = {1, 3, 4, 3, 5, 4, 100, 100};

    System.out.println(findDuplicates(arr));
  }

  public static ArrayList < Integer > findDuplicates(int[] arr) {
    ArrayList < Integer > duplicates = new ArrayList <Integer> ();

    Map<Integer,Integer> map = new HashMap<>();

    for(int count=0; count<arr.length;count++){
      int value = arr[count];
      if(map.containsKey(value)){
        map.put(value,map.get(value)+1);
        duplicates.add(value);
      }else{
        map.put(arr[count],1);
      }
    }

    return duplicates;
  }
}
