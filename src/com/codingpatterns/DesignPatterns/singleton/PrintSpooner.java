package com.codingpatterns.DesignPatterns.singleton;

public class PrintSpooner {

  private static PrintSpooner ourInstance = new PrintSpooner();

  public static PrintSpooner getInstance() {
    return ourInstance;
  }

  private PrintSpooner() {
  }
}
