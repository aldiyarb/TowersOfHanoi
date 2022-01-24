package towerofhanoi;
/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
* 
* The Tower class will generate Towers that function as stacks on which Disks
* will be stored. This class extends LinkedStack with specific type of data 
* Disk that will be stored in it.
* @author aldiyarb
* @version (2020.03.25)
*/

public class Tower extends LinkedStack<Disk> {
    private Position position;
    
    /**
     * Tower class constructor that creates a stack and then stores 
     * this tower's position in a field
     * @param position This tower's position
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
     
    /**
     * Returns the Tower's Position
     * @return Returns the position of the tower from Enumerator.
     */
    public Position position() {
        return this.position;
    }
    
    @Override
    /**
     * Overridden method of push from LinkedStack that only pushes
     * the disk if this tower is already empty, or the disk on top
     * is larger than the disk being pushed. 
     * @param disk Disk to be pushed on the Tower.
     */
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if ((this.isEmpty() || disk.compareTo(this.peek()) < 0) ) {
            super.push(disk);
            
        } 
        else {
            throw new IllegalStateException();
        }
    }
    
    
}
