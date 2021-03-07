package com.codingpatterns.searchingsorting;

public class IntersectionIOfTwoSortedArr {

    public static void main(String args[]){
        int arr1[]= {1,2,6,8,9,10};
        int arr2[] ={1,2,3,4,6,9};

        findCommonElements(arr1,arr2);
    }

    private static int[] findCommonElements(int[] arr1, int[] arr2) {

        int resultArrIdx =0;

        if(arr1.length-1>arr2.length-1){
            resultArrIdx = arr1.length-1;
        }else{
            resultArrIdx = arr2.length-1;
        }
        int pointer1=0;
        int pointer2=0;
        int resultArr[] = new int[resultArrIdx];
        int pointer=0;



        while(arr1.length-1>=0 && arr2.length-1>=0){

            if(arr1[pointer1]==arr2[pointer2]){
                resultArr[pointer] = arr1[pointer1];
                pointer++;
            }
            if(arr1[pointer1]<arr2[pointer2]){
                pointer1++;
            }
            if(arr1[pointer1]>arr2[pointer2]){
                pointer2++;
            }
        }

        return resultArr;



    }
}
