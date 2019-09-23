package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsGrid;

public class MarsGridManagerImpl implements MarsGridManager {

  public MarsGrid createMarsGrid(int x, int y) throws Exception {
    if (x < 0 || y < 0) {
      throw new IllegalStateException("Plateau's coordinates can't be negative.");
    }
    return new MarsGrid(x, y);
  }
}
