package com.joaqdelgador.challenge.martianrobots.factory;

import com.joaqdelgador.challenge.martianrobots.controller.MarsGridManagerImpl;
import com.joaqdelgador.challenge.martianrobots.controller.MarsRobotManager;
import com.joaqdelgador.challenge.martianrobots.service.RobotActionService;
import com.joaqdelgador.challenge.martianrobots.service.RobotActionServiceImpl;

public class RobotActionServiceFactory {

  private static RobotActionService robotActionService;

  private RobotActionServiceFactory() {
  }

  public static RobotActionService getRobotActionService() {
    if (robotActionService == null) {
      robotActionService =
          new RobotActionServiceImpl(
              new MarsGridManagerImpl(),
              new MarsRobotManager());
    }
    return robotActionService;
  }
}
