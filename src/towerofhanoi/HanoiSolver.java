package towerofhanoi;
import java.util.Observable;

/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
* 
* The methods within this class solve the Tower Of Hanoi Puzzle by
* moving disks between towers accordingly. Observed by the PuzzleWindow
* 
* @author aldiyarb
* @version (2020.03.25)
*/
public class HanoiSolver extends Observable {
    private Tower left; 
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * HanoiSolver Constructor that initializes a new Hanoi
     * Solver with a set number of disks.
     * @param numDisks Number of disks to be in the Puzzle.
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * Returns the number of disks in the HanoiSolver.
     * @return The numbers of disks in the HanoiSolver.
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * Depending on the position requested,
     * return either left, middle, or right tower
     * @param pos Position taken from Enumerator
     * @return returns the tower in accordance with it's position 
     * from Enumerator
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }
    
    /**
     * Returns left, middle, and right towers as Strings 
     * appended to each other with disks widths present on 
     * each tower.
     * @return Returns the String format of left, middle, 
     * and right towers.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(left.toString());
        builder.append(middle.toString());
        builder.append(right.toString());
        return builder.toString();

    }
    /**
     * Moves the disk from one tower to another. Notifies
     * the PuzzleWindow observer that the disk has been moved.
     * @param source Tower the disk is moved from
     * @param destination Tower the disk is moved to
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
        

    }
    /**
     * Solves the puzzle by moving disk from startPole to
     * endPole such that a larger disk cannot be on top 
     * of a smaller one at any time. Using recursion
     * @param currentDisks number of disks
     * @param startPole Starting pole
     * @param tempPole  Pole that temporary stores disks
     * @param endPole Ending pole
     */
    private void solveTowers(int currentDisks, Tower startPole,
        Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
            
        }
        
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
        
    }
    /**
     * Calls the solveTowers method using field parameters
     * for towers and number of disks.
     */
    public void solve() {
        solveTowers(this.numDisks, this.right, this.middle, this.left);
        
    }




}

