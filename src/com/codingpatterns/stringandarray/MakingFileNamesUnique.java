package com.codingpatterns.stringandarray;

/**
 * Given an array of strings names of size n. You will create n folders in your file system such
 * that, at the ith minute, you will create a folder with the name names[i].
 *
 * <p>Since two files cannot have the same name, if you enter a folder name which is previously
 * used, the system will have a suffix addition to its name in the form of (k), where, k is the
 * smallest positive integer such that the obtained name remains unique.
 *
 * <p>Return an array of strings of length n where ans[i] is the actual name the system will assign
 * to the ith folder when you create it.
 *
 * <p>Example 1:
 *
 * <p>Input: names = ["pes","fifa","gta","pes(2019)"] Output: ["pes","fifa","gta","pes(2019)"]
 * Explanation: Let's see how the file system creates folder names: "pes" --> not assigned before,
 * remains "pes" "fifa" --> not assigned before, remains "fifa" "gta" --> not assigned before,
 * remains "gta" "pes(2019)" --> not assigned before, remains "pes(2019)"
 */
public class MakingFileNamesUnique {


 /** public String[] getFolderNames(String[] names) {
    Map<String, Integer> map = new HashMap<String, Integer>(names.length);
    String[] ans = new String[names.length];
    int i = 0;
    for (String s : names) {
      int cnt = map.getOrDefault(s, 0);
      if (cnt == 0) {
        ans[i++] = s;
        map.put(s, 1);
      } else {
        String tmp = s + "(" + cnt + ")";
        while (map.containsKey(tmp)) {
          tmp = s + "(" + (++cnt) + ")";
        }
        ans[i++] = tmp;
        map.put(tmp, 1);
        map.put(s, cnt + 1);
      }
    }
    return ans;
  }**/
}
