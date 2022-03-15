import java.util.Scanner;

public class CircleWithException {
    private double radius = 1.;

    public void SetRadius(double d){
        if(d <= 0.)
            throw new IllegalArgumentException("Radius should be larger then 0!!!");
        radius = d;
    }
    public double GetRadius() {
        return radius;
    }
    public double GetArea() throws Exception {
        Double area = Math.PI * Math.pow(radius, 2);
        if(area > 1000)
            throw new Exception("Exception");
        return area;
    }
    public double GetDiameter() {
        return 2 * radius;
    }


    public static void main(String[] arg)
    {
        Scanner s = new Scanner(System.in);
        CircleWithException c = new CircleWithException();
        String in = "";

        while (true)
        {
            try {
                System.out.println("Enter a radius to find the area and diameter");
                System.out.print("or \"exit\" to terminate this program \n>:");
                in = s.nextLine();
                c.SetRadius(Double.parseDouble(in));

                System.out.println("Radius  : " + c.GetRadius());
                System.out.println("Area    : " + c.GetArea());
                System.out.println("Diameter: " + c.GetDiameter() + "\n");
            }
            catch (NumberFormatException e) {
                if (in.equals("exit")) {
                    System.out.println("Goodbye world");
                    break;
                }
                else
                    System.out.println("Non-number input\n");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
