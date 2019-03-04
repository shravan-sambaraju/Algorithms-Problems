package problems.random;

/* Given two words in a file count distance between them in terms of words */

import common.utils.HashMapList;

import java.util.ArrayList;

import static common.utils.UtilMethods.getLongTextBlobAsStringList;

class WordDistanceInFile {

    private static HashMapList<String, Integer> getWordLocations(String[] words) {
        HashMapList<String, Integer> locations = new HashMapList<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            locations.put(words[i], i);
        }
        return locations;
    }

    private static LocationPair findMinDistancePair(
        ArrayList<Integer> array1, ArrayList<Integer> array2) {
        if (array1 == null || array2 == null || array1.size() == 0 || array2.size() == 0) {
            return null;
        }

        int index1 = 0;
        int index2 = 0;
        WordDistanceInFile word = new WordDistanceInFile();
        LocationPair best = word.new LocationPair(array1.get(0), array2.get(0));
        LocationPair current = word.new LocationPair(array1.get(0), array2.get(0));

        while (index1 < array1.size() && index2 < array2.size()) {
            current.setLocations(array1.get(index1), array2.get(index2));
            best.updateWithMin(current);
            if (current.location1 < current.location2) {
                index1++;
            } else {
                index2++;
            }
        }

        return best;
    }

    public static LocationPair findClosest(
        String word1, String word2, HashMapList<String, Integer> locations) {
        ArrayList<Integer> locations1 = locations.get(word1);
        ArrayList<Integer> locations2 = locations.get(word2);
        return findMinDistancePair(locations1, locations2);
    }

    public static void main(String[] args) {
        String[] wordlist = getLongTextBlobAsStringList();
        String word1 = "river";
        String word2 = "life";
        HashMapList<String, Integer> locations = getWordLocations(wordlist);
        LocationPair pair = findClosest(word1, word2, locations);
        System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + pair.toString());
    }

    private class LocationPair {
        private int location1;
        private int location2;

        public LocationPair(int first, int second) {
            setLocations(first, second);
        }

        private void setLocations(int first, int second) {
            this.location1 = first;
            this.location2 = second;
        }

        private void setLocations(LocationPair loc) {
            setLocations(loc.location1, loc.location2);
        }

        private int distance() {
            return Math.abs(location1 - location2);
        }

        private boolean isValid() {
            return location1 >= 0 && location2 >= 0;
        }

        private void updateWithMin(LocationPair loc) {
            if (!isValid() || loc.distance() < distance()) {
                setLocations(loc);
            }
        }

        @Override
        public String toString() {
            return "(" + location1 + ", " + location2 + ")";
        }
    }
}
