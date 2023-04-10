import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.replace("apa", "a");
        str = str.replace("epe", "e");
        str = str.replace("ipi", "i");
        str = str.replace("opo", "o");
        str = str.replace("upu", "u");
        bw.write(str);
        bw.close();
        br.close();
    }
}