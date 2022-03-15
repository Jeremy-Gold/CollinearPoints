package goodPackage;


import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class Main {
	private static Point[] points;
	private static final int NUM_OF_POINTS = 300;
	private static Random rng;
	private static BruteCollinearPoints brute;
	private static FastCollinearPoints fast;
	private static Scanner scanner;
	public static void main (String[] args) {
         StdDraw.setXscale(0, 32768);
         StdDraw.setYscale(0, 32768);
         StdDraw.setPenRadius(0.005);
         StdDraw.setPenColor(StdDraw.BLACK);
         rng = new Random();
         scanner = new Scanner(System.in);
         points = new Point[NUM_OF_POINTS];
         
         for (int i = 0; i < NUM_OF_POINTS; i++) {
        	 int x = rng.nextInt(1000) * 32;
        	 int y = rng.nextInt(1000) * 32;
        	 points[i] = new Point(x, y);
        	 points[i].draw();
         }

         brute = new BruteCollinearPoints(points);
         System.out.println("BCP says there are " + brute.numberOfSegments() + " sets of 4 collinear points.");
         System.out.println("Would you like to see them? Type \"yes\"");
         if(scanner.next().equals("yes")) {
        	 StdDraw.setPenColor(StdDraw.RED);
        	 for(LineSegment segment : brute.segments()) {
        		 segment.draw();
        	 }
         }
         fast = new FastCollinearPoints(points);
         System.out.println("FCP says there are " + fast.numberOfSegments() + " sets of 4 collinear points.");
         System.out.println("Would you like to see them? Type \"yes\"");
         if(scanner.next().equals("yes")) {
        	 StdDraw.setPenColor(StdDraw.BLUE);
        	 for(LineSegment segment : fast.segments()) {
        		 segment.draw();
        	 }
         }
	}
}
