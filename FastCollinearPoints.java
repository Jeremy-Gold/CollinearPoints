import java.util.*;
public class FastCollinearPoints {
    private int numberOfSegments;
    private ArrayList<LineSegment> lineSegments;
    public FastCollinearPoints(Point[] points){
        Point[] copy;
        lineSegments = new ArrayList<LineSegment>();
        for(int i = 0; i<points.length-1; i++){
            Point p = points[i];
            Comparator<Point> c = p.slopeOrder();
            copy = points;
            Arrays.sort(copy, c);
            for(int j = i+1; j<points.length-3; j++){
                    double slopePlusOne = p.slopeTo(copy[j+1]);
                    double slopePlusTwo = p.slopeTo(copy[j+2]);
                    double slopePlusThree = p.slopeTo(copy[j+3]);
                    if(slopePlusOne == slopePlusTwo &&
                            slopePlusTwo == slopePlusThree){
                        numberOfSegments++;
                        lineSegments.add(new LineSegment (p, copy[j+3]));
                    }
            }
        }
    }
    public int numberOfSegments(){
        return numberOfSegments;
    }
    public ArrayList<LineSegment> segments(){
        return lineSegments;
    }
}
