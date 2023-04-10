import java.io.*;
public class Q11645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(Character.getNumericValue(br.readLine().charAt(0)));

        bw.close();
        br.close();
    }
}
