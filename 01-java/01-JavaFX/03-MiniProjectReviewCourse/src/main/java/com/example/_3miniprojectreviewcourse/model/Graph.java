package com.example._3miniprojectreviewcourse.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
        System.out.println("Vertex added to graph");
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
        System.out.println("Edge added to graph");
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
