package com.tanerus.adventofcode.advent2020.day8;

import java.util.List;

public class Util {
    public static void parseInstructions(List<Instruction> instructionList) {
        String[] inputStrings = Input.initializeString();
        for (int i = 0; i < inputStrings.length; i++) {
            String[] parseString = inputStrings[i].split(" ");
            Instruction instruction = new Instruction();
            instruction.setInstructionType(parseString[0]);
            instruction.setMove(Integer.parseInt(parseString[1]));
            instruction.setChanged(false);
            instructionList.add(instruction);
        }
    }
}
