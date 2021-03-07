package com.codingpatterns;

import java.util.HashSet;
import java.util.Set;

public class RipeTomatoes {


  public static int daysToRipeTomatoes(int[][] state){

    Set<String> fresh  = new HashSet<>();
    Set<String> ripe  = new HashSet<>();

    for(int i=0; i<state.length; i++){
      for(int j=0;j<state[i].length;j++){
        if(state[i][j] == 0){
          fresh.add(""+ i + j);
        } else if(state[i][j] == 1){
          ripe.add("" + i + j);
        }
      }
    }

    int days = 0;
    int[][] direcions = {{0,1}, {1,0}, {-1,0}, {0, -1}};


    while (fresh.size() > 0){
      Set<String> infected = new HashSet<>();
      for(String s: ripe){
        int i = s.charAt(0) - '0';
        int j = s.charAt(1) - '0';


        for( int[] direction : direcions){
          int nextI = i + direction[0];
          int nextJ = j + direction[1];
          if(fresh.contains("" + nextI +nextJ)){
            fresh.remove("" + nextI +nextJ);
            infected.add("" + nextI +nextJ);
          }
        }
      }

      if(infected.size() == 0){
        return -1;
      }

      ripe = infected;
      days++;

    }

    return days++;

  }

  public static void printInput(int arr[][]){
    // Loop through all rows
    for (int i = 0; i < arr.length; i++){
      // Loop through all elements of current row
      for (int j = 0; j < arr[i].length; j++){
        System.out.print(arr[i][j] + " ");
      }

      System.out.println();
    }


  }


  public static void main(String[] args)
  {

    //First Test with 6X4

    int arr[][] = { {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},};

    System.out.println("Input");
    printInput(arr);
    System.out.println("Output");


    int ans = daysToRipeTomatoes(arr);
    System.out.println(daysToRipeTomatoes(arr));
    System.out.println();


    //Second Test with 6X4

    int arr1[][] = { {0, -1, 0, 0, 0, 0},
        {-1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},};

    System.out.println("Input");
    printInput(arr1);
    System.out.println("Output");


    System.out.println(daysToRipeTomatoes(arr1));
    System.out.println();


    //Third Test with 6X4

    int arr3[][] = { {1, -1, 0, 0, 0, 0},
        {0, -1, 0, 0, 0, 0},
        {0, 0, 0, 0, -1, 0},
        {0, 0, 0, 0, -1, 1},};

    System.out.println("Input");
    printInput(arr3);
    System.out.println("Output");


    System.out.println(daysToRipeTomatoes(arr3));
    System.out.println();


    //Forth Test with 5X5

    int arr4[][] = { {-1, 1, 0, 0, 0},
        {0, -1, -1, -1, 0},
        {0, -1, -1, -1, 0},
        {0, -1, -1, -1, 0},
        {0, 0, 0, 0, 0},};

    System.out.println("Input");
    printInput(arr4);
    System.out.println("Output");


    System.out.println(daysToRipeTomatoes(arr4));
    System.out.println();


    //Fifth Test with 2X2

    int arr5[][] = { {1, -1},
        {-1, 1,}};

    System.out.println("Input");
    printInput(arr5);
    System.out.println("Output");

    System.out.println(daysToRipeTomatoes(arr5));

  }

}
