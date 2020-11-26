package com.codingpatterns.string;

public class ReverseString {


    public static void main (String args[]){


        String inputString = "My Dog ran";
        StringBuilder test = new StringBuilder(inputString);
        test.reverse();
        System.out.println(test);

    }

}
