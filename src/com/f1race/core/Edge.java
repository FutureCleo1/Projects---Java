package com.f1race.core;

public class Edge {
    public String destination;
    public int weight;
    /*************************************************************************
    Name: Edge
    Parameters: String destination, int weight
    Purpose: Constructor for Edge class to initialize destination and weight
    *************************************************************************/
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
