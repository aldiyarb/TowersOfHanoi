package towerofhanoi;

/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
* 
* This class tests the methods of Disk Class
* @author aldiyarb
* @version (2020.03.25)
*/
public class DiskTest extends student.TestCase {
    private Disk disk;
    
    /**
     * Runs before each test case. Initializes a disk with width 10.
     */
    public void setUp() {
        disk = new Disk(10);
        
    }
     
    /**
     * Tests the getWidth method of Disk Class.
     */
    public void testDisk() {
        assertEquals(10, disk.getWidth());
    }
    
    /**
     * Tests compare method that returns the difference
     * in widths.
     */
    public void testCompareTo1() {
        Disk disk2 = new Disk(11);
        Disk disk3 = new Disk(9);
        Disk disk4 = new Disk(10);
        assertEquals(-1, disk.compareTo(disk2)); 
        assertEquals(1, disk.compareTo(disk3));
        assertEquals(0, disk.compareTo(disk4));
    }
    
    /**
     * Tests compare to when the disk is being compared to a null
     * disk which throws an IllegalArgumentException.
     */
    public void testCompareTo() {
        Disk nullDisk = null; 
        Exception thrown = null;
        try {
            disk.compareTo(nullDisk); 
        } 
        catch (IllegalArgumentException e) {
            thrown = e; 
        }
        assertNotNull(thrown);
    }
    
    /**
     * Tests to string method of Disk Class.
     */
    public void testToString() {
        assertEquals("10", disk.toString());
    }
    
    /**
     * Test equals method for all cases
     */
    public void testEquals() {
        Disk disk2 = new Disk(10); 
        Disk disk3 = new Disk(9);
        Disk nullDisk = null;
        int diskFail = 19;
        assertTrue(disk.equals(disk));
        //Test if disk equals to itself
        assertTrue(disk.equals(disk2)); 
        //Test if disk equals to another disk with the same length.
        assertFalse(disk.equals(nullDisk));
        //Test if disk equals to a disk that is null
        assertFalse(disk.equals(disk3));
        //Test if disk equals to another disk with different lengths.
        assertFalse(disk.equals(diskFail));
        //Test if disk equals to an object of a different class.
        
    }
}
