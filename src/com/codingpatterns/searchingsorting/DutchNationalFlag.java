package com.codingpatterns.searchingsorting;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * <p>Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * <p>Follow up:
 *
 * <p>Could you solve this problem without using the library's sort function? Could you come up with
 * a one-pass algorithm using only O(1) constant space?
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Example 2:
 *
 * <p>Input: nums = [2,0,1] Output: [0,1,2] Example 3:
 *
 * <p>Input: nums = [0] Output: [0] Example 4:
 *
 * <p>Input: nums = [1] Output: [1]
 *
 * <p>Constraints:
 *
 * <p>n == nums.length 1 <= n <= 300 nums[i] is 0, 1, or 2.
 */



public class DutchNationalFlag {

  public static void main(String[] args){

    int nums[] = {2,0,2,1,1,0};

    int result[] = dutchNationalFlag(nums);

    for(int i=0;i<result.length;i++){
      System.out.println(result[i]);
    }



  }


  public static int[] dutchNationalFlag(int [] arr)
  {


    int start=0;
    int mid = 0;
    int end = arr.length-1;


    while(mid<=end){
      if(arr[mid]==0){
        swap(arr,start,mid);
        start++;
        mid++;
      }
      else if(arr[mid]==2){
        swap(arr,mid,end);
        end--;
      }
      else if(arr[mid]==1){
        mid ++;
      }

    }

    return arr;
  }


  private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
}
