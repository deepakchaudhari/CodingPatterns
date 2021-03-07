
package com.codingpatterns.recursion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class RecursiveDigitSum {



    // Complete the superDigit function below.
    static int superDigit(String n, int k) {

      /**StringBuilder input = new StringBuilder(n);

      for(int i=1; i<k ; i++){
        input.append(n);
      }**/

      Long inputInt = Long.parseLong(n.toString());

      Long sum = Long.valueOf(0);

      while(inputInt>0){

        sum = sum + inputInt % 10;
        inputInt = inputInt/10;
      }

      sum = sum * k;


      return superDigitHelper(sum);
    }

    static int superDigitHelper(Long input){

      if(input <= 9) return input.intValue();

      Long sum = Long.valueOf(0);

      while(input>0){

        sum = sum + input % 10;
        input = input/10;
      }

      return superDigitHelper(sum);
    }


    public static void main(String[] args) throws IOException {

      System.out.println(superDigit("593", 10));
    }
}



