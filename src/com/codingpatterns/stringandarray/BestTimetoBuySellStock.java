package com.codingpatterns.stringandarray;

public class BestTimetoBuySellStock {

  public static int maxProfit(int[] prices) {


    int maxProfit = 0;
    int min = Integer.MAX_VALUE;


    for(int i=0;i< prices.length ;i++){

      if(prices[i] < min){
        min = prices[i];
      }else{
        maxProfit = Math.max(maxProfit, prices[i] - min);
      }
    }

    return maxProfit;

  }

  public static void main(String[] args) {
    int result = maxProfit(new int[] { 1, 3, 2, 6, 4, 1, 8, 2 });
    System.out.println("Max Profit is: " + result);
  }

}
