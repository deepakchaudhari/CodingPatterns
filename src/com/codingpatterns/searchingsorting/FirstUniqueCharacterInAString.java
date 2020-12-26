package com.codingpatterns.searchingsorting;
import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharacterInAString {

  public static void main (String[] args){
    String s = "loveleetcode";

    System.out.println(firstUniqChar(s));
  }


  private static int firstUniqChar(String s) {

    if(s.length()==0) return -1;

    Map<Character, Integer> map = new HashMap<Character, Integer>();

    char[] inputArr = s.toCharArray();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      map.put(inputArr[i], map.getOrDefault(c,0)+1);
    }

    for(int i=0;i<s.length();i++){
      if(map.get(s.charAt(i)) == 1){
        return i;
      }
    }

    return -1;

  }

}
