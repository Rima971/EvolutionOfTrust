package org.game.playerTypes;

import org.game.Player;
import org.game.enums.Move;

public class Cooperator extends Player {
    @Override
    public Move decide() {
        return Move.COOPERATE;
    }
}