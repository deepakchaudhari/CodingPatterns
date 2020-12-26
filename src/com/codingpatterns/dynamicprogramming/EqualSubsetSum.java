package com.codingpatterns.dynamicprogramming;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,5,11,5] Output: true Explanation: The array can be partitioned as [1, 5, 5]
 * and [11]. Example 2:
 *
 * <p>Input: nums = [1,2,3,5] Output: false Explanation: The array cannot be partitioned into equal
 * sum subsets.
 */
import java.util.HashMap;
import java.util.Map;

public class EqualSubsetSum {

  public static void main(String args[]){

    int[] input = {1,5,11,5};

    System.out.println(canPartition(input));

    int [] negative = {1,2,3,5};

    System.out.println(canPartition(negative));

  }

  public static boolean canPartition(int[] nums) {

    if (nums.length <= 0) return false;
    int sum = 0;

    for (int i : nums) {
      sum = sum + i;
    }
    if (sum % 2 != 0) {
      return false;
    }

    return helper(nums, 0, 0, sum, new HashMap<>());
  }

  public static boolean helper(
      int[] nums, int index, int currentSum, int sum, Map<String, Boolean> state) {

    String current = index + "" + currentSum;

    if (state.containsKey(current)) {
      return state.get(current);
    }

    if (currentSum * 2 == sum) return true;

    if (currentSum > sum / 2 || index >= nums.length) {
      return false;
    }

    boolean result =
        helper(nums, index + 1, currentSum, sum, state)
            || helper(nums, index + 1, currentSum + nums[index], sum, state);

    state.put(current, result);
    return result;
  }
}
