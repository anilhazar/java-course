public final class ScoreCalculator {

    private ScoreCalculator() {
        throw new IllegalStateException("Utility class");
    }

    public static double calculateScore(int weight, double rapidity) {
        return weight * rapidity;
    }

}
