package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsGrid;
import com.joaqdelgador.challenge.martianrobots.MarsRobot;

public interface RobotManager {
  MarsRobot create(int x, int y, char orientation) throws Exception;
  MarsRobot advance(MarsRobot marsRobot);
  MarsRobot rotate(MarsRobot marsRobot, char rotation) throws Exception;
  boolean isThereScent(MarsRobot marsRobot, MarsGrid marsGrid);
  boolean willBeLost(MarsRobot marsRobot, MarsGrid marsGrid);
}
