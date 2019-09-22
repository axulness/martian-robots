package com.joaqdelgador.challenge.martianrobots;

import java.util.HashSet;
import java.util.Set;

public class MarsGrid {
  private int x;
  private int y;
  private Set<Scents> scents = new HashSet<Scents>();

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

  public Set<Scents> getScents() {
    return scents;
  }

  public void addScent (int x, int y){
    scents.add(new Scents(x,y));
  }
}
