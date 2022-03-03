import java.util.ArrayList;

public class BruteCollinearPoints {
	private int numberOfSegments;
	private ArrayList<LineSegment> segments;
	
	//finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		numberOfSegments = 0;
		segments = new ArrayList<LineSegment>();
		for(int i = 0; i < points.length - 3; i++) {
			for(int j = i + 1; j < points.length - 2; j++) {
				for (int k = j + 1; k < points.length - 1; k++) {
					for (int l = k + 1; l < points.length; l++) {
						if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) && points[i].slopeTo(points[k]) == points[i].slopeTo(points[l])){
							numberOfSegments++;
							Point point1 = points[i];
							Point point2 = points[i];
							if(point1.compareTo(points[j]) < 0) {
								point1 = points[i];
							}
							if(point1.compareTo(points[k]) < 0) {
								point1 = points[k];
							}
							if(point1.compareTo(points[l]) < 0) {
								point1 = points[l];
							}
							if(point2.compareTo(points[j]) > 0) {
								point2 = points[j];
							}
							if(point2.compareTo(points[k]) > 0) {
								point2 = points[k];
							}
							if(point2.compareTo(points[l]) > 0) {
								point2 = points[l];
							}
							
							segments.add(new LineSegment(point1, point2));
						}
					}
				}
			}
		}
	}
	
	public int numberOfSegments() {
		return numberOfSegments;
		
	}
	
	public ArrayList<LineSegment> segments() {
		return segments;
	}
}
