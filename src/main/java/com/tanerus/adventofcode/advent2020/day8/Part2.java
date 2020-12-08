package com.tanerus.adventofcode.advent2020.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tanerus.adventofcode.advent2020.day8.Util.parseInstructions;
/*
* --- Part Two ---
After some careful analysis, you believe that exactly one instruction is corrupted.

Somewhere in the program, either a jmp is supposed to be a nop, or a nop is supposed to be a jmp. (No acc instructions were harmed in the corruption of this boot code.)

The program is supposed to terminate by attempting to execute an instruction immediately after the last instruction in the file. By changing exactly one jmp or nop, you can repair the boot code and make it terminate correctly.

For example, consider the same program from above:

nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6
If you change the first instruction from nop +0 to jmp +0, it would create a single-instruction infinite loop, never leaving that instruction. If you change almost any of the jmp instructions, the program will still eventually find another jmp instruction and loop forever.

However, if you change the second-to-last instruction (from jmp -4 to nop -4), the program terminates! The instructions are visited in this order:

nop +0  | 1
acc +1  | 2
jmp +4  | 3
acc +3  |
jmp -3  |
acc -99 |
acc +1  | 4
nop -4  | 5
acc +6  | 6
After the last instruction (acc +6), the program terminates by attempting to run the instruction below the last instruction in the file. With this change, after the program terminates, the accumulator contains the value 8 (acc +1, acc +1, acc +6).

Fix the program so that it terminates normally by changing exactly one jmp (to nop) or nop (to jmp). What is the value of the accumulator after the program terminates?
* */
public class Part2 {
    private static List<Instruction> instructionList = new ArrayList<>();
    private static List<Integer> movesList = null;
    private static List<Integer> oldMovesList = new ArrayList<>();

    public static void main(String[] args) {
        parseInstructions(instructionList);
        int accumulator = movesWithInstructions(instructionList);
        oldMovesList = movesList.stream().collect(Collectors.toList());
        while (accumulator == -1) {
            Instruction dummyInstruction = null;
            for (Integer item : movesList) {
                Instruction instruction = instructionList.get(item);
                if ((instruction.getInstructionType() == InstructionType.JMP
                        || instruction.getInstructionType() == InstructionType.NOP) &&
                        !instruction.isChanged()) {
                    instruction.setChanged(true);
                    instruction.
                            setInstructionType(instruction.getInstructionType() == InstructionType.JMP ?
                                    InstructionType.NOP : InstructionType.JMP);
                    dummyInstruction = instruction;
                    break;
                }
            }

            oldMovesList = movesList.stream().collect(Collectors.toList());
            accumulator = movesWithInstructions(instructionList);

            if ( accumulator == -1) {
                movesList = oldMovesList.stream().collect(Collectors.toList());
            } else {
                accumulator++;
            }

            dummyInstruction.setInstructionType(dummyInstruction.getInstructionType() == InstructionType.JMP ?
                    InstructionType.NOP : InstructionType.JMP);
        }
        System.out.println(accumulator);
    }

    private static int movesWithInstructions(List<Instruction> instructionListChanged) {

        int accumulator = -1;

        boolean isNormalEnd = false;

        movesList = new ArrayList<>();

        int index = 0;
        boolean stop = false;

        while (!stop) {

            if (index >= instructionListChanged.size()) {
                isNormalEnd = true;
                stop = true;
            } else {
                Instruction instruction = instructionListChanged.get(index);

                if (movesList.contains(index)) {
                    stop = true;
                } else {
                    movesList.add(index);
                    switch (instruction.getInstructionType()) {
                        case ACC:
                            index++;
                            accumulator += instruction.getMove();
                            break;
                        case NOP:
                            index++;
                            break;
                        case JMP:
                            index += instruction.getMove();
                            break;
                    }
                }
            }

        }

        if (!isNormalEnd) {
            accumulator = -1;
        }

        return accumulator;
    }

}
