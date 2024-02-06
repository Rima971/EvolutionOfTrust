package org.game;

public class Score {
    private int value = 0;
    public Score(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Score)) return false;
        return this.value == ((Score) o).value;
    }
}
