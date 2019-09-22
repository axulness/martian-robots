package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsGrid;
import com.joaqdelgador.challenge.martianrobots.Robot;

public interface RobotManager {
  Robot create(int x, int y, char orientation) throws Exception;
  Robot advance(Robot robot);
  Robot rotate(Robot robot, char rotation) throws Exception;
  boolean isThereScent(Robot robot, MarsGrid marsGrid);
  boolean willBeLost(Robot robot, MarsGrid marsGrid);
}
