package com.joaqdelgador.challenge.martianrobots.domain;

public class MarsRobotInstructions {
  private int startingX;
  private int startingY;
  private char startingOrientation;
  private String instructions;

  public MarsRobotInstructions (int startingX, int startingY, char startingOrientation, String instructions){
    this.startingX = startingX;
    this.startingY = startingY;
    this.startingOrientation = startingOrientation;
    this.instructions = instructions;
  }

  public char getStartingOrientation() {
    return startingOrientation;
  }

  public int getStartingX() {
    return startingX;
  }

  public int getStartingY() {
    return startingY;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public void setStartingOrientation(char startingOrientation) {
    this.startingOrientation = startingOrientation;
  }

  public void setStartingX(int startingX) {
    this.startingX = startingX;
  }

  public void setStartingY(int startingY) {
    this.startingY = startingY;
  }
}
