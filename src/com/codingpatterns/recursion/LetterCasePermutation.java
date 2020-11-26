package com.codingpatterns.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. You can return the output in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 *
 * Input: S = "3z4"
 * Output: ["3z4","3Z4"]
 * Example 3:
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Example 4:
 *
 * Input: S = "0"
 * Output: ["0"]
 *
 *
 * Constraints:
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */

public class LetterCasePermutation {

    public static void main(String[] args) {

        //PostitiveTestCase 1
        String postitiveTestCase = "a1b2";
        List<String> result = LetterCasePermutation.findInputPermutation(postitiveTestCase);
        System.out.println("LetterCasePermutation: " + result.toString());


        //PostitiveTestCase 2
        String postitiveTestCase1 = "3z4";
        List<String> result1 = LetterCasePermutation.findInputPermutation(postitiveTestCase1);
        System.out.println("LetterCasePermutation: " + result1.toString());

        //Only DigitCase
        String onlyDigitCase = "434345";
        List<String> result2 = LetterCasePermutation.findInputPermutation(onlyDigitCase);
        System.out.println("LetterCasePermutation: " + result2.toString());

        //Only DigitCase
        String same = "ABCD";
        List<String> result3 = LetterCasePermutation.findInputPermutation(same);
        System.out.println("LetterCasePermutation: " + result3.toString());

        //Only DigitCase
        String sameLower = "ABCD";
        List<String> result4 = LetterCasePermutation.findInputPermutation(sameLower);
        System.out.println("LetterCasePermutation: " + result4.toString());
    }

    private static List<String> findInputPermutation(String inputString) {

        List<String> result = new  ArrayList<>();

        helper(inputString, 0, "", result);

        return result;
    }

    private static void helper(String inputString, int idx, String soFar, List<String> coll){

        if(idx==inputString.length()){
            coll.add(soFar);
        }else{
            char currChar = inputString.charAt(idx);

            if(Character.isDigit(currChar)){

                helper(inputString, idx+1, soFar+currChar, coll);

            }
            else {
                helper(inputString, idx+1, soFar + Character.toLowerCase(currChar), coll);
                helper(inputString, idx+1, soFar + Character.toUpperCase(currChar), coll);
            }

        }


    }


}
