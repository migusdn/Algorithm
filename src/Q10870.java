import java.io.*;

class Q10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n==0)
            bw.write("0");
        else {
            int count = 1;
            int cur = 1;
            int prev = 0;
            while (count != n) {
                int tmp = cur;
                cur += prev;
                prev = tmp;
                count++;
            }
            bw.write(cur + "");
        }
        bw.close();
        br.close();
    }
}