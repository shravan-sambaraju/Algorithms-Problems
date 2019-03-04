package problems.random;

/* Find intersection of lines */

class FindIntersectionOfLines {

  private static Point createPoint(int[] coordinates) {
    FindIntersectionOfLines findIntersectionOfLines = new FindIntersectionOfLines();
    return findIntersectionOfLines.new Point(coordinates[0], coordinates[1]);
  }

  private static boolean isBetween(double start, double middle, double end) {
    if (start > end) {
      return end <= middle && middle <= start;
    } else {
      return start <= middle && middle <= end;
    }
  }

  private static boolean isBetween(Point start, Point middle, Point end) {
    return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
  }

  private static void swap(Point one, Point two) {
    double x = one.x;
    double y = one.y;
    one.setLocation(two.x, two.y);
    two.setLocation(x, y);
  }

  private static Point intersection(Point start1, Point end1, Point start2, Point end2) {
    if (start1.x > end1.x) {
      swap(start1, end1);
    }
    if (start2.x > end2.x) {
      swap(start2, end2);
    }
    if (start1.x > start2.x) {
      swap(start1, start2);
      swap(end1, end2);
    }
    FindIntersectionOfLines findIntersectionOfLines = new FindIntersectionOfLines();
    Line line1 = findIntersectionOfLines.new Line(start1, end1);
    Line line2 = findIntersectionOfLines.new Line(start2, end2);

    if (line1.slope == line2.slope) {
      if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
        return start2;
      }
      return null;
    }

    double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
    double y = x * line1.slope + line1.yintercept;
    Point intersection = findIntersectionOfLines.new Point(x, y);

    if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
      return intersection;
    }
    return null;
  }

  public static void main(String[] args) {
    int[][] coordinates = {{8, 8}, {8, 16}, {8, 8}, {8, 17}};
    Point[] points = {
      createPoint(coordinates[0]),
      createPoint(coordinates[1]),
      createPoint(coordinates[2]),
      createPoint(coordinates[3])
    };
    Point intersection = intersection(points[0], points[1], points[2], points[3]);
    if (intersection == null) {
      System.out.println("No intersection.");
    } else {
      System.out.println("Intersection: " + intersection.x + ", " + intersection.y);
    }
  }

  private class Line {
    private double slope;
    private double yintercept;

    public Line(Point start, Point end) {
      double deltaY = end.y - start.y;
      double deltaX = end.x - start.x;
      slope = deltaY / deltaX;
      yintercept = end.y - slope * end.x;
    }

    private void print() {
      System.out.print("y = " + slope + "x + " + yintercept);
    }
  }

  private class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    private void setLocation(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }
}
