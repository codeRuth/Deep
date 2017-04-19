import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Prim p=new Prim();
        int cost[][] = new int[10][10];
        int i, j, minCost = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices :");
        int n = in.nextInt();
        System.out.println("Enter the Cost Matrix :");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                cost[i][j] = in.nextInt();
        System.out.println("The Entered Cost Matrix is :");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.print(cost[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Minimum Spanning Tree Edges and Costs are :");
        minCost = p.prims(cost, n, minCost);
        System.out.println("The Minimum Spanning Tree Cost is :");
        System.out.println(minCost);
    }

    private int prims(int cost[][], int n, int mincost) {
        int nearV[] = new int[10], t[][] = new int[10][3], u = 0, i, j, k;
        for (i = 2; i <= n; i++)
            nearV[i] = 1;
        nearV[1] = 0;
        for (i = 1; i < n; i++) {
            int min = 999;
            for (j = 1; j <= n; j++) {
                if (nearV[j] != 0 && cost[j][nearV[j]] < min) {
                    min = cost[j][nearV[j]];
                    u = j;
                }
            }
            t[i][1] = u;
            t[i][2] = nearV[u];
            mincost += min;
            nearV[u] = 0;
            for (k = 1; k <= n; k++) {
                if (nearV[k] != 0 && cost[k][nearV[k]] > cost[k][u])
                    nearV[k] = u;
            }
            System.out.print("Minimum Edge is (" + t[i][1]);
            System.out.print("," + t[i][2] + ") and its Cost is :" + min + "\n");
        }
        return mincost;
    }
}