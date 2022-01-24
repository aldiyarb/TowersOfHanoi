package towerofhanoi;

import java.util.Observer;
import java.util.Observable;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
import CS2114.Button;
/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
 * 
 * This is the PuzzleWindow Class that implements Observer
 * that adds all of the objects present in the puzzle to
 * the window and observes HanoiSolver given to it by the main
 * method present in ProjectRunner for updates on when to animate
 * the Window.
 * @author aldiyarb
 * @version (2020.03.25)
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    public static final int WIDTH_FACTOR = 5;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 10;
    public static final int POLE_HEIGHT = 80;
    public static final int POLE_WIDTH = 5;

 
    /**
     * PuzzleWindow Constructor that adds all objects to the Window, moves 
     * them to correct locations and initializes the solve button. Also,
     * this PuzzleWindow is assigned as an observer to the HanoiSolver 
     * @param game HanoiSolver that the PuzzleWindow observes and runs.
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower Of Hanoi");
        int xCoord = window.getGraphPanelWidth()/6;
        int yCoord = window.getGraphPanelHeight()/2;
        //Defines general coordinates of poles
        left = new Shape(xCoord,
            yCoord, POLE_WIDTH, POLE_HEIGHT);
        middle = new Shape(xCoord * 3,
            yCoord, POLE_WIDTH, POLE_HEIGHT);
        right = new Shape(xCoord * 5,
            yCoord, POLE_WIDTH, POLE_HEIGHT);
        for (int i = game.disks(); i > 0; i--) {
            Disk disk = new Disk(i * 10);
            //Pushes disks in the HanoiSolver to the starting left tower
            window.addShape(disk);            
            game.getTower(Position.RIGHT).push(disk);
            moveDisk(Position.RIGHT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
        //Adds all objects to the window.
    }

    /**
     * The sleep() method is used to pause between Disk movements to
     * visually observe the algorithm when the program is running.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }

    /**
     * This method updates the front-end, after the back-end has
     * been changed. It uses the position parameter to move the disks
     * in the window(front-end) in accordance with where the disks were 
     * moved in the HanoiSolver.solve() method (back-end).
     * @param position The position to which the disk on the window needs 
     * to be moved to
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            default:
                currentPole = middle;
                break;
                //Switch statement that uses position to determine where the 
                //disk needs to be moved on the PuzzleWindow(front-end)
        }
        int xCoord = (currentPole.getX() - 
            (currentDisk.getWidth() - POLE_WIDTH) / 2);
        int yCoord = currentPole.getY() + POLE_HEIGHT - 
            (game.getTower(position).size() * DISK_HEIGHT);
        //Calculation of coordinates for disks to be in the middle of the pole
        //and stacked properly
        currentDisk.moveTo(xCoord, yCoord);
        //Moves the disk to given coordinates.
    }



    /**
     * This method supports the solve() method that runs solve method
     * when the button is Clicked
     * @param button Solve button that is clicked to run solve().
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
        //Thread is needed for clickedSolve() so that when the game's
        //solve method is called, the front-end is updated when the back-end
        //changes.
    }



    @Override
    /**
     * Update method is called automatically when the game’s move method
     * calls notifyObservers. It relocates the disks on the display in 
     * accordance with the way disks are relocated in the back-end
     * algorithm
     * @param o The class being observed which is HanoiSolver
     * @param arg The position that notifies update from notifyObservers()
     * method in the Observable class HanoiSolver.
     */
    public void update(Observable o, Object arg) {

        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);
            sleep();
        }



    }


}
