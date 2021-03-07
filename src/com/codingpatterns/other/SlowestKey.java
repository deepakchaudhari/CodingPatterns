package com.codingpatterns.other;

public class SlowestKey {

  public static char slowestKey( int[][] keyTimes ){
    int maxDiff = keyTimes[0][1];
    char key = (char)(keyTimes[0][0] + 'a');
    int preTime = keyTimes[0][1];

    for( int i = 1; i < keyTimes.length; i++ ){
      int diff = keyTimes[i][1] - preTime;
      if( diff > maxDiff ){
        maxDiff = diff;
        key = (char)(keyTimes[i][0] + 'a');
      }

      preTime = keyTimes[i][1];
    }

    return key;
  }

  public static void main(String args[]){

    int[][] keyTimes = {{0,2},{1,5},{0,9},{2,15}};

    System.out.println(slowestKey(keyTimes));

  }
}
