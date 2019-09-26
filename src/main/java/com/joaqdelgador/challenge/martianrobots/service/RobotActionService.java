package com.joaqdelgador.challenge.martianrobots.service;

import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;

public interface RobotActionService {
  void initializeScenario(int maximunGridX, int maximunGridY) throws Exception;
  MarsRobot executeScenario(MarsRobotInstructions marsRobotInstructions) throws Exception;
}
