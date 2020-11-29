package com.codingpatterns.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParatheses {


    public static void main (String args[]){
        int inputValue = 3;

        List<String> values = generateParan(inputValue);

        for(String value: values){
            System.out.println(value);
        }
    }

    private static List<String> generateParan(int inputValue) {
        char[] str = new char[inputValue*2];
        List<String> list = new ArrayList<String>();
        addPattern(inputValue,inputValue, str, list,0);
        return list;

    }


    private static void addPattern(int openCount, int closeCount,char[] str, List<String> result, int index){

        if(closeCount>openCount){
            return;
        }

        if(openCount ==0 && closeCount== 0){
            result.add(String.copyValueOf(str));
        }else {


            if (openCount > 0) {
                str[index] = '}';
                addPattern(openCount - 1, closeCount,str, result, index+1);
            }

            if (closeCount > 0) {
                str[index] = '{';
                addPattern(openCount, closeCount-1,str, result, index+1);
            }
        }

    }
}
