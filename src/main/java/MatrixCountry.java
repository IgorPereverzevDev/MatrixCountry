/**
 * MatrixCountry
 */
public class MatrixCountry {

    private static void checkElements(int[][] A, int[][] B, int i, int j, int N, int M) {
        if (B[i][j] == -1) {
            return;
        }
        B[i][j] = -1;
        if (i + 1 < N) {
            if (A[i + 1][j] == A[i][j]) {
                checkElements(A, B, i+1, j, N, M);
            }
        }
        if (i - 1 >= 0) {
            if (A[i - 1][j] == A[i][j]) {
                checkElements(A, B, i - 1, j, N, M);
            }
        }
        if (j + 1 < M) {
            if (A[i][j + 1] == A[i][j]) {
                checkElements(A, B, i, j+1, N, M);
            }
        }
        if (j - 1 >= 0) {
            if (A[i][j - 1] == A[i][j]) {
                checkElements(A, B, i, j - 1, N, M);
            }
        }
    }

    private static int solution(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int sum = 0;
        int N = A.length;
        int M = A[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (B[i][j] >= 0) {
                    checkElements(A, B, i, j, N, M);
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] t = {{1, 2, 1}, {1, 1, 1}};
        System.out.print(MatrixCountry.solution(t));
    }
}
