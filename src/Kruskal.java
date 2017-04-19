import java.util.Scanner;

public class Kruskal {
    private int parent[] = new int[10];

    private int find(int m) {
        int p = m;
        while (parent[p] != 0)
            p = parent[p];
        return p;
    }

    private void union(int i, int j) {
        if (i < j)
            parent[i] = j;
        else
            parent[j] = i;
    }

    private void kruskal(int[][] a, int n) {
        int u = 0, v = 0, min, k = 0, i, j, sum = 0;
        while (k < n - 1) {
            min = 99;
            for (i = 1; i <= n; i++)
                for (j = 1; j <= n; j++)
                    if (a[i][j] < min && i != j) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
            i = find(u);
            j = find(v);
            if (i != j) {
                union(i, j);
                System.out.println("Minimum Edge is :(" + u + "," + v + ")" + " and cost is " + a[u][v]);
                sum = sum + a[u][v];
                k++;
            }
            a[u][v] = a[v][u] = 99;
        }
        System.out.println("Cost of Minimum Spanning Tree = " + sum);
    }

    public static void main(String[] args) {
        int a[][] = new int[10][10];
        int i, j;
        System.out.println("Number of Vertices of the Graph :");
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println("Enter the Weighted Matrix :");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        Kruskal k = new Kruskal();
        k.kruskal(a, n);
        sc.close();
    }
}