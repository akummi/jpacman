package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;
import nl.tudelft.jpacman.points.PointCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerCollisionsTest{
    private static final EmptySprite emptySprite = new EmptySprite();
    Pellet pellet = new Pellet(1,emptySprite);
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private Player ThePlayer = Factory.createPacMan();
    private PointCalculator calculator = new DefaultPointCalculator();
    PlayerCollisions collisions = new PlayerCollisions(calculator);
    @Test
    void testCollision(){
        int oldscore = ThePlayer.getScore(); //saves old score
        collisions.playerVersusPellet(ThePlayer, pellet); //player hits pellet
        assertThat(ThePlayer.getScore() > oldscore); //if player hits pellet score should increase
    }
}
