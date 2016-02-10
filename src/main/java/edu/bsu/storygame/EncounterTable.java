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
    private final List<Encounter> westEncounters = new ArrayList<>();
    private final List<Encounter> eastEncounters = new ArrayList<>();
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
        return westEncounters.get(random.nextInt(westEncounters.size()));
    }

    private Encounter eastEncounter() {
        return eastEncounters.get(random.nextInt(eastEncounters.size()));
    }

    private void populateEncounters() {
        westEncounters.add(wraithEncounter());
        westEncounters.add(cockatriceEncounter());
        westEncounters.add(nessyEncounter());
        Collections.shuffle(westEncounters);
        eastEncounters.add(kappaEncounter());
        eastEncounters.add(bunyipEncounter());
        eastEncounters.add(krakenEncounter());
        Collections.shuffle(eastEncounters);
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
                new Image("Nessy.jpg")
        );
    }

    public Encounter kappaEncounter() {
        return new Encounter(
                "Kappa",
                "You’ve been watching the river for hours looking for the monster that has been attacking nearby villagers but have found nothing. You decide to escape the heat of the day by going for a swim in a river. When you take a step into the cool waters you notice a large turtle shell swimming your way. You feel uneasy: turtles that large only live in the ocean. It swims quickly towards you and leaps from the water. You realize it’s not a turtle, but a Kappa.\n",
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(Skill.LOGIC, "Having been in Japan for a little while you’ve picked up on their customs. Bowing is very important so you give the kappa a deep bow to show that you mean it no harm. In return it bows revealing a water-filled dip in its head. As it bows the water empties and the kappa loses its strength and falls to the ground. It crawls back into the water and swims away.",
                                        storyPoints(1)),
                                new SkillTrigger(null, "The kappa stares at you, licking its lips hungrily. Your gut tells you to run before the kappa decides how it wants to eat you",
                                        storyPoints(0)))),
                        new Reaction("Attack", ImmutableList.of(
                                new SkillTrigger(Skill.MAGIC, "You know some kappas are nice but this one looks ready to attack. You flee from the water. Once clear you cast a lightning spell at the kappa. It screams and falls stunned into the water. ",
                                        storyPoints(1)),
                                new SkillTrigger(null, "You’re not about to run from this creature. You know how they like to drown animals and people alike but you’re not going to let it scare you. You lunge at it ready to fight, but the kappa surprises you. It pulls you into the river and you realize you’ve made a mistake. It’s a tough battle but you manage to escape the monster before it can drown you.",
                                        storyPoints(-1)))),
                        new Reaction("RUN", ImmutableList.of(
                                new SkillTrigger(null, "You know the tales of how the kappa drowns and feeds on people. The river is the kappa’s territory and you’re not about to face a monster without an advantage. You decide it’s best to run and get away before it can make you its next meal. ",
                                        storyPoints(-1))))),
                new Image("Kappa.jpg")
        );
    }

    public Encounter bunyipEncounter() {
        return new Encounter(
                "Bunyip",
                "You find yourself lost in the murky waters of a swamp. The sun is getting low and you’re far from escaping the swamp. You hear a frightening howl behind you. You turn to see a pair of black eyes swimming towards you. They’re attached to a massive dog-like creature with webbed feet. You’ve encountered a bunyip.\n",
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(null, "The bunyip has no interest in talking and lunges forward interrupting you. Its mouth opens wide showing its pointed teeth and hitting you with its breath that smells worse than the swamp you’re lost in. You’re paralyzed with fear and can’t make your body move.",
                                        storyPoints(-1)))),
                        new Reaction("Attack", ImmutableList.of(
                                new SkillTrigger(Skill.WEAPON_USE, "The beast is large but you came prepared. You draw your sword as the bunyip launches itself at you. You dodge to the side and cut into the beast’s side. It gives off a howl of pain and flees back to the waters.",
                                        storyPoints(1)),
                                new SkillTrigger(null, "You didn’t come with any weapons and you don’t think you can outrun the bunyip so you decide to take a stand. The large dog-like monster circles around you, never moving its eyes off you. You find a heavy branch at your feet and carefully reach down keeping the beast in front of you. When you have the branch it leaps for you and you strike it in the head. The branch breaks but it’s enough to scare the Bunyip back into the waters.",
                                        storyPoints(1)))),
                        new Reaction("RUN", ImmutableList.of(
                                new SkillTrigger(null, "There’s no way you’re staying in the swamp another second longer than you need to with monsters like the bunyip prowling the waters. You turn and run faster than you ever have. Heavy footsteps can be heard behind you but they begin to sound further and further away until you no longer hear them at all.",
                                        storyPoints(0))))),
                new Image("Bunyip.jpg")
        );
    }

    public Encounter krakenEncounter() {
        return new Encounter(
                "Kraken",
                "The crowded beach is in chaos as people panic and run out of the deep blue water. In the ocean, giant tentacles flail and grab at everything within reach. You can’t see the creature’s face, but everyone around you is yelling, “Kraken!”\n",
                ImmutableList.of(
                        new Reaction("Talk", ImmutableList.of(
                                new SkillTrigger(Skill.PERSUASION, "You’re sure the monster can be reasoned with, if you can only get its attention. You bravely march right up to one of the tentacles and try to stay calm as it wraps around you and lifts you high into the air. You watch as it’s giant octopus-like head emerges from the water, and its massive eyes turn toward you.\n" +
                                        "“Oh mighty beast,” you shout, “I know that you are hungry. But there are no fish here, and humans taste awful. Please, hunt for your food somewhere else. There is nothing here worthy of you.”\n" +
                                        "The creature seems to enjoy your compliment. It slowly lowers its tentacles and releases everyone it had trapped. It slinks back into the water, and vanishes.\n",
                                        storyPoints(1)),
                                new SkillTrigger(null, "You attempt to get close enough to talk to the creature, but it can’t hear you over all of the screams and commotion. After waving your arms frantically in an attempt to get the monster’s attention, you finally give up and go home.\n",
                                        storyPoints(-1)))),
                        new Reaction("Run", ImmutableList.of(
                                new SkillTrigger(Skill.LOGIC, "You attempt to run back up the beach, but the creature’s massive head bursts from the water and sees you. It swings a tentacle at you, but you roll out of the way just in time. It continues to try and grab you and you keep dodging its attacks, but you are getting tired. You notice a lighthouse further along on the beach, on top of some very sharp rocks. You sprint there as fast as you can, wait for the monster to strike, and dive out of the way at the last second. The lighthouse and rocks slice straight through the kraken’s tentacle, making it screech in pain and drop everything it was holding. You watch it dive back into the water and swim away, never to return.\n",
                                        storyPoints(1)),
                                new SkillTrigger(null, "You attempt to run back up the beach, but the creature’s massive head bursts from the water and sees you. It grabs you with a tentacle and pulls you up high into the air. It holds you there until help finally arrives a few hours later.\n",
                                        storyPoints(0)))),
                        new Reaction("Fight", ImmutableList.of(
                                new SkillTrigger(Skill.MAGIC, "You hold out your hands and summon a ball of electricity. You point in the direction of the kraken and the electricity shoots out of your hands and strikes the water, shocking the creature and causing it to swim away. Luckily, the monster wasn’t holding any people when it got shocked, and no one got hurt.\n",
                                        storyPoints(1)),
                                new SkillTrigger(Skill.WEAPON_USE, "A sharp blade should be able to handle those tentacles. You pull out your sword and shout, “Hey you big, slimy, fish!” The monster swings a tentacle at you, and you slice through it instantly. The creature screeches and dives underwater.\n",
                                        storyPoints(1)),
                                new SkillTrigger(null, "You want to fight off this terrible monster, but you have nothing to fight it with. You run up to the nearest tentacle and give it a few kicks, but it flicks you away and you have no choice but to give up.\n",
                                        storyPoints(-1))))),
                new Image("Kraken.jpg")
        );
    }
}
