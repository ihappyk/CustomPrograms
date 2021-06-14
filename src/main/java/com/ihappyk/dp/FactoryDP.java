package com.ihappyk.dp;

interface Shape {
    public void draw();
}

class Circle implements Shape {

    @Override public void draw ()
    {
        System.out.println("Drawing Circle!");
    }
}

class Rectangle implements Shape {

    @Override public void draw ()
    {
        System.out.println("Drawing Rectangle!");
    }
}

class Square implements Shape {

    @Override public void draw ()
    {
        System.out.println("Drawing Square!");
    }
}

class ShapeFactory {
    public static Shape getShapeFactory(String name) {
        Shape shape;
        switch(name) {
        case "CIRCLE":
            shape = new Circle();
            break;
        case "RECTANGLE":
            shape = new Rectangle();
        default:
            shape = null;
        }
        return shape;
    }
}


public class FactoryDP
{
    public static void main(String args[]) {
        Shape shape = ShapeFactory.getShapeFactory("CIRCLE");
        shape.draw();
    }
}
