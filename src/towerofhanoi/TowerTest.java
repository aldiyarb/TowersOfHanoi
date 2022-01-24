package towerofhanoi;
/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
 * 
 * This class tests the methods of Tower Class
 * @author aldiyarb
 * @version (2020.03.25)
 */


public class TowerTest extends student.TestCase {
    private Tower testTower;
    private Disk disk;

    /**
     * Runs before each test case. 
     * Initializes a left tower and a disk with width 10.
     */
    public void setUp() {
        testTower = new Tower(Position.LEFT);
        disk = new Disk(10);
    }

    /**
     * Tests position method of the Tower Class
     */
    public void testPosition() {
        assertEquals(Position.LEFT, testTower.position());
    }

    /**
     * Tests push method on the Tower class for 
     * a successful push on an empty tower
     */
    public void testPush() {

        testTower.push(disk);
        assertEquals(1, testTower.size());
    }

    /**
     * Tests push method when the disk being 
     * pushed is null which throws an 
     * IllegalArgumentException
     */
    public void testPushNull() {
        Disk nullDisk = null;
        Exception thrown = null;
        try {
            testTower.push(nullDisk);
        }
        catch (IllegalArgumentException e) {
            thrown = e;
            assertNotNull(thrown);
        }
    }

    /**
     * Tests unsuccessful push of a disk on a 
     * tower on top of a smaller disk which
     * throws an IllegalStateException.
     */
    public void testPushError() {
        Disk disk2 = new Disk(11);
        Exception thrown = null;
        testTower.push(disk);
        try {
            testTower.push(disk2);
        } 
        catch (IllegalStateException e) {
            thrown = e;
            assertNotNull(thrown);
        }
    }

    /**
     * Tests a successful consecutive push of 
     * disks with decreasing widths on the
     * tower.
     */
    public void testPushSuccess() {
        Disk disk2 = new Disk(11);
        Disk disk3 = new Disk(9);
        testTower.push(disk2);
        testTower.push(disk);
        testTower.push(disk3);
        assertEquals(3, testTower.size());
    }

}
