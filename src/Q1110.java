import java.io.*;

public class Q1110 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int tmp=num;
        int ctn=0;
        do {
            ctn++;
            if (tmp < 10)
                tmp = tmp * 11;
            else
                tmp = (tmp % 10) * 10 + (((tmp / 10) + (tmp % 10)) % 10);
        }
        while(num!=tmp);
        bw.write(""+ctn);
        bw.close();
        br.close();
    }
}
