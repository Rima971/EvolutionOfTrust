import org.game.Game;
import org.game.Score;
import org.game.playerTypes.*;
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
        assertEquals(new Score(3), cheater.getScore());
        assertEquals(new Score(-1), cooperator.getScore());
    }

    @Test
    public void twoCheatersCanPlay5RoundsAndGenerateCorrectScores(){
        Cheater firstCheater = new Cheater();
        Cheater secondCheater = new Cheater();
        Game game = new Game(firstCheater, secondCheater);

        game.start(5);

        assertEquals(new Score(0), firstCheater.getScore());
        assertEquals(new Score(0), secondCheater.getScore());
    }

    @Test
    public void twoCooperatorsCanPlay5RoundsAndGenerateCorrectScores(){
        Cooperator firstCooperator = new Cooperator();
        Cooperator secondCooperator = new Cooperator();
        Game game = new Game(firstCooperator, secondCooperator);

        game.start(5);

        assertEquals(new Score(10), firstCooperator.getScore());
        assertEquals(new Score(10), secondCooperator.getScore());
    }

    @Test
    public void cheaterAndCooperatorPlay5RoundsAndGenerateCorrectScores(){
        Cheater cheater = new Cheater();
        Cooperator cooperator = new Cooperator();
        Game game = new Game(cheater, cooperator);

        game.start(5);

        assertEquals(new Score(15), cheater.getScore());
        assertEquals(new Score(-5), cooperator.getScore());
    }
    @Test
    public void copyCatAndCheaterPlayAndGenerateCorrectScores(){
        Cheater cheater = new Cheater();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(cheater, copyCat);

        game.start(2);

        assertEquals(new Score(0), cheater.getScore());
        assertEquals(new Score(0), copyCat.getScore());

        game.start(1);

        assertEquals(new Score(0), cheater.getScore());
        assertEquals(new Score(0), copyCat.getScore());

        game.start(1);

        assertEquals(new Score(0), cheater.getScore());
        assertEquals(new Score(0), copyCat.getScore());
    }

    @Test
    public void copyCatAndCooperatorPlayAndGenerateCorrectScores(){
        Cooperator cooperator = new Cooperator();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(cooperator, copyCat);

        game.start(2);

        assertEquals(new Score(1), cooperator.getScore());
        assertEquals(new Score(5), copyCat.getScore());

        game.start(1);

        assertEquals(new Score(3), cooperator.getScore());
        assertEquals(new Score(7), copyCat.getScore());
    }

    @Test
    public void copyCatAndCooperatorPlay5RoundsAndGenerateCorrectScores(){
        Cooperator cooperator = new Cooperator();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(copyCat, cooperator);

        game.start(5);
        assertEquals(new Score(11), copyCat.getScore());
        assertEquals(new Score(7), cooperator.getScore());
    }
    @Test
    public void copyKittenAndCheaterPlayAndGenerateCorrectScores(){
        Cheater cheater = new Cheater();
        CopyKitten copyKitten = new CopyKitten();
        Game game = new Game(cheater, copyKitten);

        game.start(2);

        assertEquals(new Score(3), cheater.getScore());
        assertEquals(new Score(-1), copyKitten.getScore());

        game.start(1);

        assertEquals(new Score(3), cheater.getScore());
        assertEquals(new Score(-1), copyKitten.getScore());

        game.start(1);

        assertEquals(new Score(3), cheater.getScore());
        assertEquals(new Score(-1), copyKitten.getScore());
    }

    @Test
    public void copyKittenAndCooperatorPlayAndGenerateCorrectScores(){
        Cooperator cooperator = new Cooperator();
        CopyKitten copyKitten = new CopyKitten();
        Game game = new Game(cooperator, copyKitten);

        game.start(2);

        assertEquals(new Score(4), cooperator.getScore());
        assertEquals(new Score(4), copyKitten.getScore());

        game.start(1);

        assertEquals(new Score(6), cooperator.getScore());
        assertEquals(new Score(6), copyKitten.getScore());
    }

    @Test
    public void copyKittenAndCopyCatPlayAndGenerateCorrectScores(){
        CopyKitten copyKitten = new CopyKitten();
        CopyCat copyCat = new CopyCat();
        Game game = new Game(copyKitten, copyCat);

        game.start(2);

        assertEquals(new Score(2), copyKitten.getScore());
        assertEquals(new Score(2), copyCat.getScore());

        game.start(1);

        assertEquals(new Score(1), copyKitten.getScore());
        assertEquals(new Score(5), copyCat.getScore());
    }

    @Test
    public void detectiveAndCheaterPlayTotal5RoundsAndGenerateCorrectScores(){
        Detective detective = new Detective();
        Cheater cheater = new Cheater();
        Game game = new Game(detective, cheater);

        game.start(2);

        assertEquals(new Score(-1), detective.getScore());
        assertEquals(new Score(3), cheater.getScore());

        game.start(3);

        assertEquals(new Score(-1), detective.getScore());
        assertEquals(new Score(3), cheater.getScore());
    }

    @Test
    public void detectiveAndCooperatorPlayTotal5RoundsAndGenerateCorrectScores(){
        Detective detective = new Detective();
        Cooperator cooperator = new Cooperator();
        Game game = new Game(detective, cooperator);

        game.start(2);

        assertEquals(new Score(5), detective.getScore());
        assertEquals(new Score(1), cooperator.getScore());

        game.start(3);

        assertEquals(new Score(14), detective.getScore());
        assertEquals(new Score(-2), cooperator.getScore());
    }

}
