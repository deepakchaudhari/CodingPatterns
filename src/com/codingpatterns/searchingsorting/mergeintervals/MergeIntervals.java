package com.codingpatterns.searchingsorting.mergeintervals;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * <p>Example 1:
 *
 * <p>Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation:
 * Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]. Example 2:
 *
 * <p>Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are
 * considered overlapping.
 */


public class MergeIntervals {

  public static void main(String[] args){
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

    int[][] result = merge(intervals);

    // Loop through all rows
    for (int i = 0; i < result.length; i++) {
      System.out.print("{ ");
      // Loop through all elements of current row
      for (int j = 0; j < result[i].length; j++) System.out.print(result[i][j] + " ");

      System.out.print("} ");
      }

    int[][] meeting1 ={{1,4}, {2,5}, {7,9}};
    int [][] meeting2 = {{6,7}, {2,4}, {8,12}};
    int [][] meeting3= {{1,4}, {2,3}, {3,6}};
    int [][] meeting4 = {{4,5}, {2,3}, {2,4}, {3,5}};


    System.out.print(meetingRequirement(meeting1));
    System.out.print(meetingRequirement(meeting2));
    System.out.print(meetingRequirement(meeting3));
    System.out.print(meetingRequirement(meeting4));



  }


  public static int[][] merge(int[][] intervals) {

    if(intervals.length<=0) return intervals;

    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));


    LinkedList<int[]> mearged = new LinkedList<>();

    for(int[] interval : intervals){
      if(mearged.isEmpty() || mearged.getLast()[1]<interval[0]){
        mearged.add(interval);
      }
      else{
        mearged.getLast()[1] = Math.max(mearged.getLast()[1],interval[1]);
      }
    }


    return mearged.toArray(new int[mearged.size()][]);



  }


  public static int meetingRequirement(int[][] intervals) {

    if(intervals.length<=0) return 0;

    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

    LinkedList<int[]> mearged = new LinkedList<>();

    for(int[] interval : intervals){
      if(mearged.isEmpty() || mearged.getLast()[1]<interval[0]){
        mearged.add(interval);
      }
      else{
        mearged.getLast()[1] = Math.max(mearged.getLast()[1],interval[1]);
      }
    }


    return mearged.size();



  }


}
