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
        for (int i = 0; i < this.schematic.size(); i++) {
            for (int j = 0; j < this.schematic.get(0).length(); j++) {
                if (this.isSymbol(this.schematic.get(i).charAt(j))) {
                    this.searchSurroundingSymbol(i, j);
                }
            }
        }
        int partNumberTotal = 0;
        for (int partNumber: this.partNumbers) {
            partNumberTotal += partNumber;
        }
        return partNumberTotal;
    }

    public void searchSurroundingSymbol(int row, int col) {
        if (this.getValidAndDigit(row-1, col)) {
            this.removePartNumber(row-1,col);
        };
        if (this.getValidAndDigit(row-1, col+1)) {
            this.removePartNumber(row-1,col+1);
        };
        if (this.getValidAndDigit(row, col+1)) {
            this.removePartNumber(row, col+1);
        };
        if (this.getValidAndDigit(row+1, col+1)) {
            this.removePartNumber(row+1, col+1);
        };
        if (this.getValidAndDigit(row+1, col)) {
            this.removePartNumber(row+1, col);
        };
        if (this.getValidAndDigit(row+1, col-1)) {
            this.removePartNumber(row+1, col-1);
        };
        if (this.getValidAndDigit(row, col-1)) {
            this.removePartNumber(row, col-1);
        };
        if (this.getValidAndDigit(row-1, col-1)) {
            this.removePartNumber(row-1, col-1);
        };
    }

    public boolean getValidAndDigit(int row, int col) {
        boolean validAndDigit = false;
        if (row >= 0 && row < this.schematic.size() && col >= 0 && col < this.schematic.get(0).length()) {
            char adjacentChar = this.schematic.get(row).charAt(col);
            if (Character.isDigit(adjacentChar)) {
                validAndDigit = true;
            }
        }
        return validAndDigit;
    }

    public void removePartNumber(int row, int col) {
        this.partNumbers.add(this.findFullNumber(row, col));
    }

    public Integer findFullNumber(int row, int col) {
        String fullRow = this.schematic.get(row);
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

        this.schematic.set(row, String.valueOf(newRow));

        return Integer.valueOf(number);
    }

    public boolean isSymbol(char schematicChar) {
        return !isDigit(schematicChar) && !String.valueOf(schematicChar).equals(".");
    }
}

