import java.util.*;
public class FastCollinearPoints {
    private int numberOfSegments;
    public FastCollinearPoints(Point[] points){
        double[] slopes;
        for(int i = 0; i<points.length-1; i++){
            Point p = points[i];
            Comparator<Point> c = p.slopeOrder();
            Arrays.sort(points, c);
            slopes = new double[points.length-i];
            slopes[i] = p.slopeTo(points[i]);
            for(int j = i+1; j<points.length; j++){
                double currentSlope = slopes[j];
               
                }
            }
        }
    }
    public int numberOfSegments(){
        return numberOfSegments;
    }
    public LineSegment[] segments(){
        return null;
    }
}
