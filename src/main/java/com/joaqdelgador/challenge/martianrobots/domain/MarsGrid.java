package com.joaqdelgador.challenge.martianrobots.domain;

import java.util.HashSet;
import java.util.Set;

public class MarsGrid {
  private int x;
  private int y;
  private Set<MarsRobot> scents = new HashSet<MarsRobot>();

  public MarsGrid(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Set<MarsRobot> getScents() {
    return scents;
  }

  public void addScent (MarsRobot robot){
    scents.add(new MarsRobot(robot.getX(), robot.getY(), robot.getOrientation(), false));
  }
}
