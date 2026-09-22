package com.example._3miniprojectreviewcourse.model;

public class Vertex {
    private int id;
    private double x;
    private double y;

    public Vertex() {
    }

    public Vertex(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Vertex(" + id + ", " + x + ", " + y + ')';
    }
}
