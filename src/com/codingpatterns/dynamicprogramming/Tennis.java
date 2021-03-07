/**package com.codingpatterns.dynamicprogramming;

public class Tennis {

  import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

  enum ScoreType{
    //create a method to covertScoreToPoints()
    LoveAll,
    FifteenAll,
    ThirtyAll,
    Deuce

  }

  class Tennis {

    //TODO
    //Declare all Strings with global constansts
    private static String player1 = "Player1";


    private int mScore1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    //Convert this to Builder Pattern
    public Tennis(String player1Name, String player2Name) {
      this.player1Name = player1Name;
      this.player2Name = player2Name;
    }

    public void setScore(String playerName, int score) {
      if (playerName == player1)
        mScore1 = score;
      else
        m_score2 = score;
    }
    //Create a Class for FormattedScore
    //The Tennis Class should Just have a FormatMethod which will return the final result
    // Crate a negavtive test cases and then Handle them, And use some custom Exception Handling.
    // Add the Proper Logging.
    public String getFormattedScore() {
      String score = "";
      int tempScore=0;


      if (mScore1==m_score2) {
        //TODO
        //Change Switch case to ENUM
        //OR change it to CommandPattern
        switch (mScore1) {
          case 0:
            score = "Love-All";
            break;
          case 1:
            score = "Fifteen-All";
            break;
          case 2:
            score = "Thirty-All";
            break;
          default:
            score = "Deuce";
            break;
        }
      } else if (mScore1>=4 || m_score2>=4) {
        score = getWinOrAdvantageScore();
      } else {
        //TODO
        //Move this logic to seperate method
        for (int i=1; i<3; i++) {
          if (i==1) tempScore = mScore1;
          else { score+="-"; tempScore = m_score2; }

          switch (tempScore) {
            case 0:
              score+="Love";
              break;
            case 1:
              score+="Fifteen";
              break;
            case 2:
              score+="Thirty";
              break;
            case 3:
              score+="Forty";
              break;
          }
        }
      }

      return score;
    }

    public String getWinOrAdvantageScore(){

      String result = "";

      int minusResultPlayer1 = mScore1-m_score2;
      int minusResultPlayer2 = m_score2-mScore1;

      if (minusResultPlayer1==1) result ="Advantage Player1";
      else if (minusResultPlayer2 == 1) result ="Advantage Player2";
      else if (minusResultPlayer1>=2) result = "Win for Player1";
      else result ="Win for Player2";

      return result;
    }

  }


  /*
   * This code is for running the test cases - it should not be changed
   *//**
  public class Solution {
    private static final String PLAYER_1 = "Player1";
    private static final String PLAYER_2 = "Player2";

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String line = bufferedReader.readLine();
      while (line != null) {
        String[] fields = line.split(",");

        Tennis game = new Tennis(PLAYER_1, PLAYER_2);
        game.setScore(PLAYER_1, Integer.parseInt(fields[0].trim()));
        game.setScore(PLAYER_2, Integer.parseInt(fields[1].trim()));

        String result = game.getFormattedScore();

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        line = bufferedReader.readLine();
      }

      bufferedWriter.close();
    }
  }
 v``   3  3                                         ``

}**/
