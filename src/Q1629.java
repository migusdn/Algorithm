import java.io.*;
import java.util.StringTokenizer;

class Q1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(String.valueOf(
                pow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
        ));
        bw.close();
        br.close();
    }

    public static long pow(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }

        long n = pow(a, b / 2, c);
        long temp = n * n % c;

        if (b % 2 == 0) {
            return temp;
        } else {
            return a * temp % c;
        }
    }
}