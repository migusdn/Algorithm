import java.io.*;

public class Q14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if(x>0)
            if(y<0)
                bw.write("4");
            else
                bw.write("1");
         else
             if(y<0)
                 bw.write("3");
             else
                 bw.write("2");
        bw.close();
    }
}
