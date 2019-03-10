package problems.random;

import common.utils.HashMapList;

import java.util.ArrayList;
import java.util.Set;

/**
 * Given a two-dimensional graph with points on it, find a line which passes the most number of
 * points.
 */
class LinePassingMaxPointsOnGraph {

  private static Line findBestLine(GraphPoint[] points) {
    HashMapList<Double, Line> linesBySlope = getListOfLines(points);
    return getBestLine(linesBySlope);
  }

  private static HashMapList<Double, Line> getListOfLines(GraphPoint[] points) {
    HashMapList<Double, Line> linesBySlope = new HashMapList<Double, Line>();
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        Line line = new Line(points[i], points[j]);
        double key = Line.floorToNearestEpsilon(line.slope);
        linesBySlope.put(key, line);
      }
    }
    return linesBySlope;
  }

  private static Line getBestLine(HashMapList<Double, Line> linesBySlope) {
    Line bestLine = null;
    int bestCount = 0;

    Set<Double> slopes = linesBySlope.keySet();

    for (double slope : slopes) {
      ArrayList<Line> lines = linesBySlope.get(slope);
      for (Line line : lines) {
        int count = countEquivalentLines(linesBySlope, line);
        if (count > bestCount) {
          bestLine = line;
          bestCount = count;
          bestLine.Print();
          System.out.println(bestCount);
        }
      }
    }
    return bestLine;
  }

  private static int countEquivalentLines(HashMapList<Double, Line> linesBySlope, Line line) {
    double key = Line.floorToNearestEpsilon(line.slope);
    int count = countEquivalentLines(linesBySlope.get(key), line);
    count += countEquivalentLines(linesBySlope.get(key - Line.epsilon), line);
    count += countEquivalentLines(linesBySlope.get(key + Line.epsilon), line);
    return count;
  }

  private static int countEquivalentLines(ArrayList<Line> lines, Line line) {
    if (lines == null) {
      return 0;
    }
    int count = 0;
    for (Line parallelLine : lines) {
      if (parallelLine.isEquivalent(line)) {
        count++;
      }
    }
    return count;
  }

  private static GraphPoint[] createPoints() {
    int n_points = 100;
    System.out.println("Points on Graph\n***************");
    LinePassingMaxPointsOnGraph linePassingMaxPointsOnGraph = new LinePassingMaxPointsOnGraph();
    GraphPoint[] points = new GraphPoint[n_points - 1];
    for (int i = 0; i < n_points / 2; i++) {
      GraphPoint p = linePassingMaxPointsOnGraph.new GraphPoint(i, 2.3 * ((double) i) + 20.0);
      points[i] = p;
      System.out.println(p.toString());
    }
    for (int i = 0; i < n_points / 2 - 1; i++) {
      GraphPoint p = linePassingMaxPointsOnGraph.new GraphPoint(i, 3.0 * ((double) i) + 1.0);
      points[n_points / 2 + i] = p;
      System.out.println(p.toString());
    }
    System.out.println("****************\n");
    return points;
  }

  private static int validate(Line line, GraphPoint[] points) {
    int count = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        Line other = new Line(points[i], points[j]);
        if (line.isEquivalent(other)) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    GraphPoint[] points = createPoints();
    Line line = findBestLine(points);
    line.Print();
    System.out.println(validate(line, points));
  }

  static class Line {
    private static double epsilon = .5;
    private double slope;
    private double intercept;

    private boolean infinite_slope = false;

    public Line(GraphPoint p, GraphPoint q) {
      if (Math.abs(p.x - q.x) > epsilon) {
        slope = (p.y - q.y) / (p.x - q.x);
        intercept = p.y - slope * p.x;
      } else {
        infinite_slope = true;
        intercept = p.x;
      }
    }

    private static double floorToNearestEpsilon(double d) {
      int r = (int) (d / epsilon);
      return ((double) r) * epsilon;
    }

    private boolean isEquivalent(double a, double b) {
      return (Math.abs(a - b) < epsilon);
    }

    private void Print() {
      System.out.println("y = " + slope + "x + " + intercept);
    }

    private boolean isEquivalent(Object o) {
      Line l = (Line) o;
      if (isEquivalent(l.slope, slope)
          && isEquivalent(l.intercept, intercept)
          && (infinite_slope == l.infinite_slope)) {
        return true;
      }
      return false;
    }
  }

  private class GraphPoint {
    private double x;
    private double y;

    public GraphPoint(double x1, double y1) {
      x = x1;
      y = y1;
    }

    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
}
