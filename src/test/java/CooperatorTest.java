import org.game.enums.Move;
import org.game.playerTypes.Cooperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CooperatorTest {
    @Test
    public void alwaysReturnsCooperatingMove(){
        Cooperator cooperator = new Cooperator();
        assertEquals(Move.COOPERATE, cooperator.decide());
        assertEquals(Move.COOPERATE, cooperator.decide());
        assertEquals(Move.COOPERATE, cooperator.decide());
    }


}