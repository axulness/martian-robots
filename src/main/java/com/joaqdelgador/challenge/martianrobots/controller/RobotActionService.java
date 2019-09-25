package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;
import java.util.List;

public interface RobotActionService {
  List<MarsRobot> executeScenario(int maximunGridX, int maximunGridY, MarsRobotInstructions...marsRobotInstructions) throws Exception;
  List<MarsRobot> executeScenario(int maximunGridX, int maximunGridY, List<MarsRobotInstructions> marsRobotInstructions) throws Exception;
}
