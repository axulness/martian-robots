package com.joaqdelgador.challenge.martianrobots;

import com.joaqdelgador.challenge.martianrobots.controller.RobotActionService;

public class RobotActionServiceFactory {

  private static RobotActionService robotActionService;

  private RobotActionServiceFactory() {
  }

  public static RobotActionService getRobotActionService(){
    return robotActionService;
  }
}
