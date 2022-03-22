import java.util.*;
public class FastCollinearPoints {
    private int numberOfSegments;
    private ArrayList<LineSegment> lineSegments;
    public FastCollinearPoints(Point[] points){
        Point[] copy;
        LineSegment[] used;
        lineSegments = new ArrayList<LineSegment>();
        for(int i = 0; i<points.length; i++){
            Point p = points[i];
            Comparator<Point> c = p.slopeOrder();
            copy = Arrays.copyOf(points, points.length);
            Arrays.sort(copy, c);
            for(int j = 1; j<points.length-2; j++){
                boolean alreadyThere = false;
                    double slopeOne = p.slopeTo(copy[j]);
                    double slopeTwo = p.slopeTo(copy[j+1]);
                    double slopeThree = p.slopeTo(copy[j+2]);
                    if(slopeOne == slopeTwo &&
                            slopeTwo == slopeThree){
                        LineSegment seg = new LineSegment (firstPoint(p, copy[j], copy[j+1], copy[j+2]), lastPoint(p, copy[j], copy[j+1], copy[j+2]));
                        for(LineSegment s : lineSegments){
                            if(s.equals(seg)){
                                alreadyThere = true;
                            }
                        }
                        if(!alreadyThere){
                            lineSegments.add(seg);
                            numberOfSegments++;
                        }
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
    public Point firstPoint(Point a, Point b, Point c, Point d){
        if(a.compareTo(b)<0 && a.compareTo(c)<0 && a.compareTo(d)<0){
            return a;
        }
        if(b.compareTo(a)<0 && b.compareTo(c)<0 && b.compareTo(d)<0){
            return b;
        }
        if(c.compareTo(a)<0 && c.compareTo(b)<0 && c.compareTo(d)<0){
            return c;
        }
        if(d.compareTo(a)<0 && d.compareTo(b)<0 && d.compareTo(c)<0){
            return d;
        }
        return a;
    }
    public Point lastPoint(Point a, Point b, Point c, Point d){
        if(a.compareTo(b)>0 && a.compareTo(c)>0 && a.compareTo(d)>0){
            return a;
        }
        if(b.compareTo(a)>0 && b.compareTo(c)>0 && b.compareTo(d)>0){
            return b;
        }
        if(c.compareTo(a)>0 && c.compareTo(b)>0 && c.compareTo(d)>0){
            return c;
        }
        if(d.compareTo(a)>0 && d.compareTo(b)>0 && d.compareTo(c)>0){
            return d;
        }
        return a;
    }
}
