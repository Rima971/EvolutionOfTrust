package org.game.playerTypes;

import org.game.Player;
import org.game.enums.Move;

public class CopyCat extends Player {
    private boolean gainedInLastMove = false;
    @Override
    public Move decide() {
        Move move = Move.CHEAT;
        if (this.gainedInLastMove) {
            move = Move.COOPERATE;
        }
        this.gainedInLastMove = false;
        return move;
    }

    @Override
    public void gain(){
        gainedInLastMove = true;
        super.gain();
    }
}
