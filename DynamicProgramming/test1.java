
public class test1 {

    public static int N = 8;

    public static void printSol(int sol[][]) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    public static boolean isSafe(int sol[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    public static boolean solveKTUtil(int sol[][], int xMove[], int yMove[], int move, int x, int y) {

        int nextX;
        int nextY;

        if (move == N * N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            nextX = xMove[i] + x;
            nextY = yMove[i] + y;

            if (isSafe(sol, nextX, nextY)) {
                sol[nextX][nextY] = move;
                if (solveKTUtil(sol, xMove, yMove, move + 1, nextX, nextY)) {
                    return true;
                } else {
                    sol[nextX][nextY] = -1;
                    // return false;
                }
            }
        }

        return false;
    }

    public static void solveKT() {

        int sol[][] = new int[N][N];
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        sol[0][0] = 0;

        if (solveKTUtil(sol, xMove, yMove, 1, 0, 0)) {
            printSol(sol);
        } else {
            System.out.println("No solution");
        }

    }

    public static void main(String args[]) {
        solveKT();
    }

}
