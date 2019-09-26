package martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.domain.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.domain.MarsRobotInstructions;
import com.joaqdelgador.challenge.martianrobots.factory.RobotActionServiceFactory;
import com.joaqdelgador.challenge.martianrobots.service.RobotActionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RobotActionServiceTests {

  private static final int MAX_X = 5;
  private static final int MAX_Y = 3;
  private MarsRobotInstructions[] instructions;
  private RobotActionService robotActionService;

  @Before
  public void before() {
    //initializing testing data
    this.robotActionService = RobotActionServiceFactory.getRobotActionService();
    instructions = new MarsRobotInstructions[]{
        new MarsRobotInstructions(1, 1, 'E', "RFRFRFRF"),
        new MarsRobotInstructions(3, 2, 'N', "FRRFLLFFRRFLL"),
        new MarsRobotInstructions(0, 3, 'W', "LLFFFLFLFL")
    };
  }

  @Test
  public void executeExampleInput() throws Exception {
    //testing expected results

    this.robotActionService.initializeScenario(MAX_X, MAX_Y);

    assertEquals(this.robotActionService.executeScenario(instructions[0]), new MarsRobot(1, 1, 'E', false));
    assertEquals(this.robotActionService.executeScenario(instructions[1]), new MarsRobot(3, 3, 'N', true));
    assertEquals(this.robotActionService.executeScenario(instructions[2]), new MarsRobot(2, 3, 'S', false));
  }
}