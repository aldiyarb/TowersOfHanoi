package towerofhanoi;

/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
 * 
 * This test class tests the methods of HanoiSolver Class
 * @author aldiyarb
 * @version (2020.03.25)
 */
public class HanoiSolverTest extends student.TestCase {
    private HanoiSolver hanoiTest; 

    /**
     * Runs before each test Case.
     * Initializes a new HanoiSolver objects with space for 10 disks.
     */
    public void setUp() {
        hanoiTest = new HanoiSolver(10);   

    }

    /**
     * Tests disks method of HanoiSolver class by pushing disks
     * on the tower and checking the number of disks in it after
     * the push.
     */
    public void testDisks() {
        for (int i = 10; i > 0; i--) {
            hanoiTest.getTower(Position.LEFT).push(new Disk(i));   
            //Pushes disks on to the left tower
        }
        assertEquals(10, hanoiTest.disks());


    }

    /**
     * Tests the getTower method of HanoiSolverClass
     * for each possible case from Enumerator.
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, 
            hanoiTest.getTower(Position.LEFT).position());
        assertEquals(Position.RIGHT, 
            hanoiTest.getTower(Position.RIGHT).position());
        assertEquals(Position.MIDDLE, 
            hanoiTest.getTower(Position.MIDDLE).position());
        assertEquals(Position.MIDDLE, 
            hanoiTest.getTower(Position.DEFAULT).position());
    }

    /**
     * Tests the toString class of HanoiSolver
     */
    public void testToString() {
        for (int i = 10; i > 0; i--) {
            hanoiTest.getTower(Position.LEFT).push(new Disk(i));   
            //Pushes disks on to the left tower
        }
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10][][]",
            hanoiTest.toString());
        //Checks the correctness of string representation of towers.   
    }

    /**
     * Tests solve method of// the HanoiSolver Class.
     * The disks should be moved from right tower to the left tower
     */
    public void testSolve() {
        for (int i = 10; i > 0; i--) {
            hanoiTest.getTower(Position.RIGHT).push(new Disk(i));
        }
        //Pushes disks on to the left tower
        hanoiTest.solve();
        //assertEquals("[][][1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",
            //hanoiTest.toString());
        //Checks the correctness of string representation of towers.   
        assertEquals(10, hanoiTest.getTower(Position.LEFT).size());
       
        //Checks if all disks have been moved to the designated tower.
    }
    
   
        
}


