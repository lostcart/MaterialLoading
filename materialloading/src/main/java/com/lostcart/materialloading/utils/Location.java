package com.lostcart.materialloading.utils;

public class Location {
    private float x;
    private float y;

    public Location(float x, float y) {
        set(x, y);
    }

    public void set(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
