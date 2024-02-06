import org.game.Score;
import org.game.enums.Move;
import org.game.playerTypes.Detective;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetectiveTest {
    @Test
    public void alwaysCooperatesOnFirstMove(){
        Detective detective = new Detective();
        assertEquals(Move.COOPERATE, detective.decide());
    }

    @Test
    public void alwaysCheatsOnSecondMove(){
        Detective detective = new Detective();
        detective.decide(); // first move
        assertEquals(Move.CHEAT, detective.decide());
        assertEquals(new Score(0), detective.getScore());
    }

    @Test
    public void actsLikeCheaterIfNeverCheatedBackOnFirstTwoRounds(){
        Detective detective = new Detective();

        // first round
        detective.decide();
        detective.gain();

        // second round
        detective.decide();
        detective.gain();

        // subsequent rounds
        assertEquals(Move.CHEAT, detective.decide());
        assertEquals(Move.CHEAT, detective.decide());
        assertEquals(Move.CHEAT, detective.decide());
        assertEquals(Move.CHEAT, detective.decide());
        assertEquals(new Score(6), detective.getScore());
    }

    @Test
    public void actsLikeCopyCatIfCheatedBackInFirstOfTheTwoRounds(){
        Detective detective = new Detective();

        // first round
        detective.decide();
        detective.invest();

        // second round
        detective.decide();
        detective.gain();

        // third round
        Move decision = detective.decide();
        detective.invest();
        assertEquals(Move.COOPERATE, decision);
        assertEquals(new Score(1), detective.getScore());

        // fourth round
        decision = detective.decide();
        detective.gain();
        assertEquals(Move.CHEAT, decision);
        assertEquals(new Score(4), detective.getScore());

        // fifth round
        decision = detective.decide();
        detective.gain();
        detective.invest();
        assertEquals(Move.COOPERATE, decision);
        assertEquals(new Score(6), detective.getScore());

        // sixth round
        decision = detective.decide();
        detective.gain();
        detective.invest();
        assertEquals(Move.COOPERATE, decision);
        assertEquals(new Score(8), detective.getScore());

        // seventh round
        decision = detective.decide();
        detective.invest();
        assertEquals(Move.COOPERATE, decision);
        assertEquals(new Score(7), detective.getScore());

        // eighth round
        decision = detective.decide();
        assertEquals(Move.CHEAT, decision);
        assertEquals(new Score(7), detective.getScore());
    }
}
