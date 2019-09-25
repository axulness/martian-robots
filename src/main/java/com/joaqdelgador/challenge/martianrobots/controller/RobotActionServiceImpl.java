package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.domain.MarsGrid;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotActionServiceImpl implements RobotActionService {

  private MarsGridManager marsGridManager;
  private RobotManager robotManager;

  public RobotActionServiceImpl(MarsGridManager marsGridManager, RobotManager robotManager) {
    this.marsGridManager = marsGridManager;
    this.robotManager = robotManager;
  }

  public List<MarsRobot> executeScenario(int maximunGridX, int maximunGridY,
      MarsRobotInstructions... marsRobotInstructions) throws Exception {
    return executeScenario(maximunGridX, maximunGridY, Arrays.asList(marsRobotInstructions));
  }

  public List<MarsRobot> executeScenario(int maximunGridX, int maximunGridY,
      List<MarsRobotInstructions> marsRobotInstructions) throws Exception {
    MarsGrid mars = marsGridManager.createMarsGrid(maximunGridX, maximunGridY);
    List<MarsRobot> marsRobots = new ArrayList<MarsRobot>();
    for (MarsRobotInstructions eachInstruction : marsRobotInstructions) {
      marsRobots.add(executeInstructions(mars, eachInstruction));
    }
    return marsRobots;
  }

  private MarsRobot executeInstructions(MarsGrid mars, MarsRobotInstructions instructions)
      throws Exception {
    MarsRobot robot = new MarsRobot(instructions.getStartingX(), instructions.getStartingY(),
        instructions.getStartingOrientation(), false);
    for (char isolatedInstruction : instructions.getInstructions().toCharArray()) {
      if (isolatedInstruction == 'F') {
        if (!robotManager.isThereScent(robot, mars)) {
          if (robotManager.willBeLost(robot, mars)) {
            mars.addScent(robot);
            robot.setLost(true);
            break;
          } else {
            robot = robotManager.advance(robot);
          }
        }
      } else {
        robot = robotManager.rotate(robot, isolatedInstruction);
      }
    }
    return robot;
  }
}
