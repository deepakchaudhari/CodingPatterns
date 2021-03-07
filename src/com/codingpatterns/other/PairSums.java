package com.codingpatterns.other;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class PairSums {

  // Add any helper functions you may need here


  int numberOfWays(int[] arr, int k) {
    // Write your code here
    HashMap<Integer, Integer> hm = new HashMap<>();
    int n = arr.length;

    // Store counts of all elements in map hm
    for (int i = 0; i < n; i++) {

      // initializing value to 0, if key not found
      if (!hm.containsKey(arr[i]))
        hm.put(arr[i], 0);

      hm.put(arr[i], hm.get(arr[i]) + 1);
    }
    int twice_count = 0;

    // iterate through each element and increment the
    // count (Notice that every pair is counted twice)
    for (int i = 0; i < n; i++) {
      if (hm.get(k - arr[i]) != null)
        twice_count += hm.get(k - arr[i]);

      // if (arr[i], arr[i]) pair satisfies the
      // condition, then we need to ensure that the
      // count is decreased by one such that the
      // (arr[i], arr[i]) pair is not considered
      if (k - arr[i] == arr[i])
        twice_count--;
    }

    // return the half of twice_count
    return twice_count / 2;

  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected);
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }

  public void run() {
    /**int k_1 = 6;
    int[] arr_1 = {1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, k_2);
    check(expected_2, output_2);**/

    // Add your own test cases here

    int k_3 = 4;
    int[] arr_3 = {2, 2, 2, 2, 2};
    int expected_3 = 4;
    int output_3 = numberOfWays(arr_3, k_3);
    check(expected_3, output_3);

  }
  public static void main(String[] args) {
    new PairSums().run();
  }
}
