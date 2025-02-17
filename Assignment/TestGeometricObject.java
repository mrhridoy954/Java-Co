public class TestGeometricObject {
  public static void main(String[] args) {
    Circle C = new Circle(5.0);
    Rectangle R = new Rectangle(4.0, 6.0);
    Triangle T = new Triangle(3.0, 4.0, 5.0);

    System.out.println("Circle Area: " + C.getArea());
    System.out.println("Circle Perimeter: " + C.getPerimeter());

    System.out.println("Rectangle Area: " + R.getArea());
    System.out.println("Rectangle Perimeter: " + R.getPerimeter());

    System.out.println("Triangle Area: " + T.getArea());
    System.out.println("Triangle Perimeter: " + T.getPerimeter());

    System.out.println("The area of Circle and Rectangle are same? " +
            Triangle.SameArea(C, R, T));

    System.out.println("The area of Circle and Triangle are same? " +
            Triangle.SameArea(C, T, R));

    System.out.println("the area of Rectangle and Triangle are same? " +
            Triangle.SameArea(R, T, C));
  }
}
