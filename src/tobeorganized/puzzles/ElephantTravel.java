package tobeorganized.puzzles;

/*
 * Given a total number of sugarcanes, a travel distance, and an elephant's maximum carrying
 * capacity (where the elephant consumes 1 sugarcane per unit of distance traveled), calculate the
 * maximum number of sugarcanes that can be transported to the destination.
 */
public class ElephantTravel {

  public static int calculateMaxsugarCanes(
      int sugarCanes, int travelDistance, int maximumCapacity) {

    int trips = sugarCanes / maximumCapacity * 2 - 1;
    System.out.println(trips + " " + sugarCanes + " " + travelDistance);
    int distanceLeft = travelDistance;
    while (trips > 1) {
      int currentTripLength = 1000 / trips;
      System.out.println("currentTrip " + currentTripLength);
      trips = trips - 2;
      distanceLeft = distanceLeft - currentTripLength;
      System.out.println("distanceLeft " + distanceLeft);
    }

    return 1000 - distanceLeft;
  }

  public static void main(String[] args) {
    System.out.println(calculateMaxsugarCanes(3000, 1000, 1000));
    System.out.println(calculateMaxsugarCanes(5000, 1500, 1000));
  }
}
