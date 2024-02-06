package org.game.playerTypes;

import org.game.enums.Move;
import org.game.Player;

public class Cheater extends Player {
    @Override
    public Move decide() {
        return Move.CHEAT;
    }


}