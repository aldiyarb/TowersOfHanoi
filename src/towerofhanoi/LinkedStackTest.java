package towerofhanoi;

import java.util.EmptyStackException;
/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
* 
* This test class tests the methods of the LinkedStack Class.
* @author aldiyarb
* @version (2020.03.25)
* @param <T> The type of objects that the stack will hold.
*/ 
@SuppressWarnings({"unchecked", "rawtypes"}) 
public class LinkedStackTest<T> extends student.TestCase {
    private LinkedStack linked;
    private LinkedStack linked2;
    
    /**
     * This method runs before each test method
     */
    public void setUp() {
        linked = new LinkedStack<T>();
        linked2 = new LinkedStack<T>();
    }
    
    /**
     * Tests the size method of LinkedStack.
     */
    public void testSize() {
        assertEquals(0, linked2.size());
        linked.push("1");
        assertEquals(1, linked.size());
    }
    
    /**
     * Tests isEmpty method of LinkedStack
     */
    public void testIsEmpty() {
        assertTrue(linked.isEmpty());
        linked2.push("2");
        assertFalse(linked2.isEmpty());        
    }
    
    /**
     * Tests peek method when the LinkedStack
     * is empty.
     */
    public void testPeekException() {
        Exception thrown = null;
        try {
            linked.peek();
        }
        
        catch (EmptyStackException e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }
    
    /**
     * Tests peek method of LinkedStack with 
     * elements in it.
     */
    public void testPeek() {
        linked.push("1");
        linked.push("2");
        linked.push("3");
        assertEquals("3", linked.peek());
        assertEquals(3, linked.size());
    }
    
    /**
     * Tests pop method of LinkedStack with 
     * elements in it and if the size is 
     * reduced after removal.
     */
    public void testPop() {
        linked.push("1");
        linked.push("2");
        linked.push("3");
        assertEquals("3", linked.pop());
        assertEquals(2, linked.size());
        assertEquals("2", linked.pop());
        assertEquals(1, linked.size());
        assertEquals("1", linked.pop());
    }
    
    /**
     * Tests pop method when the LinkedStack
     * is empty.
     */
    public void testPopException() {
        Exception thrown = null;
        try {
            linked.pop();
        }
        
        catch (EmptyStackException e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }
    
    /**
     * Tests push method of LinkedStack
     */
    public void testPush() { 
        linked.push("1");
        linked.push("2");
        linked.push("3");  
        assertEquals(3, linked.size());
    }
    
    /**
     * Tests clear method of LinkedStack
     */
    public void testClear() {
        linked.push("1");
        linked.push("2");
        linked.push("3");    
        linked.clear();
        assertEquals(0, linked.size());
    }
    
    /**
     * Tests the toString method to see
     * if LinkedStack is correctly converted to 
     * string representation.
     */
    public void testToString() {
        linked.push("1");
        linked.push("2");
        linked.push("3");
        assertEquals("[3, 2, 1]", linked.toString());
        
    }
    
}

