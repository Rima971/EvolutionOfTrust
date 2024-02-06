import org.game.Player;
import org.game.Score;
import org.game.playerTypes.Cheater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void ableToGainOrInvestCoins(){
        Player cheater = new Cheater();
        cheater.gain();
        assertEquals(new Score(3), cheater.getScore());

        cheater.invest();
        assertEquals(new Score(2), cheater.getScore());
    }
}
