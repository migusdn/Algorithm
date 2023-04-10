import java.io.*;
import java.util.StringTokenizer;

public class Q2884 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m-=45;
        if(m<0) {
            m += 60;
            h -= 1;
        }
        if(h<0)
            h+=24;
        bw.write(h+" "+m);
        bw.close();
    }
}
