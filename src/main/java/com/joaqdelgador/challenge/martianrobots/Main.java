package com.joaqdelgador.challenge.martianrobots;

import com.joaqdelgador.challenge.martianrobots.controller.RobotActionService;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;
import com.joaqdelgador.challenge.martianrobots.factory.RobotActionServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    RobotActionService robotActionService = RobotActionServiceFactory.getRobotActionService();

    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    List<MarsRobotInstructions> fullSetOfInstructions = new ArrayList<MarsRobotInstructions>();

    while (scanner.hasNextLine()) {
      int roverX = scanner.nextInt();
      int roverY = scanner.nextInt();
      char roverOrientation = scanner.next().charAt(0);
      String instructions = scanner.next();
      fullSetOfInstructions
          .add(new MarsRobotInstructions(roverX, roverY, roverOrientation, instructions));
    }
    List<MarsRobot> marsRobot = robotActionService.executeScenario(x, y, fullSetOfInstructions);

    for (MarsRobot eachRobot : marsRobot) {
      System.out.print(eachRobot.getX());
      System.out.print(' ');
      System.out.print(eachRobot.getY());
      System.out.print(' ');
      System.out.println(eachRobot.getOrientation());
    }
  }
}

