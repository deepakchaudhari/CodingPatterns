package com.codingpatterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindTheExpression {

    public static void main (String [] args){

        String s = "1234";
        long target = 11;

        generate_all_expressions(s,target);

    }

    /*
     * Complete the function below.
     */
    static String[] generate_all_expressions(String s, long target) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res.toArray(new String[0]);
        char[] path = new char[s.length() * 2];
        char[] digits = s.toCharArray();

        long n = 0;
        for(int i = 0; i < digits.length; i++){
            n = n * 10 + (digits[i]-'0');
            path[i] = digits[i];
            expressionsHelper(res, path, digits, i+1, i+1, 0, n, target);
        }
        return res.toArray(new String[0]);
    }

    public static void expressionsHelper(List<String> res, char[] path, char[] digits, int length, int pos, long prev, long cur, long target){
        if(pos == digits.length){
            if(prev+cur == target){
                res.add(new String(path, 0, length));
            }
        }else{
            long n = 0;
            int j = length+1;
            for(int i = pos; i < digits.length; i++){
                n = n * 10 + (digits[i]-'0');
                path[j++] = digits[i];
                path[length] = '*';
                expressionsHelper(res, path, digits, j, i+1, prev, cur*n, target);
                path[length] = '+';
                expressionsHelper(res, path, digits, j, i+1, prev+cur, n, target);
            }
        }
    }






}
