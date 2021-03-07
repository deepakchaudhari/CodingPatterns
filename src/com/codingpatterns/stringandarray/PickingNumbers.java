package com.codingpatterns.stringandarray;

/**
 * Given an array of integers, find the longest subarray where the absolute difference between any
 * two elements is less than or equal to .
 *
 * <p>Example
 *
 * <p>There are two subarrays meeting the criterion: and . The maximum length subarray has elements.
 */
public class PickingNumbers {

  /**public static int pickingNumbers(List<Integer> a) {
    int frequency[] = new int[101];
    int result = Integer.MIN_VALUE;

    for (int i = 0; i < a.size(); i++) {
      int index=a.get(i);
      frequency[index]++; //frequency[index]=frequency[index]+1
    }

    for (int i = 1; i <= 100; i++) {
      result = Math.max(result, frequency[i] + frequency[i - 1]);
    }
    return result;

  }**/

}
