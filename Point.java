package goodPackage;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
		StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
    	if(this.x != that.x || this.y != that.y) {
    		StdDraw.line(this.x, this.y, that.x, that.y);
    	}
        
    }

    public double slopeTo(Point that) {
    	if(this.y == that.y && this.x == that.x) {
    		return Double.NEGATIVE_INFINITY; 
    	} else if (this.x == that.x) {
    		return Double.POSITIVE_INFINITY;
    	}
    	double num = 1.0*(this.y-that.y);
    	double den = this.x-that.x;
    	double result = num/den;
        return result;
    }
    
    public int compareTo(Point that) {
        if(this.y > that.y || (this.y == that.y && this.x > that.x)) {
        	return 1;
        } else if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
        	return -1;
        }
        return 0;
    }

    public Comparator<Point> slopeOrder() {
       return new SlopeOrderer(this);
    }
    
    private class SlopeOrderer implements Comparator<Point> {
    	Point invoked;
    	
    	public SlopeOrderer (Point invoked) {
    		this.invoked = invoked; 
    	}
    	
		@Override
		public int compare(Point a, Point b) {
			double slopeA = invoked.slopeTo(a);
			double slopeB = invoked.slopeTo(b);
			if(slopeA != slopeB) {
				return Double.compare(slopeA, slopeB);
			} 
			return a.compareTo(b);
		}
    	
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
}
