import java.io.*;

public class Q2753 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        if(year%4==0) {
            if (year % 100 != 0)
                bw.write("1");
            else if (year % 400 == 0)
                bw.write("1");
            else
                bw.write("0");
        }
        else
            bw.write("0");
        bw.close();
    }
}
