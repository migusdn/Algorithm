import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : Z
 * @date : 1/22/24 9:21 PM
 * @modifyed : $
 **/
public class Z {
    static int n, r, c;
    static int[][] map = {{1, 2}, {3, 4}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(calculate(n,r,c)-1);
    }

    public static int calculate(int n, int r, int c) {
        int halfN = n / 2;
        int halfNPow = halfN*halfN;
        if (halfN == 1) {
            return map[r][c];
        }
        if (r < halfN && c < halfN) {
            return calculate(halfN, r, c);
        } else if (r < halfN && c >= halfN) {
            return halfNPow + calculate(halfN,r,c-halfN);
        } else if (r >= halfN && c < halfN) {
            return halfNPow*2 + calculate(halfN,r-halfN,c);
        } else {
            return halfNPow*3 + calculate(halfN,r-halfN,c-halfN);
        }

    }
}
