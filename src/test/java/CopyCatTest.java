import org.game.Score;
import org.game.enums.Move;
import org.game.playerTypes.CopyCat;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyCatTest {
    @Test
    public void alwaysCheatsAsItsFirstMove(){
        CopyCat copyCat = new CopyCat();
        assertEquals(Move.CHEAT, copyCat.decide());
        assertEquals(new Score(0), copyCat.getScore());
    }

    @Test
    public void cooperatesOnGainingCoins(){
        CopyCat copyCat = new CopyCat();
        copyCat.gain();
        assertEquals(Move.COOPERATE, copyCat.decide());
        assertEquals(new Score(3), copyCat.getScore());
    }

    @Test
    public void cheatsOnNotGainingCoins(){
        CopyCat copyCat = new CopyCat();

        // opponent cooperates
        copyCat.gain();
        copyCat.decide();

        // opponent cheats
        Move decision = copyCat.decide();

        assertEquals(Move.CHEAT, decision);
        assertEquals(new Score(3), copyCat.getScore());
    }
}
