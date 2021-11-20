package com.jtmc.apps.oasis.api.v1.blocks;

public class BlockResponse {

    private int blockId ;
    private String letter;
    private String startNumber;
    private String endNumber;
    private String nextBlockNumber;

    public String getNextBlockNumber() {
        return nextBlockNumber;
    }

    public void setNextBlockNumber(String nextBlockNumber) {
        this.nextBlockNumber = nextBlockNumber;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public String getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }
}
