package com.joaqdelgador.challenge.martianrobots;

public class MarsRobot {
  private int x;
  private int y;
  private char orientation;
  private boolean lost;

  public MarsRobot(int x, int y, char orientation, boolean lost){
    this.x = x;
    this.y = y;
    this.orientation = orientation;
    this.lost = lost;
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

  public boolean isLost() {
    return lost;
  }

  public void setLost(boolean lost) {
    this.lost = lost;
  }
}
