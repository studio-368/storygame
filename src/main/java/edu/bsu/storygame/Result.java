package edu.bsu.storygame;

public class Result {
    private int storyPointsDelta;

    private Result(int storyPointsToRemove) {
        this.storyPointsDelta = storyPointsToRemove;
    }

    public static Result storyPoints(int change) {
        return new Result(change);
    }

    public static Result noResult() {
        return new Result(0);
    }

    public void doResult(GameContext context) {
        Player currentPlayer = context.players.get(0);
        currentPlayer.totalPoints.update(currentPlayer.totalPoints.get() + storyPointsDelta);
    }

}
