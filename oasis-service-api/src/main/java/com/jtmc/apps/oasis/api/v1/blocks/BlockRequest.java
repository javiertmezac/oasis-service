package com.jtmc.apps.oasis.api.v1.blocks;

public class BlockRequest {

    private int blockId;
    private String letter;
    private int startNumber;
    private int endNumber;
    private int employeeId;
    private int nextBlockNumber;

    public int getNextBlockNumber() {
        return nextBlockNumber;
    }

    public void setNextBlockNumber(int nextBlockNumber) {
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

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
