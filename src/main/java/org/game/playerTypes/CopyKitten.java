package org.game.playerTypes;

import org.game.Player;
import org.game.enums.Move;

public class CopyKitten extends Player {
    private boolean gainedInLastMove = true; // so it cooperates in first move
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
