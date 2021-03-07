package com.codingpatterns.other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrisonLargestHole {

  public static void main(String args[]){
      int n = 2;
      int m = 2;



      List<Integer> h = new ArrayList<>();
      List<Integer> v = new ArrayList<>();

      h.add(1);
      v.add(2);


      System.out.println(getTheLargestHole(2,2,h,v));
  }


  static int getTheLargestHole(int n, int m, List<Integer> hor, List<Integer> ver) {
    Boolean[] xs = new Boolean[n +1 ];
    Boolean[] ys = new Boolean[m + 1];

    for (int h : hor) {
      xs[h] = true;
    }
    for (int v : ver){
      ys[v] = true;
    }
    int xm = 0, ym = 0;
    for (int i = 1, j = 0; i <= n; i++) {
      if (!xs[i]) j = 0;
		else xm = Math.max(xm, ++j);
    }
    for (int i = 1, j = 0; i <= m; i++) {
      if ( !ys[i]) j = 0;
		else ym = Math.max(ym, ++j);
    }
    return (xm + 1) * (ym + 1);
  }

  private long max(final int length, final int[] cuts) {
    Arrays.sort(cuts);
    // the initial cut
    int max = cuts[0];
    for (int i = 1; i < cuts.length; ++i) {
      max = Math.max(max, cuts[i] - cuts[i - 1]);
    }
    // compare the very last cut
    return Math.max(max, length - cuts[cuts.length - 1]);
  }

  public int maxArea(final int h,
      final int w,
      final int[] horizontalCuts,
      final int[] verticalCuts) {
    // don't forget to modulo this special number as the result can be huge
    return (int) (this.max(h, horizontalCuts) * this.max(w, verticalCuts) % 1000000007);
  }


}
