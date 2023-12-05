package ms.advent.daythree;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class EngineSchematic {

    public List<String> schematic;
    public List<Integer> partNumbers = new ArrayList<>();

    public void setSchematic(List<String> schematic) {
        this.schematic = schematic;
    }

    public int findPartNumbers() {
        int gearNumberTotal = 0;

        for (int i = 0; i < this.schematic.size(); i++) {
            for (int j = 0; j < this.schematic.get(0).length(); j++) {
                // change from symbol to * for part two
                if (this.schematic.get(i).charAt(j) == '*') {
                    List<Integer> allPartNumbers = this.searchSurroundingSymbol(i, j);
//                    System.out.println("allPartNumbers: " + allPartNumbers);
                    if (allPartNumbers.size() == 2) {
                        gearNumberTotal += allPartNumbers.get(0) * allPartNumbers.get(1);
                    }

                }
            }
        }
        return gearNumberTotal;
    }

    public List<Integer> searchSurroundingSymbol(int row, int col) {
        List<String> schematicForSymbol;
        schematicForSymbol = this.schematic;

        List<Integer> partNumberForSymbol = new ArrayList<>();

        if (this.getValidAndDigit(schematicForSymbol, row-1, col)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row-1,col));
        }
        if (this.getValidAndDigit(schematicForSymbol, row-1, col+1)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row-1,col+1));
        }
        if (this.getValidAndDigit(schematicForSymbol, row, col+1)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row, col+1));
        }
        if (this.getValidAndDigit(schematicForSymbol, row+1, col+1)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row+1, col+1));
        }
        if (this.getValidAndDigit(schematicForSymbol, row+1, col)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row+1, col));
        }
        if (this.getValidAndDigit(schematicForSymbol, row+1, col-1)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row+1, col-1));
        }
        if (this.getValidAndDigit(schematicForSymbol, row, col-1)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row, col-1));
        }
        if (this.getValidAndDigit(schematicForSymbol, row-1, col-1)) {
            partNumberForSymbol.add(this.findFullNumber(schematicForSymbol, row-1, col-1));
        }

        return partNumberForSymbol;
    }

    public boolean getValidAndDigit(List<String> schema, int row, int col) {
        boolean validAndDigit = false;
        if (row >= 0 && row < schema.size() && col >= 0 && col < schema.get(0).length()) {
            char adjacentChar = schema.get(row).charAt(col);
            if (Character.isDigit(adjacentChar)) {
                validAndDigit = true;
            }
        }
        return validAndDigit;
    }

    public void removePartNumber(List<String> schema, int row, int col) {
        this.partNumbers.add(this.findFullNumber(schema, row, col));
    }

    public Integer findFullNumber(List<String> schema, int row, int col) {
        String fullRow = schema.get(row);
        char[] newRow = fullRow.toCharArray();

        String number = String.valueOf(fullRow.charAt(col));
        newRow[col] = '.';

        int left = col-1;
        int right = col+1;

        while (left>=0) {
            if (isDigit(fullRow.charAt(left))) {
                number = String.valueOf(fullRow.charAt(left)).concat(number);
                newRow[left] = '.';
                left--;
            } else {
                break;
            }
        }

        while (right<fullRow.length()) {
            if (isDigit(fullRow.charAt(right))) {
                number = number.concat(String.valueOf(fullRow.charAt(right)));
                newRow[right] = '.';
                right++;
            } else {
                break;
            }
        }
        schema.set(row, String.valueOf(newRow));

        return Integer.valueOf(number);
    }

    public boolean isSymbol(char schematicChar) {
        return !isDigit(schematicChar) && !String.valueOf(schematicChar).equals(".");
    }
}

