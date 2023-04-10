import java.io.*;
import java.util.StringTokenizer;

class Q10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int width, floor;

            if (n % h == 0) {
                floor = h * 100;
                width = n / h;
            } else {
                floor = (n % h) * 100;
                width = (n / h) + 1;
            }
            int result = floor + width;
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

}