package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsGrid;
import com.joaqdelgador.challenge.martianrobots.MarsRobot;

public class MarsRobotManager implements RobotManager{

  public MarsRobot create(int x, int y, char orientation) throws Exception {
    if (x < 0 || y < 0) {
      throw new IllegalStateException ("Starting coordinates can't be negative.");
    } else if (orientation != 'N' && orientation != 'E' && orientation != 'S' && orientation != 'W') {
      throw new IllegalStateException ("Starting orientation must be 'N', 'E', 'S' or 'W'");
    }
    return new MarsRobot(x, y, orientation, false);
  }

  public MarsRobot advance(MarsRobot marsRobot) {
    switch (marsRobot.getOrientation()) {
      case 'N':
        marsRobot.setY(marsRobot.getY() + 1);
        break;
      case 'E':
        marsRobot.setX(marsRobot.getX() + 1);
        break;
      case 'S':
        marsRobot.setY(marsRobot.getY() - 1);
        break;
      case 'W':
        marsRobot.setX(marsRobot.getX() - 1);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + marsRobot.getOrientation());
    }
    return marsRobot;
  }

  public MarsRobot rotate(MarsRobot marsRobot, char rotation) throws Exception {
    switch (rotation) {
      case 'L':
        marsRobot.setOrientation(rotateLeft(marsRobot.getOrientation()));
        break;
      case 'R':
        marsRobot.setOrientation(rotateRight(marsRobot.getOrientation()));
        break;
      default:
        throw new IllegalStateException ("Rotation must be 'R' or 'L'");
    }
    return marsRobot;
  }

  public boolean isThereScent(MarsRobot marsRobot, MarsGrid marsGrid) {
    return false;
  }

  public boolean willBeLost(MarsRobot marsRobot, MarsGrid marsGrid) {
    return false;
  }

  private static char rotateLeft (char initialOrientation) {
    switch (initialOrientation) {
      case 'N':
        return 'W';
      case 'W':
        return 'S';
      case 'S':
        return 'E';
      default:
        return 'N';
    }
  }

  private static char rotateRight (char initialOrientation) {
    switch (initialOrientation) {
      case 'N':
        return 'E';
      case 'E':
        return 'S';
      case 'S':
        return 'W';
      default:
        return 'N';
    }
  }
}