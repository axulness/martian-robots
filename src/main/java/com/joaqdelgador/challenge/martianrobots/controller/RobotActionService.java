package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.MarsRobotInstructions;
import java.util.List;

public interface RobotActionService {
  List<MarsRobot> executeScenario(int maximunGridX, int maximunGridY, MarsRobotInstructions...marsRobotInstructions) throws Exception;
  List<MarsRobot> executeScenario(int maximunGridX, int maximunGridY, List<MarsRobotInstructions> marsRobotInstructions) throws Exception;
}
