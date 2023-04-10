import java.io.*;
import java.util.StringTokenizer;

class Q1780 {
    static int[][] paper;
    static int[] count = new int[3];
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        paper = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(0, 0, n);
        sb.append(minusOne).append("\n");
        sb.append(zero).append("\n");
        sb.append(one).append("\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void cutPaper(int x, int y, int size) {
        if (isValid(x, y, size)) {
            if (paper[x][y] == 0) {
                zero++;
            } else if (paper[x][y] == 1) {
                one++;
            } else if (paper[x][y] == -1) {
                minusOne++;
            }
        } else {
            for (int i = 0; i < size; i += size / 3) {
                for (int j = 0; j < size; j += size / 3) {
                    cutPaper(x + i, y + j, size / 3);

                }
            }
        }
    }

    static boolean isValid(int x, int y, int size) {

        int target = paper[x][y];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (paper[x + i][y + j] != target)
                    return false;
            }
        }
        return true;
    }


}