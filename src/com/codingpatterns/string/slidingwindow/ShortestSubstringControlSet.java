package com.codingpatterns.string.slidingwindow;


/**
 * Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .
 *
 * Examples:
 *
 * Input: aabcbcdbca
 * Output: dbca
 * Explanation:
 * Possible substrings= {aabcbcd, abcbcd,
 * bcdbca, dbca....}
 * Of the set of possible substrings 'dbca'
 * is the shortest substring having all the
 * distinct characters of given string.
 *
 * Input: aaab
 * Output: ab
 * Explanation:
 * Possible substrings={aaab, aab, ab}
 * Of the set of possible substrings 'ab'
 * is the shortest substring having all
 * the distinct characters of given string.
 */




public class ShortestSubstringControlSet {

    public static void main(String [] args){

        String inputString = "this is a test string";
        String pattern = "tist";

        System.out.println(findShortestSubstringControlSet(inputString,pattern));


    }
    /*
     * Complete the 'minimum_window' function below.
     *
     * The function accepts STRING s and STRING t as parameter.
     */

    public static String findShortestSubstringControlSet(String inputString, String subString) {

        int[] inputStringFreq = new int[128];
        int[] subStringFreq = new int[128];

        for(int i =0;i<subString.length();i++)
        {
            subStringFreq[subString.charAt(i)]++;
        }

        int windowStart =0;
        int windowEnd = 0;
        int count =0;
        int len = subString.length();
        int currLen=0;
        int minLen= Integer.MAX_VALUE;
        String result = "";

        while (windowEnd<inputString.length())
        {
            char ch = inputString.charAt(windowEnd);
            inputStringFreq[ch]++;

            if(subStringFreq[ch]!=0 && inputStringFreq[ch]<=subStringFreq[ch])
            {
                count++;
            }

            while(count==len)
            {
                currLen = windowEnd-windowStart+1;
                if (currLen< minLen)
                {
                    minLen=currLen;
                    result = inputString.substring(windowStart,windowEnd+1);
                }
                char c  = inputString.charAt(windowStart);
                inputStringFreq[c]--;
                if (subStringFreq[c]!=0 && inputStringFreq[c]<subStringFreq[c])
                {
                    count--;
                }
                windowStart++;
            }
            windowEnd++;
        }
        if (result.length()==0)
        {
            return "-1";
        }
        return result;
    }
    
    
    
}
