package org.game.playerTypes;

import org.game.Player;
import org.game.enums.Move;

public class Detective extends Player {
    private int currentRound = 0;
    private boolean gainedInLastMove = true;
    private boolean isAlwaysCheater = true;
    @Override
    public Move decide() {
        Move move = Move.CHEAT;
        if (this.currentRound == 0) move = Move.COOPERATE;
        if ((this.currentRound == 1 || this.currentRound == 2) && !this.gainedInLastMove) this.isAlwaysCheater = false;
        if (this.currentRound>1 && !this.isAlwaysCheater && this.gainedInLastMove) move = Move.COOPERATE;
        this.gainedInLastMove = false;
        this.currentRound++;
        return move;
    }

    @Override
    public void gain(){
        this.gainedInLastMove = true;
        super.gain();
    }
}
