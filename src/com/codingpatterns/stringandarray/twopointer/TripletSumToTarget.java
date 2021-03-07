package com.codingpatterns.stringandarray.twopointer;
import java.util.*;

public class TripletSumToTarget {

  public static List<List<Integer>> searchTriplets(int[] arr, int targetSum) {
    Arrays.sort(arr);
    List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
        continue;
      searchPair(arr, targetSum-arr[i], i + 1, triplets, arr[i]);
    }

    return triplets;
  }

  private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets, int currentElement) {
    int right = arr.length - 1;
    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == targetSum) { // found the triplet
        triplets.add(Arrays.asList(currentElement, arr[left], arr[right]));
        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1])
          left++; // skip same element to avoid duplicate triplets
        while (left < right && arr[right] == arr[right + 1])
          right--; // skip same element to avoid duplicate triplets
      } else if (targetSum > currentSum)
        left++; // we need a pair with a bigger sum
      else
        right--; // we need a pair with a smaller sum
    }
  }

  public static void main(String[] args) {
   // System.out.println(TripletSumToTarget.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
   // System.out.println(TripletSumToTarget.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    System.out.println(TripletSumToTarget.searchTriplets(new int[] { 5, 2, 1, 4, 3 }, 8 ));
  }

}
