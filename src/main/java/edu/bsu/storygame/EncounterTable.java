package edu.bsu.storygame;

import com.google.common.collect.ImmutableList;
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
        return new Encounter(
                "Wraith",
                "You arrive in an old graveyard. A blanket of dead leaves crunch under your feet, and a chilling wind blows through the night, causing you to shiver. Suddenly, a shrill scream pierces your ears as a thick fog rolls in and blankets the tombstones. You see a ghostly figure draped in a shadowy cloak materialize in front of you, a lantern clutched in its shriveled fingers. A wraith has appeared!\\n",
                Regions.Africa,
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(Skill.LOGIC, "You gather up the courage to ask the creature what it wants. It points a bony finger toward a lonely patch of dirt in the corner of the graveyard, which you assume is its grave. Inspiration strikes, and you run into the forest and pick some flowers. You place them on the soil in order to pay respect to the dead. The creature seems satisfied, and disappears. [GOOD THING HAPPENS]\n"),
                                new SkillTrigger(null, "Your attempts to talk to the wraith fail miserably, but you are determined to continue anyway. As you babble on endlessly, the wraith draws ever closer, and the thick fog starts to surround you. You find yourself unable to move, and the creature traps you in its chilling embrace. You are knocked out. [BAD THING HAPPENS] \n")
                        )),
                        new Reaction("Attack", ImmutableList.of(
                                new SkillTrigger(Skill.MAGIC, "The creature advances toward you, and the fog in the graveyard closes in around you. Your eyes are drawn to the lantern in its hand. You close your eyes and begin to recite an incantation. As you complete the spell, magical energy pours from your hands, and hits the wraith. The lantern falls from its hand and shatters, dousing the creature in eerie blue flames. It emits a piercing cry as the flames engulf its body, and it disappears, leaving you alone in the graveyard. [GOOD THING HAPPENS]\n"),
                                new SkillTrigger(null, "The wraith creeps toward you, its lantern bobbing up and down hypnotically. You find yourself ensnared by the dancing light, but you snap out of your trance in the nick of time. The wraith is inches away, and you swing your fist at the ghostly creature. Your lame punch attack is useless against the monster, and you swear you can hear it laughing at you. The wraith swings its lantern at you, and you scream as you are engulfed in crackling blue flames. You are badly burned, but you manage to escape. [BAD THING HAPPENS]\n")
                        )),
                        new Reaction("Run", ImmutableList.of(
                                new SkillTrigger(null, "The creature’s wails assault your senses, and you decide to get out of there as quickly as possible. As you run away, you see the wraith gliding toward you. It gives chase... but it's incredibly slow. You easily outrun the spectral horror, and leave the graveyard behind.\n")
                        ))
                ),
                new Image("Wraith.jpg"));
    }

    public Encounter cockatriceEncounter() {
        return new Encounter(
                "Cockatrice",
                "You find yourself in a grassy field, with a cloudless blue sky looming overhead. There is a clear lake off in the distance, and sunlight gleams off of the watery surface. Up ahead, you see a hideous creature stomping around the grass. It looks like a small plump dragon, with the head of a rooster. You’ve encountered a cockatrice!\n",
                Regions.Europe,
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(null, "You call out to the creature and attempt to talk to it. It turns to face you, and you find petrified by its gaze. Its beady little rooster eyes gaze into your soul with a burning hatred. You are immediately knocked out, and [BAD THING HAPPENS]\n")
                        )),
                        new Reaction("Attack", ImmutableList.of(
                                new SkillTrigger(Skill.MAGIC, "The cockatrice ambles around in the grass, unaware to your presence. You call forth a bit of magic, and produce a brilliant flash of light. The cockatrice is blinded by the dazzling light, and stumbles around pathetically. Annoyed, it flies away and leaves you alone. [GOOD THING HAPPENS]\n"),
                                new SkillTrigger(null, "You aim to fight the Cockatrice, but you have no weapons or magic skills to speak of. You run up to the monster and karate chop its scaly back with a wicked vertical slice. The creature is hardly fazed by the assault, and turns its head toward you. You are knocked out by its steely gaze. [BAD THING HAPPENS]\n")
                        )),
                        new Reaction("Run", ImmutableList.of(
                                new SkillTrigger(null, "You see the frightening monster off in the distance, and decide that it is better off to leave it alone. You back away slowly making sure not to draw the attention of the beast. You escape the creature unharmed, and live to fight another day. [GOOD THING HAPPENS]\n")
                        ))
                ),
                new Image("Cockatrice.jpg")
        );
    }
}
