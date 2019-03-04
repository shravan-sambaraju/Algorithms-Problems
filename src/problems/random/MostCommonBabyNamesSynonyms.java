package problems.random;

/* FInd most common baby name synonyms */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

class MostCommonBabyNamesSynonyms {

    private static Graph constructGraph(HashMap<String, Integer> names) {
        MostCommonBabyNamesSynonyms mb = new MostCommonBabyNamesSynonyms();
        Graph graph = mb.new Graph();
        for (Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            graph.createNode(name, frequency);
        }
        return graph;
    }

    private static void connectEdges(Graph graph, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            graph.addEdge(name1, name2);
        }
    }

    private static int getComponentFrequency(GraphNode node) {
        if (node.isVisited()) {
            return 0;
        }
        node.setIsVisited(true);
        int sum = node.getFrequency();
        for (GraphNode child : node.getNeighbors()) {
            sum += getComponentFrequency(child);
        }
        return sum;
    }

    private static HashMap<String, Integer> getTrueFrequencies(Graph graph) {
        HashMap<String, Integer> rootNames = new HashMap<String, Integer>();
        for (GraphNode node : graph.getNodes()) {
            if (!node.isVisited()) {
                int frequency = getComponentFrequency(node);
                String name = node.getName();
                rootNames.put(name, frequency);
            }
        }
        return rootNames;
    }

    private static HashMap<String, Integer> trulyMostPopular(
        HashMap<String, Integer> names, String[][] synonyms) {
        Graph graph = constructGraph(names);
        connectEdges(graph, synonyms);
        HashMap<String, Integer> rootNames = getTrueFrequencies(graph);
        return rootNames;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> names = new HashMap<String, Integer>();

        names.put("John", 3);
        names.put("Jonathan", 4);
        names.put("Johnny", 5);
        names.put("Chris", 1);
        names.put("Kris", 3);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms = {
            {"John", "Jonathan"}, {"Jonathan", "Johnny"}, {"Chris", "Kris"}, {"Brian", "Bryan"}
        };

        HashMap<String, Integer> rootNames = trulyMostPopular(names, synonyms);
        for (Entry<String, Integer> entry : rootNames.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(name + ": " + frequency);
        }
    }

    private class Graph {
        private ArrayList<GraphNode> nodes;
        private HashMap<String, GraphNode> map;

        public Graph() {
            map = new HashMap<String, GraphNode>();
            nodes = new ArrayList<GraphNode>();
        }

        private boolean hasNode(String name) {
            return map.containsKey(name);
        }

        private GraphNode createNode(String name, int freq) {
            if (map.containsKey(name)) {
                return getNode(name);
            }

            GraphNode node = new GraphNode(name, freq);
            nodes.add(node);
            map.put(name, node);
            return node;
        }

        private GraphNode getNode(String name) {
            return map.get(name);
        }

        private ArrayList<GraphNode> getNodes() {
            return nodes;
        }

        private void addEdge(String startName, String endName) {
            GraphNode start = getNode(startName);
            GraphNode end = getNode(endName);
            if (start != null && end != null) {
                start.addNeighbor(end);
                end.addNeighbor(start);
            }
        }
    }

    private class GraphNode {
        private ArrayList<GraphNode> neighbors;
        private HashMap<String, GraphNode> map;
        private String name;
        private int frequency;
        private boolean visited = false;

        public GraphNode(String nm, int freq) {
            name = nm;
            frequency = freq;
            neighbors = new ArrayList<GraphNode>();
            map = new HashMap<String, GraphNode>();
        }

        private String getName() {
            return name;
        }

        private int getFrequency() {
            return frequency;
        }

        private boolean addNeighbor(GraphNode node) {
            if (map.containsKey(node.getName())) {
                return false;
            }
            neighbors.add(node);
            map.put(node.getName(), node);
            return true;
        }

        private ArrayList<GraphNode> getNeighbors() {
            return neighbors;
        }

        private boolean isVisited() {
            return visited;
        }

        private void setIsVisited(boolean v) {
            visited = v;
        }
    }

    private class NameSet {
        private Set<String> names = new HashSet<String>();
        private int frequency = 0;
        private String rootName;

        public NameSet(String name, int freq) {
            names.add(name);
            frequency = freq;
            rootName = name;
        }

        private Set<String> getNames() {
            return names;
        }

        private String getRootName() {
            return rootName;
        }

        private void copyNamesWithFrequency(Set<String> more, int freq) {
            names.addAll(more);
            frequency += freq;
        }

        private int getFrequency() {
            return frequency;
        }

        private int size() {
            return names.size();
        }
    }
}
