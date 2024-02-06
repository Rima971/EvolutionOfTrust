package org.game;

import org.game.enums.Move;

abstract public class Player {
    protected int score = 0;
    public Player(){

    }
    abstract public Move decide();

    public void invest(){
        score -= 1;
    }

    public void gain(){
        score += 3;
    }

    public Score getScores(){
        return new Score(this.score);
    }

}