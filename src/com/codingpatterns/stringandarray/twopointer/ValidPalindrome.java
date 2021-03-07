package com.codingpatterns.stringandarray.twopointer;

public class ValidPalindrome {

  public static boolean isPalindrome(String input) {

    if(null == input) return false;

    if(input.length() == 1) return true;

    String s = input.toLowerCase().replaceAll("\\s", "");

    int i = 0;
    int j = s.length() - 1;

    while(i<j){

       if(!Character.isLetterOrDigit(s.charAt(i))){
        i++;
      }

      if(!Character.isLetter(s.charAt(j))){
        j--;
      }

      if(s.charAt(i) != s.charAt(j)){
        return false;
      }

      i++;
      j--;
    }

    return true;

  }

  public static void main(String[] args){

    System.out.println(isPalindrome("Flee to me, remote elf!"));
  }




}
