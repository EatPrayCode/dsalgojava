// https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
package Backtracking;

class KnightsTour {

    static int N = 8;

    static void solveKT() {

        int sol[][] = new int[8][8];
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        sol[0][0] = 0;

        // printSolution(sol);

        boolean result = solveKTUtil(0, 0, 1, sol, xMove, yMove);

        if (result) {
            printSolution(sol);
        } else {
            System.out.println("No Solution exists");
        }

    }

    static boolean solveKTUtil(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove) {

        int nextX, nextY;

        if (move == N * N) {
            return true;
        }

        for (int k = 0; k < N; k++) {
            nextX = xMove[k] + x;
            nextY = yMove[k] + y;
            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = move;
                if (solveKTUtil(nextX, nextY, move + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        solveKT();
    }

}
