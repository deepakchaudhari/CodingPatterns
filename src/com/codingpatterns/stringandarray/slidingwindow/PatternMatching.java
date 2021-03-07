package com.codingpatterns.stringandarray.slidingwindow;

public class PatternMatching {




static   int binaryPatternMatching(String pattern, String s) {

    if(s == null || s.length() ==0 || s.length()< pattern.length()){
      return 0;
    }

    char [] stringArray = s.toCharArray();
    char [] patternArray = s.toCharArray();

    int patternMatchingCount =0;

    int windowStart =0;

    for(int i=0; i <= (s.length())-(pattern.length()); i++){

      for(int j= i; j<i + pattern.length()-1; j++){
        String newString = s.substring(j, j+pattern.length());
        if(patternMatch(pattern, newString)){
          patternMatchingCount ++;
        }
      }

    }

    return patternMatchingCount;
    //for(int windowEnd =0; windowEnd < pattern.length(); windowEnd ++ ){



  }


  static boolean patternMatch(String pattern, String newString){
    boolean state = true;
    for(int i=0; i<=newString.length()-1; i++){
      if(pattern.charAt(i) == '1'){
        state = isThisConsonant(newString.charAt(i));
        if(state == false){
          return false;
        }
      }
      if(pattern.charAt(i) == '0'){
        state = !isThisConsonant(newString.charAt(i));
        if(state == false){
          return false;
        }
      }
    }
    return state;

  }

  static boolean isThisConsonant(char ch){

    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y'){
      return false;
    }
    return true;
  }



  public static void main(String[] args) {

    System.out.println("Smallest subarray length: " + binaryPatternMatching("010", "anagram"));

  }




}
