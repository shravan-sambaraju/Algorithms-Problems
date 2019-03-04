package problems.graphs;

/* Print build order */

import java.util.ArrayList;
import java.util.HashMap;

class BuildOrder {

  private static Graph buildGraph(String[] projects, String[][] dependencies) {
    BuildOrder buildOrder = new BuildOrder();
    Graph graph = buildOrder.new Graph();
    for (String project : projects) {
      graph.getOrCreateNode(project);
    }

    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }
    return graph;
  }

  private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
    for (Project project : projects) {
      if (project.getNumberDependencies() == 0) {
        order[offset] = project;
        offset++;
      }
    }
    return offset;
  }

  private static Project[] orderProjects(ArrayList<Project> projects) {
    Project[] order = new Project[projects.size()];

    int endOfList = addNonDependent(order, projects, 0);

    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      Project current = order[toBeProcessed];
      if (current == null) {
        return null;
      }

      ArrayList<Project> children = current.getChildren();
      for (Project child : children) {
        child.decrementDependencies();
      }
      endOfList = addNonDependent(order, children, endOfList);
      toBeProcessed++;
    }
    return order;
  }

  private static String[] convertToStringList(Project[] projects) {
    String[] buildOrder = new String[projects.length];
    for (int i = 0; i < projects.length; i++) {
      buildOrder[i] = projects[i].getName();
    }
    return buildOrder;
  }

  private static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects(graph.getNodes());
  }

  private static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
    Project[] buildOrder = findBuildOrder(projects, dependencies);
    if (buildOrder == null) {
      return null;
    }
    String[] buildOrderString = convertToStringList(buildOrder);
    return buildOrderString;
  }

  public static void main(String[] args) {
    String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    String[][] dependencies = {
      {"a", "b"},
      {"b", "c"},
      {"a", "c"},
      {"a", "c"},
      {"d", "e"},
      {"b", "d"},
      {"e", "f"},
      {"a", "f"},
      {"h", "i"},
      {"h", "j"},
      {"i", "j"},
      {"g", "j"}
    };
    String[] buildOrder = buildOrderWrapper(projects, dependencies);
    if (buildOrder == null) {
      System.out.println("Circular Dependency.");
    } else {
      for (String s : buildOrder) {
        System.out.println(s);
      }
    }
  }

  private class Graph {
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();

    private Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        nodes.add(node);
        map.put(name, node);
      }
      return map.get(name);
    }

    private void addEdge(String startName, String endName) {
      Project start = getOrCreateNode(startName);
      Project end = getOrCreateNode(endName);
      start.addNeighbor(end);
    }

    private ArrayList<Project> getNodes() {
      return nodes;
    }
  }

  private class Project {
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;

    public Project(String n) {
      name = n;
    }

    private String getName() {
      return name;
    }

    private void addNeighbor(Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
        node.incrementDependencies();
      }
    }

    private void incrementDependencies() {
      dependencies++;
    }

    private ArrayList<Project> getChildren() {
      return children;
    }

    private void decrementDependencies() {
      dependencies--;
    }

    private int getNumberDependencies() {
      return dependencies;
    }
  }
}
