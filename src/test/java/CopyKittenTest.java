import org.game.Game;
import org.game.Player;
import org.game.Score;
import org.game.playerTypes.Cheater;
import org.game.playerTypes.Cooperator;
import org.game.playerTypes.CopyCat;
import org.game.playerTypes.CopyKitten;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyKittenTest {
    @Test
    public void alwaysCooperatesAsItsFirstMove(){
        Player firstOpponent = new Cheater();
        Player secondOpponent = new Cooperator();
        CopyKitten copyKitten = new CopyKitten();
        Game game = new Game(firstOpponent, copyKitten);

        game.start(1);
        assertEquals(new Score(3), firstOpponent.getScores());
        assertEquals(new Score(-1), copyKitten.getScores());

        copyKitten = new CopyKitten();
        game = new Game(secondOpponent, copyKitten);

        game.start(1);

        assertEquals(new Score(2), secondOpponent.getScores());
        assertEquals(new Score(2), copyKitten.getScores());
    }

    @Test
    public void copiesTheOpponentMovesWhenFacingACheater(){
        Cheater cheater = new Cheater();
        CopyKitten copyKitten = new CopyKitten();

        cheater.decide();
        copyKitten.decide();
        cheater.decide();
        copyKitten.decide();

        assertEquals(new Score(0), cheater.getScores());
        assertEquals(new Score(0), copyKitten.getScores());

        cheater.decide();
        copyKitten.decide();

        assertEquals(new Score(0), cheater.getScores());
        assertEquals(new Score(0), copyKitten.getScores());

        cheater.decide();
        copyKitten.decide();

        assertEquals(new Score(0), cheater.getScores());
        assertEquals(new Score(0), copyKitten.getScores());
    }

    @Test
    public void copiesTheOpponentMovesWhenFacingACooperator(){
        Cooperator cooperator = new Cooperator();
        CopyKitten copyKitten = new CopyKitten();
        Game game = new Game(cooperator, copyKitten);

        game.start(2);

        assertEquals(new Score(4), cooperator.getScores());
        assertEquals(new Score(4), copyKitten.getScores());

        game.start(1);

        assertEquals(new Score(6), cooperator.getScores());
        assertEquals(new Score(6), copyKitten.getScores());
    }

    @Test
    public void copiesTheOpponentMovesWhenFacingACopyCat(){
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
