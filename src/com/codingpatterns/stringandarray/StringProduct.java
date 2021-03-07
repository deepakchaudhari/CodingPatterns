package com.codingpatterns.stringandarray;

public class StringProduct {

 /** public static void main(String[] args)
  {
     getTheProduct("123", "11");
  }

  5
  12





  static String getTheProduct(String firstNumber, String secondNumber) {

    StringBuilder result = new StringBuilder();

    int i = firstNumber.length() -1;
    int j = secondNumber.length() -1;

    int carry  = 0;

    while (i>= 0 || j>= 0){

      int product = carry;

      while (i>=0){
        product = firstNumber.charAt(i --) - '0' * secondNumber.charAt(j);
      }

    }

  }
**/

}
