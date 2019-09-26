package com.joaqdelgador.challenge.martianrobots.service;

import com.joaqdelgador.challenge.martianrobots.controller.MarsGridManager;
import com.joaqdelgador.challenge.martianrobots.controller.RobotManager;
import com.joaqdelgador.challenge.martianrobots.domain.MarsGrid;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;

public class RobotActionServiceImpl implements RobotActionService {

  private MarsGridManager marsGridManager;
  private RobotManager robotManager;
  private MarsGrid mars;

  public RobotActionServiceImpl(MarsGridManager marsGridManager, RobotManager robotManager) {
    this.marsGridManager = marsGridManager;
    this.robotManager = robotManager;
  }

  public void initializeScenario(int maximunGridX, int maximunGridY) throws Exception{
    if (isThisCoordinateOversized(maximunGridX) || isThisCoordinateOversized(maximunGridY)) {
      throw new Exception("Maximun size for any coordinate is 50");
    }
    mars = marsGridManager.createMarsGrid(maximunGridX, maximunGridY);
  }

  public MarsRobot executeScenario(MarsRobotInstructions marsRobotInstructions) throws Exception {
    //checking for planet grid initialization first
    if (mars == null) {
      throw new Exception("MarsGrid has not been initialized yet");
    }
    //checking input format
    if (isThisCoordinateOversized(marsRobotInstructions.getStartingX()) || isThisCoordinateOversized(marsRobotInstructions.getStartingY())) {
      throw new Exception("Maximun size for any coordinate is 50");
    }
    if (isThisSecuenceOversized(marsRobotInstructions.getInstructions())){
      throw new Exception("Maximun number of instructions is 100");
    }
    //executing instructions
    return executeInstructions(mars, marsRobotInstructions);
  }

  private MarsRobot executeInstructions(MarsGrid mars, MarsRobotInstructions instructions)
      throws Exception {
    //creating robot in its original state
    MarsRobot robot = new MarsRobot(instructions.getStartingX(), instructions.getStartingY(),
        instructions.getStartingOrientation(), false);
    //removing any non-breaking space characters
    String movements = instructions.getInstructions().replace("\u00A0", "");
    //running instructions (movements and rotation commands) over the original state
    for (char isolatedInstruction : movements.toCharArray()) {
      //checking for a foward instruction
      if (isolatedInstruction == 'F') {
        //was any previous robot lost advancing from this state?
        if (!robotManager.isThereScent(robot, mars)) {
          //is the robot falling down?
          if (robotManager.willBeLost(robot, mars)) {
            //add scent for future robots
            mars.addScent(robot);
            //changing robot state
            robot.setLost(true);
            break;
          } else {
            //advancement is possible so we proceed
            robot = robotManager.advance(robot);
          }
        }
      } else {
        //we try to run a rotation
        robot = robotManager.rotate(robot, isolatedInstruction);
      }
    }
    return robot;
  }

  private boolean isThisCoordinateOversized(int coordinate){
    return coordinate > 50;
  }

  private boolean isThisSecuenceOversized(String instructions){
    return instructions.length() > 100;
  }
}
