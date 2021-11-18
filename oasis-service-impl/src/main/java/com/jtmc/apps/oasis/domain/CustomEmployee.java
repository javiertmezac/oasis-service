package com.jtmc.apps.oasis.domain;

public class CustomEmployee extends Trabajador {

    private char letter;
    private Integer nextBlockNumber;
    private Integer blockStartNumber;
    private Integer blockEndNumber;
    private Integer blockId;

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockStartNumber() {
        return blockStartNumber;
    }

    public void setBlockStartNumber(Integer blockStartNumber) {
        this.blockStartNumber = blockStartNumber;
    }

    public Integer getBlockEndNumber() {
        return blockEndNumber;
    }

    public void setBlockEndNumber(Integer blockEndNumber) {
        this.blockEndNumber = blockEndNumber;
    }

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
