package com.jtmc.apps.oasis.domain;

public class CustomEmployee extends Trabajador {

    private char letter;
    private Integer nextBlockNumber;

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Integer getNextBlockNumber() {
        return nextBlockNumber;
    }

    public void setNextBlockNumber(Integer nextBlockNumber) {
        this.nextBlockNumber = nextBlockNumber;
    }
}
