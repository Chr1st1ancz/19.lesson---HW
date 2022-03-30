import java.util.Arrays;
import java.util.Scanner;

public class Main {
         static class Point
        {
            int x;
            int y;
        }
            private boolean CCW(Point p, Point q, Point r)
            {
                int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

                if (val >= 0)
                    return false;
                return true;
            }
            public void convexHull(Point[] points)
            {
                int n = points.length;
                if (n < 3)
                    return;
                int[] next = new int[n];
                Arrays.fill(next, -1);

                int leftMost = 0;
                for (int i = 1; i < n; i++)
                    if (points[i].x < points[leftMost].x)
                        leftMost = i;
                int p = leftMost, q;
                do
                {
                    q = (p + 1) % n;
                    for (int i = 0; i < n; i++)
                        if (CCW(points[p], points[i], points[q]))
                            q = i;

                    next[p] = q;
                    p = q;
                } while (p != leftMost);

                display(points, next);
            }

    static int CrossProduct(int A[][])
    {

        int X1 = (A[1][0] - A[0][0]);

        int Y1 = (A[1][1] - A[0][1]);

        int X2 = (A[2][0] - A[0][0]);

        int Y2 = (A[2][1] - A[0][1]);

        return (X1 * Y2 - Y1 * X2);
    }

            public static void main (String[] args)
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("Jarvis Algorithm Test\n");

                Main j = new Main();

                System.out.println("Enter number of points n :");
                int n = scan.nextInt();
                Point[] points = new Point[n];
                System.out.println("Enter "+ n +" x, y cordinates");
                for (int i = 0; i < n; i++)
                {
                    points[i] = new Point();
                    points[i].x = scan.nextInt();
                    points[i].y = scan.nextInt();
                }

                j.convexHull(points);
            }
    public static void display(Point[] points, int[] next)
    {
        System.out.println("\nConvex Hull points : ");
        int N = next.length;
        int prev = 0;
        int curr = 0;
        for (int i = 0; i < next.length; i++) {
            if (next[i] != -1) {
              int[][] pointz = new int[points[i].x][points[i].y];

               int temp[][] = {pointz[i],
                      pointz[(i + 1) % N],
                     pointz[(i + 2) % N]};
                curr = CrossProduct(temp);
                if (curr != 0) {

                    if (curr * prev < 0) {
                        System.out.println("No");
                    } else {
                        prev = curr;
                    }
                }
            }
        }
        System.out.println("Yes");
    }


        }

