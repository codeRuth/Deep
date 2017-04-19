import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Floyd f=new Floyd();
        int a[][] = new int[10][10];
        int i, j;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices: ");
        int n = in.nextInt();
        System.out.println("Enter the Adjacency Matrix");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                a[i][j] = in.nextInt();

        System.out.println("Entered Adjacency Matrix is: ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        f.floyd(a, n);
        System.out.println("All pair Shortest Path Matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++)
                System.out.print(a[i][j] + "\t");
            System.out.println();
        }
    }

    private void floyd(int a[][], int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    a[i][j] = min(a[i][j], a[i][k] + a[k][j]);
        }
    }

    private int min(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
    }
}