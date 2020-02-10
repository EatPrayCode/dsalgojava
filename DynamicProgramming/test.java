package DynamicProgramming;

public class test {

    public static int N = 8;

    public static boolean isSafe(int sol[][], int x, int y) {

        return false;
    }

    public static void solveKT() {

        int sol[][] = new int[8][8];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        printSol(sol);

        sol[0][0] = 0;


    }

    public static boolean solveKTUtil() {

        return false;
    }

    public static void printSol(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        solveKT();
    }

}
