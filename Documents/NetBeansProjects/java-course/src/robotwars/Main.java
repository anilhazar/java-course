import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RobotA robotA = new RobotA();
//        double robotAScore = robotA.getScore();
        RobotB robotB = new RobotB();
//        double robotBScore = robotB.getScore();

        Map<Double, String> scoresOfRobots = new HashMap<>();

        scoresOfRobots.put(robotA.getScore(), robotA.getName());
        scoresOfRobots.put(robotB.getScore(), robotB.getName());

        Double maxScore = Collections.max(scoresOfRobots.keySet());

        String robotNameOfWinner = scoresOfRobots.get(maxScore);

        System.out.println("The Winner is " + robotNameOfWinner + " !!!");

    }
}