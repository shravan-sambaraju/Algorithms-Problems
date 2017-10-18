package problems.random;

 class Line2 {
	public Point1 start;
	public Point1 end;
	public Line2(Point1 start, Point1 end) {
		this.start = start;
		this.end = end;
	}
	
	public String toString() {
		return "Line2 from " + start.toString() + " to " + end.toString();
	}
}
 
 class Point1 {
		public double x;
		public double y;
		public Point1(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean isEqual(Point1 p) {
			return (p.x == x && p.y == y);
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

public class BisectSquares {
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void printLine2(Line2 l) {
		System.out.println(l.start.x + "\t" + l.start.y);
		System.out.println(l.end.x + "\t" + l.end.y);
	}
	
	public static void printSquare(Square s) {
		System.out.println(s.left + "\t" + s.top + "\t" + s.size);
	}	
	
	public static boolean isApproxEqual(double d1, double d2) {
		double epsilon = .001;	
		if (Math.abs(d1 - d2) < epsilon) {
			return true;
		}
		return false;
	}
	
	public static boolean isApproxEqual(Point1 p1, Point1 p2) {
		return isApproxEqual(p1.x, p2.x) && isApproxEqual(p1.y, p2.y); 
	}
	
	public static boolean doTest(Square s1, Square s2, Point1 start, Point1 end) {
		Line2 Line2 = s1.cut(s2);
		boolean r = (isApproxEqual(Line2.start, start) && isApproxEqual(Line2.end, end)) || (isApproxEqual(Line2.start, end) && isApproxEqual(Line2.end, start));
		if (!r) {
			printSquare(s1);
			printSquare(s2);
			printLine2(Line2);
			System.out.println(start.toString());
			System.out.println(end.toString());
			System.out.println();
			return r;
		}
		return r;
	}
	
	public static boolean doTestFull(Square s1, Square s2, Point1 start, Point1 end) {
		return doTest(s1, s2, start, end) && doTest(s2, s1, start, end);
	}
	
	public static void doTests() {
		// Equal
		doTestFull(new Square(1, 1, 5), new Square(1, 1, 5), new Point1(3.5, 1), new Point1(3.5, 6));	
		
		// Concentric
		doTestFull(new Square(1, 1, 5), new Square(2, 2, 3), new Point1(3.5, 1), new Point1(3.5, 6));
		
		// Partially overlapping -- side by side
		doTestFull(new Square(10, 10, 10), new Square(8, 10, 10), new Point1(8, 15), new Point1(20, 15));
		
		// Partially overlapping -- corners
		doTestFull(new Square(10, 10, 10), new Square(8, 7, 7), new Point1(8.777777, 7), new Point1(18.8888888, 20));		
		
		// Partially overlapping -- on top of each other
		doTestFull(new Square(10, 10, 10), new Square(8, 7, 15), new Point1(8, 22), new Point1(23, 7));		
		
		// Not overlapping -- side by side
		doTestFull(new Square(10, 10, 10), new Square(19, 25, 4), new Point1(12.5, 10), new Point1(22, 29));				
		
		// Not overlapping -- on top of each other
		doTestFull(new Square(10, 10, 10), new Square(4, 4, 3), new Point1(4, 4), new Point1(20, 20));		
		
		// Contained
		doTestFull(new Square(10, 10, 10), new Square(12, 14, 3), new Point1(10, 16.66666), new Point1(20, 13.333));			
	}
	
	public static void main(String[] args) {
		/* For an easy way to test these, open up Square Cut Tester.xlsx
		 * in the Chapter 7, Problem 5 folder. Copy and paste the exact 
		 * output from below into the file (including all tabs).
		 */
		doTests();
	}

}

class Square {
	public double left;
	public double top;
	public double bottom;
	public double right;
	public double size;
	public Square(double left, double top, double size) {
		this.left = left;
		this.top = top;
		this.bottom = top + size;
		this.right = left + size;
		this.size = size;
	}
	
	public Point1 middle() {
		return new Point1((this.left + this.right)/2.0, (this.top + this.bottom)/2.0);
	}
	
	public boolean contains(Square other) {
		if (this.left <= other.left && this.right >= other.right && this.top <= other.top && this.bottom >= other.bottom) {
			return true;
		}
		return false;
	}
	
	/* Return the Point1 where the Line2 segment connecting mid1 and
	 * mid2 intercepts the edge of square 1. That is, draw a Line2 
	 * from mid2 to mid1, and continue it out until the edge of
	 * the square. */
	public Point1 extend(Point1 mid1, Point1 mid2, double size) {
		/* Find what direction the Line2 mid2 -> mid1 goes */
		double xdir = mid1.x < mid2.x ? -1 : 1;
		double ydir = mid1.y < mid2.y ? -1 : 1;
		
		/* If mid1 and mid2 have the same x value, then the slope
		 * calculation will throw a divide by 0 exception. So, we
		 * compute this specially. */
		if (mid1.x == mid2.x) {
			return new Point1(mid1.x, mid1.y + ydir * size / 2.0);
		}
		double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);
		double x1 = 0;
		double y1 = 0;
		
		/* Calculate slope using the equation (y1 - y2) / (x1 - x2).
		 * Note: if the slope is �steep� (>1) then the end of the
		 * Line2 segment will hit size / 2 units away from the middle
		 * on the y axis. If the slope is �shallow� (<1) the end of
		 * the Line2 segment will hit size / 2 units away from the
		 * middle on the x axis. */
		if (Math.abs(slope) == 1) {
			x1 = mid1.x + xdir * size / 2.0;
			y1 = mid1.y + ydir * size / 2.0;
		} else if (Math.abs(slope) < 1) {
			x1 = mid1.x + xdir * size / 2.0;
			y1 = slope * (x1 - mid1.x) + mid1.y; 
		} else {
			y1 = mid1.y + ydir * size / 2.0;
			x1 = (y1 - mid1.y) / slope + mid1.x;
		}
		return new Point1(x1, y1);
	}
	
	public Line2 cut(Square other) {
		/* Calculate where a Line2 between each middle would collide with the edges of the squares */
		Point1 p1 = extend(this.middle(), other.middle(), this.size);
		Point1 p2 = extend(this.middle(), other.middle(), -1 * this.size);
		Point1 p3 = extend(other.middle(), this.middle(), other.size);
		Point1 p4 = extend(other.middle(), this.middle(), -1 * other.size);
	
		/* Of above Point1s, find start and end of Line2s. Start is farthest left (with top most as a tie breaker)
		 * and end is farthest right (with bottom most as a tie breaker */
		Point1 start = p1;
		Point1 end = p1;		
		Point1[] Point1s = {p2, p3, p4};
		for (int i = 0; i < Point1s.length; i++) {
			if (Point1s[i].x < start.x || (Point1s[i].x == start.x && Point1s[i].y < start.y)) {
				start = Point1s[i];
			} else if (Point1s[i].x > end.x || (Point1s[i].x == end.x && Point1s[i].y > end.y)) {
				end = Point1s[i];
			}
		}
			
		return new Line2(start, end);
	}
	
	public String toString() {
		return "(" + left + ", " + top + ")|(" + right + "," + bottom + ")";
	}
}