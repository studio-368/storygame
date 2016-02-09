package edu.bsu.storygame;

import javafx.scene.image.Image;

public class EncounterTable {

    private final GameContext context;

    public EncounterTable(GameContext context) {
        this.context = context;
    }

    public Encounter createEncounter() {
        if (currentRegionIsWest()) {
            return westEncounter();
        }
        return eastEncounter();
    }

    private boolean currentRegionIsWest() {
        return context.players.get(0).getRegion() == Regions.Europe;
    }

    private Encounter westEncounter() {
        return wraithEncounter();
    }

    private Encounter eastEncounter() {
        return cockatriceEncounter();
    }

    public Encounter wraithEncounter() {
        Reaction[] reactions = {
                new Reaction("Talk"),
                new Reaction("Attack"),
                new Reaction("Run")
        };
        return new Encounter(
                "Wraith",
                "You arrive in an old graveyard. A blanket of dead leaves crunch under your feet, and a chilling wind blows through the night, causing you to shiver. Suddenly, a shrill scream pierces your ears as a thick fog rolls in and blankets the tombstones. You see a ghostly figure draped in a shadowy cloak materialize in front of you, a lantern clutched in its shriveled fingers. A wraith has appeared!\\n",
                Regions.Africa,
                reactions,
                new Image("Wraith.jpg"));
    }

    public Encounter cockatriceEncounter() {
        Reaction[] reactions = {
                new Reaction("Talk"),
                new Reaction("Attack"),
                new Reaction("Run")
        };
        return new Encounter(
                "Cockatrice",
                "You find yourself in a grassy field, with a cloudless blue sky looming overhead. There is a clear lake off in the distance, and sunlight gleams off of the watery surface. Up ahead, you see a hideous creature stomping around the grass. It looks like a small plump dragon, with the head of a rooster. You’ve encountered a cockatrice!\n",
                Regions.Europe,
                reactions,
                new Image("Cockatrice.jpg")
        );
    }
}
