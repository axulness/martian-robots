package com.joaqdelgador.challenge.martianrobots;

import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;
import com.joaqdelgador.challenge.martianrobots.factory.RobotActionServiceFactory;
import com.joaqdelgador.challenge.martianrobots.service.RobotActionService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        //service initialization
        RobotActionService robotActionService = RobotActionServiceFactory.getRobotActionService();
        //creating scanner to get user input
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        //initialize mar planet
        robotActionService.initializeScenario(x, y);
        do {
            //run every robot input
            int roverX = scanner.nextInt();
            int roverY = scanner.nextInt();
            char roverOrientation = scanner.next().charAt(0);
            String instructions = scanner.next();
            //after gathering the input data we run the scenario
            MarsRobot marsRobot = robotActionService.executeScenario(new MarsRobotInstructions(roverX, roverY, roverOrientation, instructions));

            System.out.print('\n');
            System.out.print(marsRobot.getX());
            System.out.print(' ');
            System.out.print(marsRobot.getY());
            System.out.print(' ');
            System.out.print(marsRobot.getOrientation());
            if (marsRobot.isLost()) {
                System.out.print(' ');
                System.out.print("LOST");
            }
        } while (true);
    }
}

