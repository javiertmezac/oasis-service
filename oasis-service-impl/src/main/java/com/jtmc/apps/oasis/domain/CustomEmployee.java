package com.jtmc.apps.oasis.domain;

public class CustomEmployee extends Trabajador {

    private char letter;
    private int nextBlockNumber;

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getNextBlockNumber() {
        return nextBlockNumber;
    }

    public void setNextBlockNumber(int nextBlockNumber) {
        this.nextBlockNumber = nextBlockNumber;
    }
}
