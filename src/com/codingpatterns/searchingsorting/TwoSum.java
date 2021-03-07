package com.codingpatterns.searchingsorting;

public class TwoSum {


    public static void main (String args[]){

        int [] firstArr = {1,2,4,5,8};
        int sum= 10;


        System.out.println(doesHaveASum(firstArr, sum));

    }

    private static Boolean doesHaveASum(int[] firstArr, int sum) {

        if(firstArr.length<=0){
            return false;
        }

        int leftPointer =0;
        int rightPointer =firstArr.length-1;


        while (rightPointer>leftPointer){
            int tempSum = firstArr[rightPointer] + firstArr[leftPointer];
            if(sum == tempSum){
                return true;
            }
            if(tempSum >sum){
                rightPointer --;
            }
            if(tempSum<sum){
                leftPointer ++;
            }

        }
        return false;
    }
}
