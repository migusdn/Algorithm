import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Q1987 {
    static int[][] matrix = null;
    static int maximum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = temp.charAt(j) - 'A';
            }
        }
        search(0, 0, new boolean[26], 0);
        bw.write(String.valueOf(maximum));
        bw.close();
        br.close();
    }

    public static void search(int x, int y, boolean[] visit, int depth) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return;
        }
        int currentGift = matrix[x][y];
        if (visit[currentGift])
            return;
        else {
            visit[currentGift] = true;
            depth++;
            maximum = Math.max(depth, maximum);
            search(x - 1, y, visit.clone(), depth);
            search(x + 1, y, visit.clone(), depth);
            search(x, y - 1, visit.clone(), depth);
            search(x, y + 1, visit.clone(), depth);
        }
    }
}