import org.game.Score;
import org.game.enums.Move;
import org.game.playerTypes.CopyKitten;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyKittenTest {
    @Test
    public void alwaysCooperatesAsItsFirstMove(){
        CopyKitten copyKitten = new CopyKitten();
        assertEquals(Move.COOPERATE, copyKitten.decide());
        assertEquals(new Score(0), copyKitten.getScore());
    }

    @Test
    public void cooperatesOnGainingCoins(){
        CopyKitten copyKitten = new CopyKitten();
        copyKitten.gain();
        assertEquals(Move.COOPERATE, copyKitten.decide());
        assertEquals(new Score(3), copyKitten.getScore());
    }

    @Test
    public void cheatsOnNotGainingCoins(){
        CopyKitten copyKitten = new CopyKitten();

        // opponent cooperates
        copyKitten.gain();
        copyKitten.decide();

        // opponent cheats
        Move decision = copyKitten.decide();

        assertEquals(Move.CHEAT, decision);
        assertEquals(new Score(3), copyKitten.getScore());
    }

}
