package towerofhanoi;
import CS2114.Shape;
import java.awt.Color;
import student.TestableRandom;
/**
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Aldiyar Bekturganov (aldiyarb)
 * 
 * Disk class is the extension of Shape that will be moved between the
 * poles/towers to solve the Tower Of Hanoi Puzzle. 
 * @author aldiyarb
 * @version (2020.03.25)
 */


public class Disk extends Shape implements Comparable<Disk> {

    /**
     * Disk constructor that initializes a new Disk object
     * with a set width parameter.
     * @param width Sets the width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom rand = new TestableRandom();
        Color color = new Color(rand.nextInt(256), 
            rand.nextInt(256), rand.nextInt(256));
        this.setBackgroundColor(color); 

    }

    /**
     * This method compares two disks based on their widths.
     * If the answer is negative, this disk's width is less
     * than the other disk's and vice versa.
     * @param otherDisk The disk this disk will be compared to
     * @return returns negative if this disk's width is less
     * than the other disk's and vice versa.
     */
    public int compareTo(Disk otherDisk) { 
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        else {
            return this.getWidth() - otherDisk.getWidth();
        }
    }

    /**
     * Converts the width of the disk to string.
     * @return Returns the string representation of the disk's
     * width.
     */
    public String toString() {
        String string = "" + this.getWidth();
        return string;

    }

    /**
     * This method returns true if this disk's and other disk's
     * widths are equal. Else, false is returned.
     * @param other The disk to which equality is checked.
     * @return true if disks are equal. False if not.
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            Disk otherDisk = (Disk) other;
            return this.getWidth() == otherDisk.getWidth();
        }
        return false;
    }
}
