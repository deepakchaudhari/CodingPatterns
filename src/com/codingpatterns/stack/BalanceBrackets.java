package com.codingpatterns.stack;

import java.util.*;



class BalanceBrackets {


  /**boolean isBalanced(String s) {

    char [] inputChar = s.toCharArray();
    Deque<Character> dequeAsStack = new ArrayDeque<Character>();

    for(int i=0; i<inputChar.length; i++){
      if(inputChar[i] == '{' || inputChar[i] == '(' || inputChar[i] == '['){
        dequeAsStack.push(inputChar[i]);
      }

      if(inputChar[i] == '}' || inputChar[i] == ')' || inputChar[i] == ']'){
        char c = dequeAsStack.pop();
        if( inputChar[i] == '{' || inputChar[i] == '(' || inputChar[i] == '[' ){
          return false;
        }
      }

    }

    return true;

  }**/


  static final List<Character>
      OPENING = Arrays.asList( '{', '[', '(' ),
      CLOSING = Arrays.asList( '}', ']', ')' );

  static final int NOT_FOUND = -1;

  static boolean isBalanced(String s)
  {
    Deque<Character> brackets = new ArrayDeque<>();
    for ( int i=0; i<s.length(); i++ )
    {
      Character ch = s.charAt(i);
      int pos = CLOSING.indexOf(ch);
      if ( pos != NOT_FOUND ) {
        if ( !OPENING.get(pos).equals( brackets.poll() ) )
          return false;
      } else
        brackets.push( ch );
    }
    return brackets.isEmpty() ? true : false;
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected);
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[" + str + "]");
  }

  public void run() {
    String s_1 = "{[(])}";
    boolean expected_1 = false;
    boolean output_1 = isBalanced(s_1);
    check(expected_1, output_1);

    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = isBalanced(s_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new BalanceBrackets().run();
  }
}
