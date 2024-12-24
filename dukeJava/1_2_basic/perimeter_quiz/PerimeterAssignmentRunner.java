import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
  public double getPerimeter(Shape s) {
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

  public int getNumPoints(Shape s) {
    int counter = 0;
    for (Point i : s.getPoints()) {
      counter = counter + 1;
    }
    return counter;
  }

  public double getAverageLength(Shape s) {
    double length = getPerimeter(s)/getNumPoints(s);
    return length;
  }

  public double getLargestSide(Shape s) {
    double largestSide = 0.0;
    Point prevPt = s.getLastPoint();
    for(Point currPt: s.getPoints()){
        double currDist = prevPt.distance(currPt);
        if(currDist > largestSide){
            largestSide = currDist;
        }
        prevPt = currPt;
    }
    return largestSide;
  }

  public double getLargestX(Shape s) {
    double largestX = Integer.MIN_VALUE;
    for(Point currPt: s.getPoints()){
        if(currPt.getX()>largestX){
            largestX = currPt.getX();
        }
    }
    return largestX;
  }

  public double getLargestPerimeterMultipleFiles() {
    DirectoryResource dr = new DirectoryResource();
    double largestPerimeterFile = 0.0;
    for(File f: dr.selectedFiles()){
        //get filename's file and creat shape
        Shape s = new Shape(new FileResource(f));
        //get file's largest perimeter
        double currPeri = getPerimeter(s);
        //compare to the largest one and choose
        largestPerimeterFile = (largestPerimeterFile >= currPeri) ? largestPerimeterFile : currPeri;
    }
    return largestPerimeterFile;
  }

  public String getFileWithLargestPerimeter() {
    // Put code here
    File temp = null; // replace this code
    double largestPerimeter = 0.0;
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
        Shape s = new Shape(new FileResource(f));
        double currPeri = getPerimeter(s);
        temp = (largestPerimeter <= currPeri) ? f : temp;
        largestPerimeter = (largestPerimeter >= currPeri) ? largestPerimeter : currPeri;
    }
    return temp.getName();
  }

  public void testPerimeter() {
    FileResource fr = new FileResource();
    Shape s = new Shape(fr);
    double length = getPerimeter(s);
    System.out.println("perimeter = " + length);
    int numbers = getNumPoints(s);
    System.out.println("point numbers= " + numbers);
    double averageSideLen = getAverageLength(s);
    System.out.println("average side length = " + averageSideLen);
    double largestSide = getLargestSide(s);
    System.out.println("largest side length = " + largestSide);
    double largestX = getLargestX(s);
    System.out.println("largest X length = " + largestX);
  }

  public void testPerimeterMultipleFiles() {
    double largestPeriInFiles = getLargestPerimeterMultipleFiles();
    System.out.println("largest perimeter among files = " + largestPeriInFiles);
  }

  public void testFileWithLargestPerimeter() {
    String fileWithLargestPeri = getFileWithLargestPerimeter();
    System.out.println("file with the largest perimeter = " + fileWithLargestPeri);
  }

  // This method creates a triangle that you can use to test your other methods
  public void triangle() {
    Shape triangle = new Shape();
    triangle.addPoint(new Point(0, 0));
    triangle.addPoint(new Point(6, 0));
    triangle.addPoint(new Point(3, 6));
    for (Point p : triangle.getPoints()) {
      System.out.println(p);
    }
    double peri = getPerimeter(triangle);
    System.out.println("perimeter = " + peri);
  }

  // This method prints names of all files in a chosen folder that you can use to test your other
  // methods
  public void printFileNames() {
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()) {
      System.out.println(f);
    }
  }

  public static void main(String[] args) {
    PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
    pr.testPerimeter();
  }
}
