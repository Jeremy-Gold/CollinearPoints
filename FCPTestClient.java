import java.util.Random;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdDraw;
public class FCPTestClient {
    private static Point[] points;
    private static final int NUM_OF_POINTS = 500;
    private static Random rng;
    private static FastCollinearPoints fast;
    private static Scanner scanner;
    public static void main(String[] args){
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenRadius(0.005);
        rng = new Random();
        scanner = new Scanner(System.in);
        points = new Point[NUM_OF_POINTS];
        for (int i = 0; i < NUM_OF_POINTS; i++) {
            int x = rng.nextInt(500) * 64;
            int y = rng.nextInt(500) * 64;
            points[i] = new Point(x, y);
            points[i].draw();
        }
        fast = new FastCollinearPoints(points);
        System.out.println("There are " + fast.numberOfSegments() + " sets of 4 collinear points.");
        System.out.println("Would you like to see them? Type \"yes\"");
        if(scanner.next().equals("yes")){
            for(LineSegment segment : fast.segments()) {
                segment.draw();
            }
        }
    }
}
