package projects;

import java.util.*;

public class Graph {

    private Map<String, List<Edge>> adj = new HashMap<>();
    /********************************************************************
    Name: addNode
    Parameters: String name
    Purpose: Adds a node with the given name to the graph
    *********************************************************************/
    public void addNode(String name) {
        adj.putIfAbsent(name, new ArrayList<>());
    }

    /********************************************************************
    Name: addEdge
    Parameters: String from, String to, int weight
    Purpose: Adds an edge between two nodes with the given weight
    *********************************************************************/  
    public void addEdge(String from, String to, int weight) {
        adj.putIfAbsent(from, new ArrayList<>());
        adj.putIfAbsent(to, new ArrayList<>());
        adj.get(from).add(new Edge(to, weight));
        adj.get(to).add(new Edge(from, weight)); 
    }
    /********************************************************************
    Name: getNeighbors
    Parameters: String node
    Purpose: Returns a list of edges (neighbors) for the given node
    *********************************************************************/
    public List<Edge> getNeighbors(String node) {
        return adj.getOrDefault(node, new ArrayList<>());
    }
    /********************************************************************
    Name: getNodes
    Parameters: none
    Purpose: Returns a set of all nodes in the graph
    *********************************************************************/
    public Set<String> getNodes() {
        return adj.keySet();
    }
}
