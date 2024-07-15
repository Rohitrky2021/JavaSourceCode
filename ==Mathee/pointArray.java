
    import java.awt.Point;

    public class pointArray {
        public static void main(String[] args) {
            // Creating an array of Point objects
            Point[] pointsArray = new Point[5];
    
            // Initializing each element in the array
            for (int i = 0; i < pointsArray.length; i++) {
                pointsArray[i] = new Point(i, i * 2);
            }
    
            // Accessing elements in the array
            for (Point point : pointsArray) {
                System.out.println("Point: (" + point.getX() + ", " + point.getY() + ")");
            }
        }
    }
    