import org.game.Game;
import org.game.Score;
import org.game.playerTypes.Cheater;
import org.game.playerTypes.Cooperator;
import org.game.playerTypes.CopyCat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void ableToCreateAGameWithTwoPlayers(){
        Cheater cheater = new Cheater();
        Cooperator cooperator = new Cooperator();
        assertDoesNotThrow(()->new Game(cheater, cooperator));
    }

    @Test
    public void ableToStartARound(){
        Cheater cheater = new Cheater();
        Cooperator cooperator = new Cooperator();
        Game game = new Game(cheater, cooperator);
        assertDoesNotThrow(()->game.start(1));
        assertEquals(new Score(3), cheater.getScores());
        assertEquals(new Score(-1), cooperator.getScores());
    }

    @Test
    public void twoCheatersCanPlay5RoundsAndGenerateCorrectScores(){
        Cheater firstCheater = new Cheater();
        Cheater secondCheater = new Cheater();
        Game game = new Game(firstCheater, secondCheater);

        game.start(5);

        assertEquals(new Score(0), firstCheater.getScores());
        assertEquals(new Score(0), secondCheater.getScores());
    }

    @Test
    public void twoCooperatorsCanPlay5RoundsAndGenerateCorrectScores(){
        Cooperator firstCooperator = new Cooperator();
        Cooperator secondCooperator = new Cooperator();
        Game game = new Game(firstCooperator, secondCooperator);

        game.start(5);

        assertEquals(new Score(10), firstCooperator.getScores());
        assertEquals(new Score(10), secondCooperator.getScores());
    }

    @Test
    public void cheaterAndCooperatorPlay5RoundsAndGenerateCorrectScores(){
        Cheater cheater = new Cheater();
        Cooperator cooperator = new Cooperator();
        Game game = new Game(cheater, cooperator);

        game.start(5);

        assertEquals(new Score(15), cheater.getScores());
        assertEquals(new Score(-5), cooperator.getScores());
    }

    @Test
    public void copyCatAndCooperatorPlay5RoundsAndGenerateCorrectScores(){
        Cooperator cooperator = new Cooperator();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(copyCat, cooperator);

        game.start(5);
        assertEquals(new Score(11), copyCat.getScores());
        assertEquals(new Score(7), cooperator.getScores());
    }
}
