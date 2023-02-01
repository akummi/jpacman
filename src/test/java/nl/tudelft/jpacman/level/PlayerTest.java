package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private Player ThePlayer = Factory.createPacMan();

    @Test
    void testAlive(){
        assertThat(ThePlayer.isAlive()).isEqualTo(true);
    }
    @Test
    void testDead(){
        ThePlayer.setAlive(true); //player lives
        assertThat(ThePlayer.isAlive()).isEqualTo(true); //confirms living
        ThePlayer.setAlive(false); //player dies
        assertThat(ThePlayer.isAlive()).isEqualTo(false); //confirms dead

    }
}
