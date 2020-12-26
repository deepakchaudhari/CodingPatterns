package com.codingpatterns.searchingsorting;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * <p>Example:
 *
 * <p>Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 *
 * <p>You must do this in-place without making a copy of the array. Minimize the total number of
 * operations.
 */
public class MoveZeroToLeft {

  public static void main(String[] args) {
    int[] input = {1, 0, 2, 5, 8, 0};
    int movingDigit =0;


    System.out.println("Moving "+movingDigit+" to Left");
    for (int i : moveDigitToLeft(input, 0)) {
      System.out.println(i);
    }

    int[] inputForRight = {1, 0, 2, 5, 8, 0};

    System.out.println("Moving "+movingDigit+" to Right");
    for (int i : moveDigitToRight(inputForRight, 0)) {
      System.out.println(i);
    }
  }

  public static int[] moveDigitToLeft(int[] input, int movingDigit) {

    int moveCounter = input.length - 1;
    int swapCounter = input.length - 1;

    while (moveCounter >= 0) {
      if (input[moveCounter] != movingDigit) {
        input[swapCounter] = input[moveCounter];
        swapCounter--;
      }

      moveCounter--;
    }

    while (swapCounter >= 0) {
      input[swapCounter] = movingDigit;
      swapCounter--;
    }
    return input;
  }



  public static int[] moveDigitToRight(int[] input, int movingDigit) {

    int moveCounter = 0;
    int swapCounter = 0;

    while (moveCounter <= input.length-1) {
      if (input[moveCounter] != movingDigit) {
        input[swapCounter] = input[moveCounter];
        swapCounter++;
      }

      moveCounter++;
    }

    while (swapCounter <= input.length-1) {
      input[swapCounter] = movingDigit;
      swapCounter++;
    }
    return input;
  }
}
