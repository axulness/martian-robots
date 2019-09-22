package com.joaqdelgador.challenge.martianrobots;

public class MarsRobot {
  private int x;
  private int y;
  private char orientation;

  public MarsRobot(int x, int y, char orientation){
    this.x = x;
    this.y = y;
    this.orientation = orientation;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getOrientation() {
    return orientation;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setOrientation(char orientation) {
    this.orientation = orientation;
  }
}
