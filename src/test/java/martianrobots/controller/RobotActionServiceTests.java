package martianrobots.controller;

import static org.junit.Assert.assertEquals;

import com.joaqdelgador.challenge.martianrobots.MarsRobot;
import com.joaqdelgador.challenge.martianrobots.MarsRobotInstructions;
import com.joaqdelgador.challenge.martianrobots.RobotActionServiceFactory;
import com.joaqdelgador.challenge.martianrobots.controller.RobotActionService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RobotActionServiceTests {

  private static final int MAX_X = 5;
  private static final int MAX_Y = 3;
  private MarsRobotInstructions[] instructions;
  private RobotActionService robotActionService;

  @Before
  public void before() {
    this.robotActionService = RobotActionServiceFactory.getRobotActionService();
    instructions = new MarsRobotInstructions[]{
        new MarsRobotInstructions(1, 1, 'E', "RFRFRFRF"),
        new MarsRobotInstructions(3, 2, 'N', "FRRFLLFFRRFLL"),
        new MarsRobotInstructions(0, 3, 'W', "LLFFFLFLFL")
    };
  }

  @Test
  public void executeExampleInput() throws Exception {

    List<MarsRobot> solution = this.robotActionService.executeScenario(MAX_X, MAX_Y, instructions);

    assertEquals(solution.get(0), new MarsRobot(1, 1, 'E', false));
    assertEquals(solution.get(1), new MarsRobot(3, 3, 'N', true));
    assertEquals(solution.get(2), new MarsRobot(2, 3, 'S', false));
  }
}