package problems.random;

/**
 * Given a list of people with their birth and death years, implement a method to compute the year
 * with the most number of people alive. You may assume that all people were born between 1900 and
 * 2000 (inclusive). Ifa person was alive during any portion of that year, they should be included
 * in that year'scount. For example, Person (birth =1908, death =1909) is included in the counts for
 * both 1908 and 1909.
 */
import java.util.Random;

class LivingPeopleInYear {

  private static int maxAliveYear(Person[] people, int min, int max) {
    int[] populationDeltas = getPopulationDeltas(people, min, max);
    int maxAliveYear = getMaxAliveYear(populationDeltas);
    return maxAliveYear + min;
  }

  private static int[] getPopulationDeltas(Person[] people, int min, int max) {
    int[] populationDeltas = new int[max - min + 2];
    for (Person person : people) {
      int birth = person.birth - min;
      populationDeltas[birth]++;
      int death = person.death - min;
      populationDeltas[death + 1]--;
    }
    return populationDeltas;
  }

  private static int getMaxAliveYear(int[] deltas) {
    int maxAliveYear = 0;
    int maxAlive = 0;
    int currentlyAlive = 0;
    for (int year = 0; year < deltas.length; year++) {
      currentlyAlive += deltas[year];
      if (currentlyAlive > maxAlive) {
        maxAliveYear = year;
        maxAlive = currentlyAlive;
      }
    }
    return maxAliveYear;
  }

  public static void main(String[] args) {
    int n = 3;
    int first = 1900;
    int last = 2000;
    Random random = new Random();
    Person[] people = new Person[n];
    for (int i = 0; i < n; i++) {
      int birth = first + random.nextInt(last - first);
      int death = birth + random.nextInt(last - birth);
      LivingPeopleInYear livingPeopleInYear = new LivingPeopleInYear();
      people[i] = livingPeopleInYear.new Person(birth, death);
      System.out.println(birth + ", " + death);
    }
    int year = maxAliveYear(people, first, last);
    System.out.println(year);
  }

  private class Person {
    private int birth;
    private int death;

    public Person(int birthYear, int deathYear) {
      birth = birthYear;
      death = deathYear;
    }
  }
}
