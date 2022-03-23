import java.util.*;
public class BruteCollinearPoints {
    private int numberOfSegments;
    private ArrayList<LineSegment> lineSegments;
    public BruteCollinearPoints(Point[] points){
        this.numberOfSegments = 0;
        this.lineSegments = new ArrayList<LineSegment>();
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                for(int k = j+1; k<points.length; k++){
                    for(int l = k+1; l<points.length; l++){
                        boolean alreadyThere = false;
                        if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&
                                points[i].slopeTo(points[k]) == points[i].slopeTo(points[l])){
                            LineSegment seg = new LineSegment(firstPoint(points[i], points[k], points[l], points[j]), lastPoint(points[i], points[k], points[l], points[j]));
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
