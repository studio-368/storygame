package edu.bsu.storygame;

public class WraithEncounter {

    private GameContext context;

    public WraithEncounter(GameContext context) {
        this.context = context;
    }

    public void show() {
        EncounterView view = new EncounterView();
        view.setRegion(context.getCurrentPlayer().getRegion());
        view.setMonsterName("a wraith");
        configureChoices(view);
        view.show();
    }

    private void configureChoices(EncounterView view) {
        view.addChoice("Avoid");
        view.addChoice("Question");
        view.addChoice("Attack");
        view.addChoice("Appeal");
    }
}
