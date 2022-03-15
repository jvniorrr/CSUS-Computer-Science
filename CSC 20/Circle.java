/*
Name: First Last
Date: 12-10-21
Programming Assignment: Lab 7
*/

public class Circle {
    private int x, y, radius;

    public Circle(int circX, int circY, int circRadius) {
        this.x = circX;
        this.y = circY;
        this.radius = circRadius;
    }
    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius =0;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getRadius() {
        return this.radius;
    }


    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    public double getCircumference() {
        return (Math.PI * (this.radius * 2) );
    }

    public String toString() {
        return String.format("(%d, %d): %d", this.x, this.y, this.radius);
    }

}
