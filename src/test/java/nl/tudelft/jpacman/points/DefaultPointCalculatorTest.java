package nl.tudelft.jpacman.points;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerCollisions;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPointCalculatorTest {
    private static final EmptySprite emptySprite = new EmptySprite();
    Pellet pellet = new Pellet(1,emptySprite);
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private Player ThePlayer = Factory.createPacMan();
    private DefaultPointCalculator calculator = new DefaultPointCalculator();
    PlayerCollisions collisions = new PlayerCollisions(calculator);
    Direction up = Direction.valueOf("NORTH");

    @Test
    void testDefaultPointCalculator(){
        int oldscore = ThePlayer.getScore(); //gets initial score
        calculator.pacmanMoved(ThePlayer, up); //player moves
        assertThat(ThePlayer.getScore() == oldscore); //player shouldn't be awarded for moving
        oldscore = ThePlayer.getScore(); // saves current score
        calculator.consumedAPellet(ThePlayer, pellet); //player eats pellet
        assertThat(oldscore < ThePlayer.getScore()); //player should be awarded for eating pellet
    }
}
