package com.example._3miniprojectreviewcourse.model;

public class Edge {
    private Vertex start;
    private Vertex end;
    private int weight;

    public Edge() {
    }

    public Edge(int weight, Vertex end, Vertex start) {
        this.weight = weight;
        this.end = end;
        this.start = start;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge " + start.getId() + end.getId() + " = " + weight;
    }
}
