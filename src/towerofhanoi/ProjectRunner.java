package towerofhanoi;

/**
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Aldiyar Bekturganov (aldiyarb)
 * 
 * The ProjectRunner class will instantiate the HanoiSolver Class
 * and run it's methods.
 * @author aldiyarb
 * @version (2020.03.25)
 */
public class ProjectRunner {

    /**
     * Main method that runs the HanoiSolver with either
     * default setting of 5 disks. Or will take the input 
     * number of disks as args parameter and run it with 
     * inputed number of disks.
     * @param args Number of disks to be in the HanoiSolver.
     */
    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        new PuzzleWindow(new HanoiSolver(disks));


    }
}
