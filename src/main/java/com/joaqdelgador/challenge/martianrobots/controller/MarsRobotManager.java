package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.domain.MarsGrid;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;

public class MarsRobotManager implements RobotManager {

  public MarsRobot create(int x, int y, char orientation) throws Exception {
    if (x < 0 || y < 0) {
      throw new IllegalStateException("Starting coordinates can't be negative.");
    } else if (orientation != 'N' && orientation != 'E' && orientation != 'S'
        && orientation != 'W') {
      throw new IllegalStateException("Starting orientation must be 'N', 'E', 'S' or 'W'");
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
        throw new IllegalStateException("Rotation must be 'R' or 'L'");
    }
    return marsRobot;
  }

  public boolean isThereScent(final MarsRobot marsRobot, MarsGrid marsGrid) {
    for (MarsRobot eachScent : marsGrid.getScents())
    {
      if (eachScent.equals(marsRobot)) return true;
    }
    return false;
  }

  public boolean willBeLost(MarsRobot marsRobot, MarsGrid marsGrid) {
    MarsRobot futureMarsRobot = new MarsRobot(marsRobot.getX(), marsRobot.getY(),
        marsRobot.getOrientation(), false);
    futureMarsRobot = advance(futureMarsRobot);
    //any of the movements will imply being out of the grid?
    return (futureMarsRobot.getOrientation() == 'N' && futureMarsRobot.getY() > marsGrid.getY())
        || (futureMarsRobot.getOrientation() == 'E' && futureMarsRobot.getX() > marsGrid.getX())
        || (futureMarsRobot.getOrientation() == 'S' && futureMarsRobot.getY() < 0)
        || (futureMarsRobot.getOrientation() == 'W' && futureMarsRobot.getX() < 0);
  }

  private static char rotateLeft(char initialOrientation) {
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

  private static char rotateRight(char initialOrientation) {
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
