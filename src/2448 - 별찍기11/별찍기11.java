import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 별찍기11
 * @date : 3/12/24 9:12 PM
 * @modifyed : $
 **/
public class 별찍기11 {
    static boolean[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stars = new boolean[n][n * 2 - 1];
        drawStars(0, n - 1, n);
//        defaultStars(0, 12, false);
        printStars();
    }

    public static void drawStars(int r, int c, int size) {
        if (size == 3)
            defaultStars(r, c);
        else {
            int halfSize = size / 2;
            drawStars(r, c, halfSize);
            drawStars(r + halfSize, c + halfSize, halfSize);
            drawStars(r + halfSize, c - halfSize, halfSize);
        }
    }

    public static void defaultStars(int r, int c) {
        stars[r][c] = true;
        stars[r + 1][c - 1] = true;
        stars[r + 1][c + 1] = true;
        stars[r + 2][c - 2] = true;
        stars[r + 2][c - 1] = true;
        stars[r + 2][c - 0] = true;
        stars[r + 2][c + 1] = true;
        stars[r + 2][c + 2] = true;
    }

    public static void printStars() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : stars) {
            for (boolean cell : row) {
                if (cell)
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
