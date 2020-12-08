package com.tanerus.adventofcode.advent2020.day8;

enum InstructionType {
    NOP, ACC, JMP
}

public class Instruction {
    private InstructionType instructionType;
    private int move;
    private boolean isChanged = false;

    public Instruction() {
    }

    public Instruction(InstructionType instructionType, int move) {
        this.instructionType = instructionType;
        this.move = move;
    }

    public Instruction(InstructionType instructionType, int move, boolean isChanged) {
        this.instructionType = instructionType;
        this.move = move;
        this.isChanged = isChanged;
    }

    public InstructionType getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(String instructionType) {
        switch (instructionType) {
            case "nop":
                this.instructionType = InstructionType.NOP;
                break;
            case "jmp":
                this.instructionType = InstructionType.JMP;
                break;
            case "acc":
                this.instructionType = InstructionType.ACC;
                break;
            default:
                break;
        }
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void setInstructionType(InstructionType instructionType) {
        this.instructionType = instructionType;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean changed) {
        isChanged = changed;
    }
}
