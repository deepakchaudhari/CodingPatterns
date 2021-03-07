package com.codingpatterns.searchingsorting;

import java.util.*;
// Add any extra import statements you may need here


class TwoSumDuplicate {

  // Add any helper functions you may need here


  int numberOfWays(int[] arr, int k) {
    // Write your code here

    if(arr ==null || arr.length <= 0) return 0;

    Arrays.sort(arr);

    int start =0;
    int end = arr.length -1;
    int sum = 0;
    int count =0;
    int w= 0;

    while(start < end ){

      sum = arr[start] + arr[end];




      if(sum == k){
        count++;
        start++;


        if(arr[start] == k/2){
          w++;
        }

      }
      else if(sum<k){
        start++;
      }else{
        end --;
      }

    }

    if(w> 2){
      count = (w-1) * (w-1)/2 + count;
    }

    return count;

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
    int k_1 = 6;
    int[] arr_1 = {1, 2, 3, 4, 3};
    int expected_1 = 2;
    int output_1 = numberOfWays(arr_1, k_1);
    check(expected_1, output_1);

    int k_2 = 6;
    int[] arr_2 = {1, 5, 3, 3, 3};
    int expected_2 = 4;
    int output_2 = numberOfWays(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here

    int k_3 = 4;
    int[] arr_3 = {2, 2, 2, 2};
    int expected_3 = 6;
    int output_3 = numberOfWays(arr_3, k_3);
    check(expected_3, output_3);

  }
  public static void main(String[] args) {
    new TwoSumDuplicate().run();
  }
}