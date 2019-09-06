package com.testa.shape;

import edu.duke.*;

import java.util.Iterator;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    public int getNumPoints (Shape s) {
        int numOfPoints = 0;

//        for (Point point : s.getPoints()) {
//            numOfPoints = numOfPoints + 1;
//        }

        Iterator<Point> point = s.getPoints().iterator();
        while (point.hasNext()) {
            numOfPoints = numOfPoints + 1;

            point.next();
        }
        return numOfPoints;
    }
    public double getAverageLength (Shape s){
        double totalLength = 0;
        Point previousPoint = s.getLastPoint();
        Point currPoint = 0;
        Iterator<Point> point = s.getPoints().iterator();
        while (point.hasNext()) {
        totalLength = totalLength + previousPoint.distance(currPoint);
        point.next();
        }

 //       for (Point currPoint : s.getPoints()){
 //           totalLength = totalLength + previousPoint.distance(currPoint);
 //          previousPoint = currPoint;
 //       }
        double average = totalLength / getNumPoints(s);
        return average;
    }


    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int pointsNumber = getNumPoints(s);
        System.out.println("number of points = " + pointsNumber);
        double averageLenth = getAverageLength(s);
        System.out.println("average length " + averageLenth);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();

    }
}
