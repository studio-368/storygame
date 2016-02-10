package edu.bsu.storygame;

import com.google.common.collect.ImmutableList;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static edu.bsu.storygame.Result.noResult;
import static edu.bsu.storygame.Result.storyPoints;

public class EncounterTable {

    private final GameContext context;
    private final List<Encounter> encounters = new ArrayList<>();
    private Random random = new Random();


    public EncounterTable(GameContext context) {
        this.context = context;
        populateEncounters();
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
        return encounters.get(random.nextInt(16))
    }

    private Encounter eastEncounter() {
        return encounters.get(random.nextInt(16) + 16)
    }

    private void populateEncounters(){
        encounters.add(wraithEncounter());
        encounters.add(cockatriceEncounter());
        encounters.add(nessyEncounter());
        Collections.shuffle(encounters);
    }

    public Encounter wraithEncounter() {
        return new Encounter(
                "Wraith",
                "You arrive in an old graveyard. A blanket of dead leaves crunch under your feet, and a chilling wind blows through the night, causing you to shiver. Suddenly, a shrill scream pierces your ears as a thick fog rolls in and blankets the tombstones. You see a ghostly figure draped in a shadowy cloak materialize in front of you, a lantern clutched in its shriveled fingers. A wraith has appeared!\\n",
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(Skill.LOGIC, "You gather up the courage to ask the creature what it wants. It points a bony finger toward a lonely patch of dirt in the corner of the graveyard, which you assume is its grave. Inspiration strikes, and you run into the forest and pick some flowers. You place them on the soil in order to pay respect to the dead. The creature seems satisfied, and disappears.",
                                        storyPoints(1)),
                                new SkillTrigger(null, "Your attempts to talk to the wraith fail miserably, but you are determined to continue anyway. As you babble on endlessly, the wraith draws ever closer, and the thick fog starts to surround you. You find yourself unable to move, and the creature traps you in its chilling embrace. You are knocked out.\n",
                                        storyPoints(-1))
                        )),
                        new Reaction("Attack", ImmutableList.of(
                                new SkillTrigger(Skill.MAGIC, "The creature advances toward you, and the fog in the graveyard closes in around you. Your eyes are drawn to the lantern in its hand. You close your eyes and begin to recite an incantation. As you complete the spell, magical energy pours from your hands, and hits the wraith. The lantern falls from its hand and shatters, dousing the creature in eerie blue flames. It emits a piercing cry as the flames engulf its body, and it disappears, leaving you alone in the graveyard.",
                                        storyPoints(1)),
                                new SkillTrigger(null, "The wraith creeps toward you, its lantern bobbing up and down hypnotically. You find yourself ensnared by the dancing light, but you snap out of your trance in the nick of time. The wraith is inches away, and you swing your fist at the ghostly creature. Your lame punch attack is useless against the monster, and you swear you can hear it laughing at you. The wraith swings its lantern at you, and you scream as you are engulfed in crackling blue flames. You are badly burned, but you manage to escape.",
                                        storyPoints(-1))
                        )),
                        new Reaction("Run", ImmutableList.of(
                                new SkillTrigger(null, "The creature’s wails assault your senses, and you decide to get out of there as quickly as possible. As you run away, you see the wraith gliding toward you. It gives chase... but it's incredibly slow. You easily outrun the spectral horror, and leave the graveyard behind.",
                                        noResult())
                        ))
                ),
                new Image("Wraith.jpg"));
    }

    public Encounter cockatriceEncounter() {
        return new Encounter(
                "Cockatrice",
                "You find yourself in a grassy field, with a cloudless blue sky looming overhead. There is a clear lake off in the distance, and sunlight gleams off of the watery surface. Up ahead, you see a hideous creature stomping around the grass. It looks like a small plump dragon, with the head of a rooster. You’ve encountered a cockatrice!\n",
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(null, "You call out to the creature and attempt to talk to it. It turns to face you, and you find petrified by its gaze. Its beady little rooster eyes gaze into your soul with a burning hatred. You are immediately knocked out.",
                                        storyPoints(-1))
                        )),
                        new Reaction("Attack", ImmutableList.of(
                                new SkillTrigger(Skill.MAGIC, "The cockatrice ambles around in the grass, unaware to your presence. You call forth a bit of magic, and produce a brilliant flash of light. The cockatrice is blinded by the dazzling light, and stumbles around pathetically. Annoyed, it flies away and leaves you alone.",
                                        storyPoints(1)),
                                new SkillTrigger(null, "You aim to fight the Cockatrice, but you have no weapons or magic skills to speak of. You run up to the monster and karate chop its scaly back with a wicked vertical slice. The creature is hardly fazed by the assault, and turns its head toward you. You are knocked out by its steely gaze.",
                                        storyPoints(-1))
                        )),
                        new Reaction("Run", ImmutableList.of(
                                new SkillTrigger(null, "You see the frightening monster off in the distance, and decide that it is better off to leave it alone. You back away slowly making sure not to draw the attention of the beast. You escape the creature unharmed, and live to fight another day.",
                                        noResult())
                        ))
                ),
                new Image("Cockatrice.jpg")
        );
    }

    public Encounter nessyEncounter() {
        return new Encounter(
                "Loch Ness Monster",
                "You arrive at the shore of a vast lake. The water ripples softly in the moonlight. The ripples move closer...closer...a lizard-like face emerges in front of you, followed by an impossibly long neck: The Loch Ness Monster. She watches you closely.\n",
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(Skill.PERSUASION, "“Hi, Nessie,” you whisper. You have the creature’s full attention. “I know you probably don’t mean to cause any trouble, but people around here are getting really scared. They aren’t used to you being so active. Would you be willing to go back underwater?”\n" +
                                        "The monster seems unsure, but she is definitely listening to you.\n" +
                                        "“No one has seen you in two years: everyone thought you were dead. If you hide for a while, again, maybe people will leave you alone. No more cameras or searches. What do you say?”\n" +
                                        "The creature cackles softly like a dolphin and slowly slips back into the water. You hope that Nessie will listen to your advice.\n",
                                        storyPoints(1)),
                                new SkillTrigger(null, "“Hey, I’m sorry to bother you,” you say, bravely, “but you’ve been really scaring the people around here. Do you think--”\n" +
                                        "The creature brings her face down to your level and releases a mighty roar that blows you away. You land unharmed in a tree, and run as far away from the lake as you can.",
                                        storyPoints(-1)))),
                        new Reaction("Run", ImmutableList.of(
                                new SkillTrigger(Skill.LOGIC, "Even though Nessie is a lake monster, you’ve read reports of her running on land. You decide that the best way to get away from the creature is to make yourself look as nonthreatening as possible: you turn your back to her and walk as slowly as you possibly can. You can feel the monster’s eyes watching you, but she eventually loses interest, and you get away safely.",
                                        storyPoints(1)),
                                new SkillTrigger(null, "Even though Nessie is a lake monster, you’ve read reports of her running on land. You decide that the best way to get away from the creature is to make yourself look as nonthreatening as possible: you turn your back to her and walk as slowly as you possibly can. You can feel the monster’s eyes watching you, but she eventually loses interest, and you get away safely. ",
                                        storyPoints(-1)))),
                        new Reaction("Fight", ImmutableList.of(
                                new SkillTrigger(null, "You never back-down from a challenge: you race right up to the monster and try to punch her in the throat. She is too fast for you, though: she ducks back into the water, causing you to accidentally fly over her and fall into the water. You struggle to the surface and feel teeth clamp onto your clothes. The monster pulls you out of the water and shakes you back and forth until you fly out of her mouth and into some nearby trees. You are uninjured, but a little dizzy.",
                                        storyPoints(-1)),
                                new SkillTrigger(Skill.MAGIC, "You mutter an incantation: three spheres of light appear and swirl around the monster’s head, scaring and confusing her. The lights chase Nessie across the lake, down into the water, where you hope she will escape through the large crevice you’ve heard about at the bottom of the lake. Now maybe she’ll stop terrorizing people’s nightmares.",
                                        storyPoints(1)),
                                new SkillTrigger(Skill.WEAPON_USE, "You pull out your sword and charge the monster. She lets out a mighty roar that sweeps you off your feet, so you stab your sword into the ground and hold on tight. Nessie stops roaring, but surprises you by crawling out of the water. You pull your sword out of the ground and wait for the right moment to strike. The monster races toward you: at the last second, you hold out your sword and slice at her chest. The monster screeches in pain and stumbles into some nearby trees, knocking them down. Before you attack again, she manages to get up and sprint back into the water, where she disappears.",
                                        storyPoints(1))))),
                new Image("Kraken.jpg")
        );
    }
}
