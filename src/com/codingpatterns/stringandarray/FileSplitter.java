package com.codingpatterns.stringandarray;

/*
Given the following log file structure:

2020-09-29T01:59:14.214Z key5=15,key4=11,apple=1
2020-09-29T02:00:31.011Z key3=22,key4=33,key5=16,apple=2

Sum the values by key. So the expected result is:

apple=3
key3=22
key4=44
key5=31
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class FileSplitter {

  public static void main(String[] args) {
    List<String> inputLines = new ArrayList<String>();

    // Postive Test

    inputLines.add("2020-09-29T01:59:14.214Z key5=15,key4=11,apple=1");
    inputLines.add("2020-09-29T02:00:31.011Z key3=22,key4=33,key5=16,apple=2");

    System.out.println(getTheSum(inputLines));
  }

  private static Map<String, Integer> getTheSum(List<String> inputLines) {

    Map<String, Integer> keyValueMap = new HashMap<>();

    if (null == inputLines && inputLines.size() == 0) return keyValueMap;

    // Remove the date from log file

    List<String> keyValueListPerLine = new ArrayList<>();

    for (String inputLine : inputLines) {
      keyValueListPerLine.add(splitTheString(inputLine, " ")[1]);
    }

    List<String> keyValueList = new ArrayList<>();

    for (String inputLine : keyValueListPerLine) {
      List<String> keyValue = Arrays.asList(splitTheString(inputLine, ","));
      for (String input : keyValue) {
        keyValueList.add(input);
      }
    }

    for (String keyValue : keyValueList) {
      String key = splitTheString(keyValue, "=")[0];
      Integer value = Integer.parseInt(splitTheString(keyValue, "=")[1]);
      keyValueMap.put(key, keyValueMap.getOrDefault(key,0) + value);
     }

    return keyValueMap;
  }

  private static String[] splitTheString(String inputString, String splitter) {

    return inputString.split(splitter);
  }
}
