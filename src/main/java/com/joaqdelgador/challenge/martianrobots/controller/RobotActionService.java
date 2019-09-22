package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.MarsRobotInstructions;

public interface RobotActionService {
  MarsRobot executeScenario(int maximunGridX, int maximunGridY, MarsRobotInstructions...marsRobotInstructions) throws Exception;
}
