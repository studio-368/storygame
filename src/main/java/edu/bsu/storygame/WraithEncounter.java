package edu.bsu.storygame;

import edu.bsu.storygame.views.EncounterView;

public class WraithEncounter {

    private GameContext context;

    public WraithEncounter(GameContext context) {
        this.context = context;
    }

    public void show() {
        EncounterView view = new EncounterView();
        view.setRegion(Regions.Africa);
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
