package aeroplane;

import java.util.NoSuchElementException;

public class Seat {

   private int row;
   private char letter;
   public static final char firstSeat = 'A';

    public Seat(int row, char letter) {
        this.row = row;
        this.letter = letter;
    }

    public int getRow() {
        return row;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isEmergencyExit() {
        return AeroplaneInfo.emergencyRows.contains(row);
    }

    public boolean hasNext() {
        return !(this.row == AeroplaneInfo.numRows &&
                (this.letter == (char) (firstSeat + AeroplaneInfo.seatsPerRow -1 )));

    }

    public Seat next () {
        if (hasNext()) {
            if (this.letter == (firstSeat + AeroplaneInfo.seatsPerRow - 1)) {
                return new Seat(row + 1, firstSeat);
            } else {
                return new Seat(row, (char) (this.letter + 1));
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Seat)) {
            return false;
        }

        Seat other = (Seat) obj;
        return this.letter == other.letter &&
                this.row == other.row;
    }

    @Override
    public int hashCode() {
        return 17*letter + 23*row;
    }

    @Override
    public String toString() {
        return Integer.toString(row) + Character.toString(letter);
    }
}
