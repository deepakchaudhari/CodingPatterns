package com.codingpatterns.stringandarray.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToTarget1 {

  public static List<List<Integer>> searchTriplets(int[] arr, int targetSum) {
    Arrays.sort(arr);

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < arr.length - 2; i++) {

      searchThePair(arr,i+1,targetSum - arr[i], arr[i], result);

    }

    return result;
  }

  public static void searchThePair(int[] arr, int start, int target, int input, List<List<Integer>> result){

    int end = arr.length -1;
    int currentSum = 0;

    while (start < end){
      currentSum = arr[start] + arr[end];
      if(currentSum == target){
        result.add(Arrays.asList(input,arr[start], arr[end]));
        start++;
        end --;
      }

      if(currentSum > target){
        end --;
      }
      if(target > currentSum){
        start ++;
      }
    }

  }

  public static void main(String[] args) {
   // System.out.println(TripletSumToTarget.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
   // System.out.println(TripletSumToTarget.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    System.out.println(TripletSumToTarget1.searchTriplets(new int[] { 5, 2, 1, 4, 3 }, 8 ));
  }

}
