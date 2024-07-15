//WAP to print hollow rectange pattern
//like the diagram drawn below
/*
 *  * * * * *
 *  *       *
 *  *       *
 *  * * * * *
 */
public class hollowrectangle {
    public static void hollow_rectange(int totalRows, int totalCols) {
        //outer loop
        for(int i=1; i<=totalRows; i++)
        {
            //inner loop
            for(int j=1; j<=totalCols; j++) 
            {
                //cell- (i,j) i represents row and j represents j
                if(i == 1 || i==totalRows || j == 1 || j == totalCols) 
                {
                    //boundary cells
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollow_rectange(4, 5);
    }
}