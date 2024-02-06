package org.game;

import org.game.enums.Move;

public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;
    public Game(Player player1, Player player2){
        this.firstPlayer = player1;
        this.secondPlayer = player2;
    }

    private void startRound(){
        Move firstPlayerDecision = firstPlayer.decide();
        Move secondPlayerDecision = secondPlayer.decide();

        if (firstPlayerDecision == Move.COOPERATE){
            firstPlayer.invest();
            secondPlayer.gain();
        }
        if (secondPlayerDecision == Move.COOPERATE){
            secondPlayer.invest();
            firstPlayer.gain();
        }
    }

    public void start(int rounds){
        for (int i=0; i<rounds; i++){
            this.startRound();
        }
    }
}