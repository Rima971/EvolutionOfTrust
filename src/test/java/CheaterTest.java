import org.game.enums.Move;
import org.game.playerTypes.Cheater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheaterTest {
    @Test
    public void alwaysReturnsCheatingMove(){
        Cheater cheater = new Cheater();
        assertEquals(Move.CHEAT, cheater.decide());
        assertEquals(Move.CHEAT, cheater.decide());
        assertEquals(Move.CHEAT, cheater.decide());
    }


}