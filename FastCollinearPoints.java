package goodPackage;

import java.util.*;
public class FastCollinearPoints {
    private int numberOfSegments;
    private ArrayList<LineSegment> lineSegments;
    public FastCollinearPoints(Point[] points){
        Point[] copy;
        lineSegments = new ArrayList<LineSegment>();
        for(int i = 0; i<points.length; i++){
            Point p = points[i];
            Comparator<Point> c = p.slopeOrder();
            copy = Arrays.copyOf(points, points.length);
            Arrays.sort(copy, c);
            for(int j = 0; j<points.length-2; j++){
                    double slopeOne = p.slopeTo(copy[j+1]);
                    double slopeTwo = p.slopeTo(copy[j+2]);
                    double slopeThree = p.slopeTo(copy[j+3]);
                    
                    //TODO Fix this
                    if(slopeOne == slopeTwo &&
                            slopeTwo == slopeThree){
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
