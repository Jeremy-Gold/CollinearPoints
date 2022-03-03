import java.util.Random;
import java.util.Scanner;
import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class Main {
	private static Point[] points;
	private static final int NUM_OF_POINTS = 200;
	private static Random rng;
	private static BruteCollinearPoints brute;
	private static Scanner scanner;
	public static void main (String[] args) {
		 StdDraw.enableDoubleBuffering();
         StdDraw.setXscale(0, 32768);
         StdDraw.setYscale(0, 32768);
         rng = new Random();
         scanner = new Scanner(System.in);
         points = new Point[NUM_OF_POINTS];
         for (int i = 0; i < NUM_OF_POINTS; i++) {
        	 int x = rng.nextInt(500) * 64;
        	 int y = rng.nextInt(500) * 64;
        	 points[i] = new Point(x, y);
        	 points[i].draw();
         }
         brute = new BruteCollinearPoints(points);
         System.out.println("There are " + brute.numberOfSegments() + "sets of 4 collinear points.");
         System.out.println("Would you like to see them? Type \"draw\"");
         if(scanner.next() == "yes") {
        	 for(LineSegment segment : brute.segments()) {
        		 segment.draw();
        	 }
         }
	}
}
