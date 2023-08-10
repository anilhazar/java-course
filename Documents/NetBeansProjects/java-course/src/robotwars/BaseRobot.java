public abstract class BaseRobot implements Robot {

    protected int weight;
    protected double rapidity;
    protected double score;
    protected String name;

    public double getScore() {
        return weight * rapidity;
    }

}

