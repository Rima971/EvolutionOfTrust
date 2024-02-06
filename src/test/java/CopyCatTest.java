import org.game.Game;
import org.game.Player;
import org.game.Score;
import org.game.playerTypes.Cheater;
import org.game.playerTypes.Cooperator;
import org.game.playerTypes.CopyCat;
import org.game.playerTypes.CopyKitten;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CopyCatTest {
    @Test
    public void alwaysCheatsAsItsFirstMove(){
        Player firstOpponent = new Cheater();
        Player secondOpponent = new Cooperator();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(firstOpponent, copyCat);

        game.start(1);
        assertEquals(new Score(0), firstOpponent.getScores());
        assertEquals(new Score(0), copyCat.getScores());

        copyCat = new CopyCat();
        game = new Game(secondOpponent, copyCat);

        game.start(1);

        assertEquals(new Score(-1), secondOpponent.getScores());
        assertEquals(new Score(3), copyCat.getScores());
    }

    @Test
    public void copiesTheOpponentMovesWhenFacingACheater(){
        Cheater cheater = new Cheater();
        CopyCat copyCat = new CopyCat();

        cheater.decide();
        copyCat.decide();
        cheater.decide();
        copyCat.decide();

        assertEquals(new Score(0), cheater.getScores());
        assertEquals(new Score(0), copyCat.getScores());

        cheater.decide();
        copyCat.decide();

        assertEquals(new Score(0), cheater.getScores());
        assertEquals(new Score(0), copyCat.getScores());

        cheater.decide();
        copyCat.decide();

        assertEquals(new Score(0), cheater.getScores());
        assertEquals(new Score(0), copyCat.getScores());
    }

    @Test
    public void copiesTheOpponentMovesWhenFacingACooperator(){
        Cooperator cooperator = new Cooperator();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(cooperator, copyCat);

        game.start(2);

        assertEquals(new Score(1), cooperator.getScores());
        assertEquals(new Score(5), copyCat.getScores());

        game.start(1);

        assertEquals(new Score(3), cooperator.getScores());
        assertEquals(new Score(7), copyCat.getScores());
    }

    @Test
    public void copiesTheOpponentMovesWhenFacingACopyKitten(){
        CopyKitten copyKitten = new CopyKitten();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(copyKitten, copyCat);

        game.start(2);

        assertEquals(new Score(2), copyKitten.getScores());
        assertEquals(new Score(2), copyCat.getScores());

        game.start(1);

        assertEquals(new Score(1), copyKitten.getScores());
        assertEquals(new Score(5), copyCat.getScores());
    }
}
